package com.stdio.student_management.modal;

public class Student {
    int id;
    String name;
    String gender;
    double firstScoreX1;
    double secondScoreX1;
    double scoreX2;
    double scoreX3;
    double gpa;

    public Student() {
    }

    public Student(int id, String name, String gender, double firstScoreX1, double secondScoreX1, double scoreX2, double scoreX3, double gpa) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.firstScoreX1 = firstScoreX1;
        this.secondScoreX1 = secondScoreX1;
        this.scoreX2 = scoreX2;
        this.scoreX3 = scoreX3;
        this.gpa = gpa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public double getFirstScoreX1() {
        return firstScoreX1;
    }

    public void setFirstScoreX1(double firstScoreX1) {
        this.firstScoreX1 = firstScoreX1;
    }

    public double getSecondScoreX1() {
        return secondScoreX1;
    }

    public void setSecondScoreX1(double secondScoreX1) {
        this.secondScoreX1 = secondScoreX1;
    }

    public double getScoreX2() {
        return scoreX2;
    }

    public void setScoreX2(double scoreX2) {
        this.scoreX2 = scoreX2;
    }

    public double getScoreX3() {
        return scoreX3;
    }

    public void setScoreX3(double scoreX3) {
        this.scoreX3 = scoreX3;
    }

    public double getGpa() {
        return gpa;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", firstScoreX1=" + firstScoreX1 +
                ", secondScoreX1=" + secondScoreX1 +
                ", scoreX2=" + scoreX2 +
                ", scoreX3=" + scoreX3 +
                ", gpa=" + gpa +
                '}';
    }

    public String toStringCSV(){
        return id + "," +
                name + "," +
                gender + "," +
                firstScoreX1 + "," +
                secondScoreX1 + "," +
                scoreX2 + "," +
                scoreX3 + "," +
                gpa + "\n";
    }
}