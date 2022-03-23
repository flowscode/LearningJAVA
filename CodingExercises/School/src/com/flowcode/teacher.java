package com.flowcode;

import java.util.ArrayList;

public class teacher {

    private int iD = 20000;
    private String firstName;
    private String lastName;
    private int age;
    private String emailAddress;
    private String subject;
    private ArrayList<Student> students = new ArrayList<Student>();

    private static int count;

    public teacher() {
        count++;
        this.iD += count;
    }

    public int getID() {
        return iD;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void addStudent(Student student){
        students.add(student);
    }

    public void showStudents(){
        System.out.println("\n" + this.firstName + " " + this.lastName + " : " + getSubject());
        if (students.isEmpty()){
            System.out.println("NO STUDENTS FOUND");
            return;
        }
        int count = 1;
        for (Student s:students) {
            System.out.println(count + ") " + s.getFirstName() + " " + s.getLastName());
            count++;
        }
        System.out.println("=====================================");
    }
}
