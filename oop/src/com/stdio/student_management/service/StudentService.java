package com.stdio.student_management.service;

import com.stdio.student_management.dao.IStudentDB;
import com.stdio.student_management.dao.StudentDB;
import com.stdio.student_management.modal.Student;

public class StudentService implements IStudentService {
    private final IStudentDB studentDB = new StudentDB();

    @Override
    public void add(Student student) {

    }

    @Override
    public Student deleteById(int id) {
        return null;
    }

    @Override
    public void putScore(int id, double newFirstScoreX1, double newSecondScoreX1, double newScoreX2, double newScoreX3) {

    }

    @Override
    public void editStudent(int id, String newName, String newGender) {

    }

    @Override
    public void printList() {

    }

    @Override
    public void loadFromDB() {

    }
}
