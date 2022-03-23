package com.example.student.service;

import com.example.student.entity.Course;
import com.example.student.entity.Student;
import com.example.student.entity.StudentDetail;
import com.example.student.repository.StudentRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import javax.management.InvalidAttributeValueException;
import javax.persistence.NoResultException;
import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repository;

    @Autowired
    private ApiCall apiCall;

    @Autowired
    private ApiCallUsingWebClient apiCallUsingWebClient;


    public ResponseEntity<List> showAllStudents(){
        return new ResponseEntity<>(repository.findAll(), HttpStatus.OK);
    }

    public Student getById(int id) throws NoResultException{
        Student result = repository.findById(id).orElseThrow(
                () -> new NoResultException("No results found with that ID: "+ id));
        return result;
    }

    public ResponseEntity<List> getByName(String name) throws NoResultException{
        List results = repository.findByName(name);
        if (results.isEmpty()){
            throw new NoResultException("No results found with that name");
        } else {
            return new ResponseEntity<>(results, HttpStatus.OK);
        }
    }

    public ResponseEntity<Student> saveStudent(Student student) throws NoResultException {
        Course courseExists =  apiCall.getCourseDetails(student.getCourseId());
            Student saved = repository.save(student);
            return new ResponseEntity<>(saved, HttpStatus.OK);

    }

    public ResponseEntity<Student> editNameById(int id, String name) {
        Student result = repository.findById(id).orElseThrow(() -> new NoResultException("ID not found: " +id));
        result.setName(name);
        Student saved = repository.save(result);
        return new ResponseEntity<>(saved, HttpStatus.OK);
    }

    public ResponseEntity<Student> editMobById(int id, String number){
        Student result = repository.findById(id).orElseThrow(() -> new NoResultException("ID not found: " +id));
        result.setMobileNo(number);
        Student saved = repository.save(result);
        return new ResponseEntity<>(saved, HttpStatus.OK);
    }

    public ResponseEntity<Boolean> deleteUser(int id) throws NoResultException{
        Student result = repository.findById(id).orElseThrow(() -> new NoResultException("ID not found: " +id));
        repository.delete(result);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

    public StudentDetail getDetailById(int id) throws NoResultException {
        Student result = repository.findById(id).orElseThrow(() -> new NoResultException("ID not found: " +id));
        Course course = apiCall.getCourseDetails(result.getCourseId());

        StudentDetail studentDetail = new StudentDetail();
        BeanUtils.copyProperties(result,studentDetail);
        studentDetail.setCourse(course);
        return studentDetail;
    }

    public ResponseEntity<Student> editCourseId(int id, int courseId) throws NoResultException {
        Student result = repository.findById(id).orElseThrow(() -> new NoResultException("ID not found: " +id));
        result.setCourseId(courseId);
        repository.save(result);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    public StudentDetail getByIdUsingWebClient(int id) throws NoResultException {
        Student result = repository.findById(id).orElseThrow(() -> new NoResultException("ID not found: " +id));

        Mono<Course> courseMono = apiCallUsingWebClient.getCourseDetails(result.getCourseId());
        Course course = courseMono.block();

        StudentDetail sd = new StudentDetail();

        BeanUtils.copyProperties(result, sd);
        sd.setCourse(course);
        return sd;
    }
}
