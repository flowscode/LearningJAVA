package com.flowcode.userapp.repository;

import com.flowcode.userapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;
import java.util.List;

public interface Repo extends JpaRepository<User, Long> {
    List<User> findByuserId(BigInteger id);
    List<User> findByCourseId(BigInteger id);
    Boolean existsByUserIdAndCourseId(BigInteger userId, BigInteger courseId);
}
