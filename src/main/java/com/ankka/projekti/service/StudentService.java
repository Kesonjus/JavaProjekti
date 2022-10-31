package com.ankka.projekti.service;

import com.ankka.projekti.data.students;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentFileService myFileService;

    // Creates a method for adding a new student

    public void addStudent(students student) throws IOException {
        myFileService.writeStudentsToFile(student);
    }

    // Creates a method for reading data from students.txt file in StudentFileService class

    public List<students> readStudents() {
        try {
            return myFileService.readStudents();

        } catch (final Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // Creates a method to add a new stundent on a course

    public String addStudentToCourse(String studentId, String courseId) {
        List<students> students = myFileService.readStudents();
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getStudentId().equals(studentId)) {
                students.get(i).addCourse(courseId);
                try {
                    myFileService.writeStudentsToFile(students);

                } catch (IOException e) {
                    e.printStackTrace();
                }
                return "Student added to course";
            }
        }
        return "Student not found";

    }

    // Creates a method to remove a student from a course, distinguished by student id and course id

    public String removeStudentFromCourse(String studentId, String courseId) {
        List<students> students = myFileService.readStudents();
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getStudentId().equals(studentId)) {
                students.get(i).removeCourse(courseId);
                try {
                    myFileService.writeStudentsToFile(students);

                } catch (IOException e) {
                    e.printStackTrace();
                }
                return "Student removed from course";
            }
        }
        return "Student not found";

    }

    // Creates a method to edit student data, distinguished by student id

    public String editStudent(String studentId, String fname, String lname, String age) {
        List<students> students = myFileService.readStudents();
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getStudentId().equals(studentId)) {
                students.get(i).setFname(fname);
                students.get(i).setLname(lname);
                students.get(i).setAge(age);
                try {
                    myFileService.writeStudentsToFile(students);

                } catch (IOException e) {
                    e.printStackTrace();
                }
                return "Student edited";
            }
        }
        return "Student not found";

    }

    // Creates a method to delete all student data, distinguished by student id

    public String removeStudent(String studentId) {
        List<students> students = myFileService.readStudents();
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getStudentId().equals(studentId)) {
                students.remove(i);
                try {
                    myFileService.writeStudentsToFile(students);

                } catch (IOException e) {
                    e.printStackTrace();
                }
                return "Student removed";
            }
        }
        return "Student not found";

    }

}
