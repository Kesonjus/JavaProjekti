package com.ankka.projekti.data;

public class courses {
    private String courseId;
    private String courseName;
    private String opettaja;
    private String luokka;


    public courses(String courseId, String courseName, String opettaja, String luokka) {
        this.courseName = courseName;
        this.opettaja = opettaja;
        this.luokka = luokka;
        this.courseId = courseId;
    }

    public courses() {
        this("", "", "", "");
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getOpettaja() {
        return opettaja;
    }

    public void setOpettaja(String opettaja) {
        this.opettaja = opettaja;
    }

    public String getLuokka() {
        return luokka;
    }

    public void setLuokka(String luokka) {
        this.luokka = luokka;
    }

}
