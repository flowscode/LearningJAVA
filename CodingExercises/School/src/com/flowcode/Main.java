package com.flowcode;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Locale;

public class Main {

        private static Collection<teacher> allTeachers = new ArrayList<>();
        private static ArrayList<Student> allStudents = new ArrayList<>();

    public static void main(String[] args) {


        //TEACHERS
        teacher sarah = recruitTeacher("Sarah", "Jane", "Math");
        teacher brown = recruitTeacher("Brown", "King", "English");
        teacher laurel = recruitTeacher("Laurel", "Dee", "Science");
        teacher rick = recruitTeacher("Rick", "Lee", "History");
        teacher micky = recruitTeacher("Micky", "Mouse", "History");
        teacher charles = recruitTeacher("Charles", "Khan", "PE");

        //STUDENTS
        Student bobRisky = acceptStudent("Bob", "Risky", 14);
        Student rolland = acceptStudent("Rolland", "Highland", 16);

        //ENROLMENT DAY
        enrol(bobRisky,"Math");
        enrol(bobRisky,"Science");


        //SHOW TEACHER'S STUDENTS
        showStudents(sarah);
        showStudents(brown);
        showStudents(laurel);
        showStudents(rick);
        showStudents(micky);
        showStudents(charles);

        //SHOW STUDENT'S TEACHERS
        showTeachers(bobRisky);
        showTeachers(rolland);


    }

    public static teacher recruitTeacher(String firstName, String lastName, String subject){
        teacher teacher = new teacher();
        teacher.setFirstName(firstName);
        teacher.setLastName(lastName);
        teacher.setSubject(subject);
        allTeachers.add(teacher);
        return teacher;
    }

    public static Student acceptStudent(String firstName, String lastName, int age){
        Student student = new Student();
        student.setFirstName(firstName);
        student.setLastName(lastName);
        student.setAge(age);
        allStudents.add(student);
        return student;
    }

    public static void enrol(Student student, String lesson){
        for (String l: student.getLessons()) {
            if (l.equals(lesson)){
                System.out.println(student.getFirstName() + " is already enrolled");
                return;
            }
        }

        if (!allTeachers.isEmpty()){
            int search = 0;
            for (teacher t: allTeachers) {
                if (t.getSubject().equals(lesson)){
                    t.addStudent(student);
                    student.enrol(lesson);
                    student.addTeacher(t);
                    break;
                }
                search++;
            }
            if (search == allTeachers.size()){
                System.out.println("No teacher to teach that lesson");
            }
        } else {
            System.out.println("No Teachers");
        }
    }

    public static void showTeachers(Student student){
        student.showTeachers();
    }
    public static void showStudents(teacher teacher){
        teacher.showStudents();
    }
}
