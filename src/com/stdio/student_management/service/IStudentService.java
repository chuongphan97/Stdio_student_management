package com.stdio.student_management.service;

import com.stdio.student_management.modal.Student;

public interface IStudentService {
    public void add(Student student);
    public boolean deleteById(int id);
    public void putScore(int id, double newFirstScoreX1, double newSecondScoreX1, double newScoreX2, double newScoreX3);
    public void editStudent(int id, String newName, String newGender);
    public void printListSortedByGpa();
    public void loadFromDB();
    public void saveToDB();
}
