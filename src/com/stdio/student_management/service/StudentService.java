package com.stdio.student_management.service;

import java.io.IOException;

import com.stdio.student_management.dao.IStudentDB;
import com.stdio.student_management.dao.StudentDB;
import com.stdio.student_management.modal.Student;

public class StudentService implements IStudentService {
    private final IStudentDB studentDB = new StudentDB();

    @Override
    public void add(Student student) {
    	studentDB.add(student);
    }

    @Override
    public boolean deleteById(int id) {
        return studentDB.deleteById(id);
    }

    @Override
    public void putScore(int id, double newFirstScoreX1, double newSecondScoreX1, double newScoreX2, double newScoreX3) {
    	
    }

    @Override
    public void editStudent(int id, String newName, String newGender) {
    	Student editStudent = studentDB.getById(id);
    	editStudent.setName(newName);
    	editStudent.setGender(newGender);
    }

    @Override
    public void printListSortedByGpa() {
    	studentDB.sortByGPA();
    	studentDB.printListStudent();
    }

    @Override
    public void loadFromDB() throws IOException{
    	studentDB.load();
    }

	@Override
	public void saveToDB() {
		// TODO Auto-generated method stub
		
	}
}
