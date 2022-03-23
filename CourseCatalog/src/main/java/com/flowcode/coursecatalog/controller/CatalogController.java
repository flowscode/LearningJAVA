package com.flowcode.coursecatalog.controller;

import com.flowcode.coursecatalog.courseObject.Course;
import com.flowcode.coursecatalog.service.Service;
import com.flowcode.coursecatalog.userobject.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.math.BigInteger;
import java.util.List;

@RestController
public class CatalogController {

    @Autowired
    private Service service;

    @RequestMapping("/")
    public String catalogHome(){
        return service.catalogHome();
    }

    @RequestMapping("/coursecatalog")
    public ResponseEntity<List> fullCatalog(){
        return service.fullCatalog();
    }

    @RequestMapping("/coursecatalog/{id}")
    public ResponseEntity<Course> courseById(@PathVariable Long id) {
        return service.courseById(id);
    }

    @RequestMapping("/usercatalog")
    public ResponseEntity<List> getAllUsers(){
        return service.getAllUsers();
    }

    @RequestMapping("/usercatalog/userid/{id}")
    public ResponseEntity<List> findUsersById(@PathVariable BigInteger id){
        return service.findUsersById(id);
    }

    @RequestMapping("/usercatalog/courseid/{id}")
    public ResponseEntity<List> findUsersByCourseId(@PathVariable BigInteger id){
        return service.findUsersByCourseId(id);
    }

    @PostMapping("/usercatalog/adduser")
    public ResponseEntity<User> adduser(@RequestBody User user){
        return service.adduser(user);
    }


}
