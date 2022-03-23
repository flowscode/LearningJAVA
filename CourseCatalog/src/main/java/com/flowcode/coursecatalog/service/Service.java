package com.flowcode.coursecatalog.service;

import com.flowcode.coursecatalog.courseObject.Course;
import com.flowcode.coursecatalog.userobject.User;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.math.BigInteger;
import java.util.List;

@org.springframework.stereotype.Service
public class Service {

    @Autowired
    private EurekaClient client;

    public String catalogHome(){
        return "WELCOME TO THE COURSE CATALOG HOME";
    }

    public ResponseEntity<List> fullCatalog(){
        InstanceInfo instanceInfo = client.getNextServerFromEureka("flowfull-course-app",false);
        String courseAppURL = instanceInfo.getHomePageUrl() + "/courses";
        RestTemplate restTemplate = new RestTemplate();
        List results = restTemplate.getForObject(courseAppURL, List.class);
        return new ResponseEntity<>(results, HttpStatus.OK);
    }

    public ResponseEntity<Course> courseById(Long id) {
        InstanceInfo instanceInfo = client.getNextServerFromEureka("flowfull-course-app",false);
        String courseAppURL = instanceInfo.getHomePageUrl()+ "/courses/"+id;
        RestTemplate restTemplate = new RestTemplate();
        Course course = restTemplate.getForObject(courseAppURL, Course.class);
        return new ResponseEntity<>(course, HttpStatus.OK);
    }


    public ResponseEntity<List> getAllUsers(){
        InstanceInfo instanceInfo = client.getNextServerFromEureka("flowfull-user-app", false);
        String userAppURL = instanceInfo.getHomePageUrl() + "/allusers";
        RestTemplate restTemplate = new RestTemplate();
        List results = restTemplate.getForObject(userAppURL, List.class);
        return new ResponseEntity<>(results, HttpStatus.OK);
    }


    public ResponseEntity<List> findUsersById(BigInteger id){
        InstanceInfo instanceInfo = client.getNextServerFromEureka("flowfull-user-app", false);
        String userAppURL = instanceInfo.getHomePageUrl() + "/user/"+id;
        RestTemplate restTemplate = new RestTemplate();
        List results = restTemplate.getForObject(userAppURL, List.class);
        return new ResponseEntity<>(results, HttpStatus.OK);
    }


    public ResponseEntity<List> findUsersByCourseId(BigInteger id){
        InstanceInfo instanceInfo = client.getNextServerFromEureka("flowfull-user-app", false);
        String userAppURL = instanceInfo.getHomePageUrl() + "/course/"+id;
        RestTemplate restTemplate = new RestTemplate();
        List results = restTemplate.getForObject(userAppURL, List.class);
        return new ResponseEntity<>(results, HttpStatus.OK);
    }


    public ResponseEntity<User> adduser(User user){
        InstanceInfo instanceInfo = client.getNextServerFromEureka("flowfull-user-app", false);
        String userAppURL = instanceInfo.getHomePageUrl() + "/adduser";
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(userAppURL, user,User.class);
    }
}
