package com.stdio.student_management.service;

import com.stdio.student_management.dao.IStudentDB;
import com.stdio.student_management.dao.studentDBImpl;
import com.stdio.student_management.modal.Student;

import java.io.IOException;
import java.util.List;

public class StudentServiceImpl implements IStudentService {
    private final IStudentDB studentDB = new studentDBImpl();

    @Override
    public void add(String name, String gender) {
        Student student = new Student(name,gender);
        try {
            studentDB.add(student);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Student deleteById(int id) throws IOException {
        return studentDB.deleteById(id);
    }

    @Override
    public void putScore(int id, double newFirstScoreX1, double newSecondScoreX1, double newScoreX2, double newScoreX3) {
        if(id == studentDB.getById(id).getId()) {
            studentDB.getById(id).setFirstScoreX1(newFirstScoreX1);
            studentDB.getById(id).setSecondScoreX1(newSecondScoreX1);
            studentDB.getById(id).setScoreX2(newScoreX2);
            studentDB.getById(id).setScoreX3(newScoreX3);
            studentDB.getById(id).setGpa((newFirstScoreX1+newSecondScoreX1+newScoreX2*2 + newScoreX3*3)/7);
        }
    }

    @Override
    public void editStudent(int id, String newName, String newGender) {
        if(id == studentDB.getById(id).getId()) {
            studentDB.getById(id).setName(newName);
            studentDB.getById(id).setGender(newGender);
            studentDB.editStudent(id, studentDB.getById(id));
        }
    }

    @Override
    public void printList() {
        studentDB.printListStudent();
    }

    @Override
    public List<String> searchByName(String name) {
        return studentDB.searchByName(name);
    }

    @Override
    public void loadFromDB() {
        try {
            studentDB.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void sortByGPA() {
        studentDB.sortByGPA();
    }

    @Override
    public void sortByName() {
        studentDB.sortByName();
    }

    @Override
    public void sortById() {
        studentDB.sortById();
    }
}
