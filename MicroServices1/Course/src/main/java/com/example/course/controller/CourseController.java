package com.example.course.controller;

import com.example.course.entity.Course;
import com.example.course.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.NoResultException;
import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService service;

    @GetMapping
    public String home(){
        return "Welcome to the Course server";
    }

    @GetMapping("/all")
    public ResponseEntity<List> getAllCourses(){
        return service.getAllCourses();
    }

    @PostMapping("/add")
    public ResponseEntity<Course> addCourse(@RequestBody Course course){
        return service.addCourse(course);
    }

    @GetMapping("/id")
    public ResponseEntity<Course> getCourseById(@RequestParam(value = "id") int id) throws NoResultException {
        return service.getCourseById(id);
    }

    @PutMapping("/update")
    public ResponseEntity<Course> updateCourse(@RequestBody Course course, @RequestParam(value = "id") int id) throws NoResultException{
        return service.updateCourse(course,id);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Boolean> deleteCourse(@RequestParam(value = "id") int id) throws NoResultException{
        return service.deleteCourse(id);
    }
}
