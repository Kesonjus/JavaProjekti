package com.ankka.projekti.controller;

import com.ankka.projekti.data.courses;
import com.ankka.projekti.data.students;
import com.ankka.projekti.service.StudentService;
import com.ankka.projekti.service.CourseService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class restController {

    @Autowired
    StudentService studentService;
    @Autowired
    CourseService courseService;

    @GetMapping("/students")
    public List<students> readStudents() throws IOException {
        return studentService.readStudents();
    }

    @PostMapping("/addstudent")
    public String addStudent(@RequestBody students student) throws IOException {
        studentService.addStudent(student);
        return "Student added";

    }

    @GetMapping("/courses")
    public List<courses> readCourses() throws IOException {
        return courseService.readCourses();
    }

    @PostMapping("/addcourse")
    public String addCourse(@RequestBody courses course) throws IOException {
        courseService.addCourse(course);
        return "Course added";
    }

    @PostMapping("/addstudenttocourse")
    public String addStudentToCourse(@RequestBody Map<String, String> json) {
        String studentId = json.get("studentId");
        String courseId = json.get("courseId");
        return studentService.addStudentToCourse(studentId, courseId);

    }

    @PostMapping("/removestudentfromcourse")
    public String removeStudentFromCourse(@RequestBody Map<String, String> json) {
        String studentId = json.get("studentId");
        String courseId = json.get("courseId");
        return studentService.removeStudentFromCourse(studentId, courseId);

    }

    @PostMapping("/editcourse")
    public String editCourse(@RequestBody Map<String, String> json) {
        String courseId = json.get("courseId");
        String courseName = json.get("courseName");
        String opettaja = json.get("opettaja");
        String luokka = json.get("luokka");
        return courseService.editCourse(courseId, courseName, opettaja, luokka);

    }

    @PostMapping("/removecourse")
    public String removeCourse(@RequestBody Map<String, String> json) {
        String courseId = json.get("courseId");
        return courseService.removeCourse(courseId);
    }

    @PostMapping("/editstudent")
    public String editStudent(@RequestBody Map<String, String> json) {
        String studentId = json.get("studentId");
        String fname = json.get("fname");
        String lname = json.get("lname");
        String age = json.get("age");
        return studentService.editStudent(studentId, fname, lname, age);
    }

    @PostMapping("/removestudent")
    public String removeStudent(@RequestBody Map<String, String> json) {
        String studentId = json.get("studentId");
        return studentService.removeStudent(studentId);
    }
}
