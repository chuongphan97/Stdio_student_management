package com.stdio.student_management.service;

import com.stdio.student_management.dao.IStudentDB;
import com.stdio.student_management.dao.studentDBImpl;
import com.stdio.student_management.modal.Student;


import java.io.IOException;


public class StudentServiceImpl implements IStudentService {
    private final IStudentDB studentDB = new studentDBImpl();

    @Override
    public void add(String name, String gender) throws IOException {
       studentDB.add(new Student(name,gender));
       studentDB.save();
    }


    @Override
    public Student deleteById(int id) throws IOException {
       Student student = studentDB.deleteById(id);
       studentDB.save();
        return student;
    }

    @Override
    public void putScore(int id, double newFirstScoreX1, double newSecondScoreX1, double newScoreX2, double newScoreX3) throws IOException {
        Student student = new Student(newFirstScoreX1,newSecondScoreX1,newScoreX2,newScoreX3);
        studentDB.editStudent(id,student);
        studentDB.save();
    }

    @Override
    public void editStudent(int id, String newName, String newGender) throws IOException {
        Student student = new Student(newName,newGender);
        studentDB.editStudent(id,student);
        studentDB.save();

    }

    @Override
    public void printList() throws IOException {

          studentDB.printListStudent();
    }

    @Override
    public void loadFromDB() throws IOException {
       studentDB.load();
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

    @Override
    public void findName(String name) throws IOException {
        studentDB.findName(name);

    }
}
