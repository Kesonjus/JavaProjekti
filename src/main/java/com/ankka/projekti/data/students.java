package com.ankka.projekti.data;

import java.util.ArrayList;
import java.util.List;

// Creates a class for student data, which also includes a list of courses that the student is enrolled in

public class students {
    private String fname;
    private String lname;
    private String studentId;
    private String age;
    private List<String> courses = new ArrayList<>();

    public students(String fname, String lname, String studentId, String age) {
        this.fname = fname;
        this.lname = lname;
        this.age = age;
        this.studentId = studentId;
        
    }

    public students() {
        this("", "", "", "");
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getStudentId() {
        return this.studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void addCourse(String course) {
        this.courses.add(course);
    }

    public void removeCourse(String course) {
        this.courses.remove(course);
    }

}
