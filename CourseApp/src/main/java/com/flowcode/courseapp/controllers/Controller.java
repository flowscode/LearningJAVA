package com.flowcode.courseapp.controllers;
import com.flowcode.courseapp.entity.Course;
import com.flowcode.courseapp.exceptions.IdNotFound;
import com.flowcode.courseapp.exceptions.NoDataFound;
import com.flowcode.courseapp.services.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping
public class Controller {

    @Autowired
    private Service service;

    @GetMapping("/")
    public String courseAppHome(){
        return "This is the home of the CourseApp that talks to the database";
    }

    @GetMapping("/courses")
    public ResponseEntity<List> getAllCourses() throws NoDataFound {
        return new ResponseEntity<>(service.showCourses(), HttpStatus.OK);
    }

    @GetMapping("/courses/{id}")
    public ResponseEntity<Course> getAllCourses(@PathVariable BigInteger id) throws IdNotFound {
        return new ResponseEntity<>(service.showCourse(id), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Course> addCourse(@RequestBody Course course){
        return new ResponseEntity<>(service.addCourse(course), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Course> updateCourse(@PathVariable BigInteger id, @RequestBody Course course ) throws IdNotFound {
        return new ResponseEntity<>(service.updateCourse(course, id), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Course> deleteCourse(@PathVariable BigInteger id) throws IdNotFound{
        return new ResponseEntity<>(service.deleteCourse(id), HttpStatus.OK);
    }
}
