package com.stdio.student_management.dao;

import com.stdio.student_management.modal.Student;

import java.util.ArrayList;
import java.util.List;

public class studentDBImpl implements IStudentDB{
    private final static List<Student> students;
    private final static int count;
    private static final String PATH = "students.csv";

    static {
        count = 0;
        students = new ArrayList<>();
    }

    @Override
    public void save() {

    }

    @Override
    public void load() {

    }

    @Override
    public Student getById(int id) {
        return null;
    }

    @Override
    public void add(Student student) {

    }

    @Override
    public void editStudent(int id, Student student) {

    }

    @Override
    public Student deleteById(int id) {
        return null;
    }

    @Override
    public void printListStudent() {

    }

    @Override
    public void sortByGPA() {

    }

    @Override
    public void sortByName() {
    }

    @Override
    public void sortById() {

    }


}
