package com.stdio.student_management.dao;

import java.io.IOException;

import com.stdio.student_management.modal.Student;

public interface IStudentDB {
    public void save() throws IOException;
    public void load() throws IOException;
    public Student getById(int id);
    public void add(Student student);
    public void editStudent(int id, Student student);
    public boolean deleteById(int id);
    public void printListStudent();
    public void sortByGPA();
}
