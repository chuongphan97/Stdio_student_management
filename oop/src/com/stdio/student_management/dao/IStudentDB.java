package com.stdio.student_management.dao;

import com.stdio.student_management.modal.Student;

import java.io.IOException;
import java.util.List;

public interface IStudentDB {
    public void save() throws IOException;
    public void load() throws IOException;
    public Student getById(int id);
    public void add(Student student) throws IOException;
    public void editStudent(int id, Student student);
    public Student deleteById(int id) throws IOException;
    public void printListStudent();
    public List<String> searchByName(String name);
    public void sortByGPA();
    public void sortByName();
    public void sortById();
}
