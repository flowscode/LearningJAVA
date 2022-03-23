package com.flowcode;

import java.util.ArrayList;

public class Student {

    public static int count;

    private int iD = 10000;
    private String firstName;
    private String lastName;
    private int age;

    private ArrayList<String> lessons = new ArrayList<>();
    private ArrayList<teacher> teachers = new ArrayList<teacher>();

    public Student() {
        count++;
        this.iD +=count;
    }

    public int getiD() {
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

    public void enrol(String lesson){
        lessons.add(lesson);
        System.out.println(this.firstName + " has enrolled in " + lesson);
    }

    public ArrayList<String> getLessons(){
        return lessons;
    }

    public void addTeacher(teacher teacher){
        teachers.add(teacher);
    }

    public void showTeachers(){
        System.out.println("\n" + this.firstName + " " + this.lastName + " : TEACHERS");
        if (teachers.isEmpty()){
            System.out.println("NO TEACHERS FOUND");
            return;
        }
        int count = 1;
        for (teacher t:teachers) {
            System.out.println(count + ") " + t.getFirstName() + " " + t.getLastName() + " : " + t.getSubject());
            count++;
        }
        System.out.println("=====================================");
    }
}
