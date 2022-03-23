package com.flowcode.userapp.controllers;

import com.flowcode.userapp.entity.User;
import com.flowcode.userapp.exceptions.UsersNotFoundException;
import com.flowcode.userapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService service;

    @RequestMapping("/")
    public String userAppHome(){
        return "this is the UserApp Home";
    }

    @RequestMapping("/allusers")
    public ResponseEntity<List> getAllUsers() throws UsersNotFoundException {
        return new ResponseEntity<>(service.getAllUsers(),HttpStatus.OK);
    }

    @RequestMapping("/user/{id}")
    public ResponseEntity<List> findById(@PathVariable BigInteger id){
        return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
    }

    @RequestMapping("/course/{id}")
    public ResponseEntity<List> findByCourseId(@PathVariable BigInteger id){
        return new ResponseEntity<>(service.findByCourseId(id), HttpStatus.OK);
    }

    @PostMapping("/adduser")
    public ResponseEntity<User> addUser(@RequestBody User user) throws DuplicateKeyException {
        return new ResponseEntity<>(service.addUser(user), HttpStatus.OK);
    }






}
