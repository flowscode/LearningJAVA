package com.flowcode.courseapp;

import com.flowcode.courseapp.entity.Course;
import com.flowcode.courseapp.repos.Repository;
import com.flowcode.courseapp.services.Service;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigInteger;

@SpringBootTest
class CourseAppApplicationTests {

    @Autowired
    private Service service;

    @Autowired
    private Repository repo;

    @Test
    void addTest() {
        Course course = new Course(BigInteger.valueOf(999),"Test Course","Test Author");
        Course added = service.addCourse(course);
        System.out.println(added.getCourseName() + " was added");
        added = service.updateCourse(new Course(BigInteger.valueOf(9999),"Test Update", "Test Author  Update"), added.getCourseId());
        System.out.println(added.getCourseName() + " was updated");
        service.deleteCourse(added.getCourseId());
        System.out.println(added.getCourseName() + " was deleted");
    }



}
