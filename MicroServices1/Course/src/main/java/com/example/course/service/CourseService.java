package com.example.course.service;

import com.example.course.entity.Course;
import com.example.course.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.persistence.NoResultException;
import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseRepository repository;

    public ResponseEntity<List> getAllCourses() throws NoResultException {
        List<Course> results = repository.findAll();
        if (results.isEmpty()){
            throw new NoResultException("No Course' found");
        } else {
            return new ResponseEntity<>(results, HttpStatus.OK);
        }
    }

    public ResponseEntity<Course> getCourseById(int id) throws NoResultException{
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e){
//            e.printStackTrace();
//        }
        Course result = repository.findById(id).orElseThrow(() -> new NoResultException("Course ID "  + id + " not found, try a different Course ID"));
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    public ResponseEntity<Course> addCourse(Course course) {
        Course saved = repository.save(course);
        return new ResponseEntity<>(saved, HttpStatus.OK);
    }

    public ResponseEntity<Course> updateCourse(Course course, int id) throws NoResultException{
        Course result = repository.findById(id).orElseThrow(() -> new NoResultException("Course ID "  + id + " not found, try a different Course ID"));
        result.setName(course.getName());
        result.setDuration(course.getDuration());
        return new ResponseEntity<>(repository.save(result), HttpStatus.OK);
    }

    public ResponseEntity<Boolean> deleteCourse(int id) throws NoResultException{
        Course result = repository.findById(id).orElseThrow(() -> new NoResultException("Course ID "  + id + " not found, try a different Course ID"));
        repository.delete(result);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }
}
