package com.example.student.entity;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class StudentDetail {
    private int id;
    private String name;
    private String mobileNo;
    private int courseId;
    private Course course;
}
