package com.stdio.student_management.dao;

import com.stdio.student_management.modal.Student;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class StudentDB implements IStudentDB{
    private final static List<Student> students;
    private static int count;
    private static final String PATH = "students.csv";
    
    static {
        count = 0;
        students = new ArrayList<>();
    }
    
    File getFile() {
    	return new File(PATH);
    }

    Boolean isExists() {
    	return getFile().exists();
    }
    
    @Override
    public void save() throws IOException{
    	if (!isExists()) {
    		getFile().createNewFile();
    	}
    	FileWriter writer = new FileWriter(getFile());
    	for (Student student : students) {
    		writer.write(student.toStringCSV());
		}
    }

    @Override
    public void load() throws IOException{
    	if (!isExists()) {
    		new IOException("Cannot load file");
    		return;
    	}
    	Scanner reader = new Scanner(getFile());
    	while (reader.hasNextLine()) {
			String buffer = reader.nextLine();
			String[] s =buffer.split(",");
			int id = Integer.parseInt(s[0]);
		    String name = s[1];
		    String gender= s[2];
		    double firstScoreX1= Double.parseDouble(s[3]);
		    double secondScoreX1= Double.parseDouble(s[4]);
		    double scoreX2= Double.parseDouble(s[5]);
		    double scoreX3= Double.parseDouble(s[6]);
		    double gpa= Double.parseDouble(s[7]);
			students.add(new Student(id, name, gender, firstScoreX1, secondScoreX1, scoreX2, scoreX3, gpa));
			count++;
		}
    }

    @Override
    public Student getById(int id) {
    	for (int i=0; i<count; ++i) {
			if (students.get(i).getId() == id)
				return students.get(i);
		}
    	return null;
    }

    @Override
    public void add(Student student) {
    	for (int i=0; i<count; ++i) {
			if (students.get(i).getId() == student.getId())
				return;
		}
    	students.add(student);
    	count++;
    }

    @Override
    public void editStudent(int id, Student student) {
    	for (int i=0; i<count; ++i) {
    		if (students.get(i).getId() == id) {
				students.set(i, student);
				return;
			}
		}
    }

    @Override
    public boolean deleteById(int id) {
    	Student result = null;
    	for (int i=0; i<count; ++i) {
			if (students.get(i).getId() == id) {
				result = students.remove(i);
				count--;
			}
		}
    	return result!=null;
    }

    @Override
    public void printListStudent() {
    	for (int i=0; i<count; ++i) {
			System.out.println(students.get(i).toString());
		}
    }

    @Override
    public void sortByGPA() {
    	Collections.sort(students, new Comparator<Student>() {
    		public int compare(final Student l, Student r) {
    			return l.getGpa() > r.getGpa()? 1 : (l.getGpa() < r.getGpa()? -1 : 0);
    		}
		});
    }
}
