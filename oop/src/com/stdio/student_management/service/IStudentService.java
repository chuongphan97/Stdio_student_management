package com.stdio.student_management.service;

import com.stdio.student_management.modal.Student;

import java.io.IOException;

public interface IStudentService {

    public void add(String name, String gender) throws IOException;
    public Student deleteById(int id) throws IOException;
    public void putScore(int id, double newFirstScoreX1, double newSecondScoreX1, double newScoreX2, double newScoreX3) throws IOException;
    public void editStudent(int id, String newName, String newGender) throws IOException;
    public void printList() throws IOException;
    public void loadFromDB() throws IOException;
    public void sortByGPA();
    public void sortByName();
    public void sortById();
    public void findName(String name)throws IOException;
}
