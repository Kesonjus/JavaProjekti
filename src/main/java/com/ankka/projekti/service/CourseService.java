package com.ankka.projekti.service;

import com.ankka.projekti.data.courses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class CourseService {

    @Autowired
    CourseFileService courseFileService;

    // Creates a method for adding a new course

    public void addCourse(courses course) throws IOException {
        courseFileService.writeCoursesToFile(course);
    }

    // Creates a method for reading data from courses.txt file in CourseFileService class

    public List<courses> readCourses() {
        try {
            return courseFileService.readCourses();

        } catch (final Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // Creates a method to edit course data, distinguished by course id

    public String editCourse(String courseId, String courseName, String opettaja, String luokka) {
        List<courses> courses = courseFileService.readCourses();
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getCourseId().equals(courseId)) {
                courses.get(i).setCourseName(courseName);
                courses.get(i).setOpettaja(opettaja);
                courses.get(i).setLuokka(luokka);
                try {
                    courseFileService.writeCoursesToFile(courses);

                } catch (IOException e) {
                    e.printStackTrace();
                }
                return "Course edited";
            }
        }
        return "Course not found";

    }

    // Creates a method to delete all course data, distinguished by course id

    public String removeCourse(String courseId) {
        List<courses> courses = courseFileService.readCourses();
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getCourseId().equals(courseId)) {
                courses.remove(i);
                try {
                    courseFileService.writeCoursesToFile(courses);

                } catch (IOException e) {
                    e.printStackTrace();
                }
                return "Course deleted";
            }
        }
        return "Course not found";

    }

}
