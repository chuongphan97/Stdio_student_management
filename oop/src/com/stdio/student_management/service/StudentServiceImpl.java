package com.stdio.student_management.service;

import com.stdio.student_management.dao.IStudentDB;
import com.stdio.student_management.dao.studentDBImpl;
import com.stdio.student_management.modal.Student;

public class StudentServiceImpl implements IStudentService {
    private final IStudentDB studentDB = new studentDBImpl();

    @Override
    public void add(String name, String gender) {

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
