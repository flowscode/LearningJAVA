package com.example.student.service;

import com.example.student.entity.Course;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.persistence.NoResultException;
import java.util.List;

@Service
public class ApiCall {

    @Autowired RestTemplate restTemplate;


    private static final String courseMicroserviceBaseURL = "http://course-service";

    @CircuitBreaker(name = "example", fallbackMethod = "fallback")
    public Course getCourseDetails(int courseId){
        Course course = restTemplate.getForObject(
                courseMicroserviceBaseURL + "/course/id?id={courseId}",Course.class, courseId);
        return course;
    }

    public Course fallback(Exception ex){
        Course course = new Course();
        course.setId(9999);
        course.setName("common-course");
        course.setDuration(1);
        return course;
    }
}
