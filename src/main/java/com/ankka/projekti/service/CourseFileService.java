package com.ankka.projekti.service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.stereotype.Service;
import com.ankka.projekti.data.courses;
import com.google.gson.Gson;

@Service
public class CourseFileService implements Serializable {
    Gson gson = new Gson();

    // Creates a method for writing course data to courses.txt file in json format

    public void writeCoursesToFile(courses course) throws IOException {
        FileWriter f = new FileWriter(new File("courses.txt"), true);
        f.write(gson.toJson(course) + System.lineSeparator());
        f.close();
    }

    public List<courses> writeCoursesToFile(List<courses> courses) throws IOException {
        FileWriter fi = new FileWriter(new File("courses.txt"), false);
        for (courses course : courses) {
            fi.write(gson.toJson(course) + System.lineSeparator());
        }
        fi.close();
        return courses;
    }

    // Creates a method to reads course data from courses.txt file

    public List<courses> readCourses() {
        List<courses> course = new ArrayList<>();

        try {
            Scanner sc = new Scanner(new File("courses.txt"));
            while (sc.hasNextLine()) {
                course.add(gson.fromJson(sc.nextLine(), courses.class));
            }
            sc.close();
            return course;
        } catch (FileNotFoundException e) {
            return course;
        }
    }
}