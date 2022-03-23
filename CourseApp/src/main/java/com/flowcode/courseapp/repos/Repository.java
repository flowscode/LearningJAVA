package com.flowcode.courseapp.repos;

import com.flowcode.courseapp.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface Repository extends JpaRepository<Course, BigInteger> {
}
