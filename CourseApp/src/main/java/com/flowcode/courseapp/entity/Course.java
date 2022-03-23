package com.flowcode.courseapp.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Course {

    @Id
    @Column(nullable = false, unique = true)
    private BigInteger courseId;

    @Column(nullable = false, unique = true)
    private String courseName;

    @Column(nullable = false)
    private String author;

}
