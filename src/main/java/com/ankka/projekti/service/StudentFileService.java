package com.ankka.projekti.service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.stereotype.Service;
import com.ankka.projekti.data.students;
import com.google.gson.Gson;

@Service
public class StudentFileService implements Serializable {
    Gson gson = new Gson();

    // Creates a method for writing student data to students.txt file in json format

    public void writeStudentsToFile(students student) throws IOException {
        FileWriter f = new FileWriter(new File("students.txt"), true);
        f.write(gson.toJson(student) + System.lineSeparator());
        f.close();
    }

    public List<students> writeStudentsToFile(List<students> students) throws IOException {
        FileWriter fi = new FileWriter(new File("students.txt"), false);
        for (students student : students) {
            fi.write(gson.toJson(student) + System.lineSeparator());
        }
        fi.close();
        return students;
    }

    // Creates a method to reads student data from students.txt file

    public List<students> readStudents() {
        List<students> student = new ArrayList<>();

        try {
            Scanner sc = new Scanner(new File("students.txt"));
            while (sc.hasNextLine()) {
                student.add(gson.fromJson(sc.nextLine(), students.class));
            }
            sc.close();
            return student;
        } catch (FileNotFoundException e) {
            return student;
        }
    }
}