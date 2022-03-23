package com.flowcode.courseapp.services;

import com.flowcode.courseapp.entity.Course;
import com.flowcode.courseapp.exceptions.IdNotFound;
import com.flowcode.courseapp.exceptions.NoDataFound;
import com.flowcode.courseapp.repos.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;

import javax.persistence.NoResultException;
import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
public class Service {
    @Autowired
    private Repository repository;


    public List<Course> showCourses() throws NoDataFound {
        if (repository.count() < 1){
            throw new NoDataFound("Unable to find data in database");
        }
        return repository.findAll();
    }

    public Course addCourse(Course course) {
        return repository.save(course);
    }

    public Course updateCourse(Course course, BigInteger id) throws IdNotFound {
        Course result = repository.findById(id).orElseThrow(
                () -> new IdNotFound("Course with ID " + id +" was not found"));
        result.setCourseName(course.getCourseName());
        result.setAuthor(course.getAuthor());
        return repository.save(result);
    }

    public Course deleteCourse(BigInteger id) {
        Course toDelete = repository.findById(id).orElseThrow(() -> new IdNotFound("Course with ID " + id +" was not found, nothing to delete"));
        repository.deleteById(id);
        return toDelete;
    }

    public Course showCourse(BigInteger id) throws IdNotFound{
        return repository.findById(id).orElseThrow(() -> new IdNotFound("Course with ID " + id +" was not found"));
    }
}
