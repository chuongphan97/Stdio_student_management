package com.stdio.student_management.dao;

import com.stdio.student_management.modal.Student;

import java.io.IOException;

public interface IStudentDB {
    public void save() throws IOException;
    public void load() throws IOException;
    public void findName(String name);
    public Student getById(int id);
    public void add(Student student);
    public void editStudent(int id, Student student);
    public Student deleteById(int id);
    public void printListStudent();
    public void sortByGPA();
    public void sortByName();
    public void sortById();
}
