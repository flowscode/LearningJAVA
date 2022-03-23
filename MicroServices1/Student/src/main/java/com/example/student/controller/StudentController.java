package com.example.student.controller;

import com.example.student.entity.Student;
import com.example.student.entity.StudentDetail;
import com.example.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.management.InvalidAttributeValueException;
import javax.persistence.NoResultException;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService service;

    @GetMapping("/idwebclient")
    public StudentDetail getByIdUsingWebClient(@RequestParam (value = "id") int id) throws NoResultException{
        return service.getByIdUsingWebClient(id);
    }

    @GetMapping
    public String home(){
        return "Welcome to the Student server";
    }

    @GetMapping("/all")
    public ResponseEntity<List> getAllStudents() throws NoResultException{
        return service.showAllStudents();
    }

    @GetMapping("/id")
    public Student getById(@RequestParam(value = "id") int id) throws NoResultException {
        return service.getById(id);
    }

    @GetMapping("/detail")
    public StudentDetail getDetailById(@RequestParam(value = "id") int id) throws NoResultException {
        return service.getDetailById(id);
    }

    @GetMapping("/name")
    public ResponseEntity<List> getByName(@RequestParam(value = "name") String name){
        return service.getByName(name);
    }

    @PostMapping("/add")
    public ResponseEntity<Student> addStudent(@RequestBody Student student){
        return service.saveStudent(student);
    }

    @PutMapping("/editname")
    public ResponseEntity<Student> editNameById(
            @RequestParam(value = "id") int id,
            @RequestParam(value = "name") String name)
            throws NoResultException{
        return service.editNameById(id,name);
    }

    @PutMapping("/editmobileno")
    public ResponseEntity<Student> editMobileNoById(
            @RequestParam(value = "id") int id,
            @RequestParam(value = "mobile") String number)
            throws NoResultException{
        return service.editMobById(id,number);
    }

    @PutMapping("/editcourse")
    public ResponseEntity<Student> editCourseId(
            @RequestParam(value = "id") int id,
            @RequestParam(value = "courseid") int courseId)
            throws NoResultException{
        return service.editCourseId(id,courseId);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Boolean> deleteStudent(@RequestParam(value = "id") int id) throws NoResultException {
        return service.deleteUser(id);
    }



}
