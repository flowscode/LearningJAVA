package com.example.student.entity;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class Course {
    private int id;
    private String name;
    private int duration;
}
