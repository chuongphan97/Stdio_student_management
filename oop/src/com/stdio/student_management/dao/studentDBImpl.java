package com.stdio.student_management.dao;

import com.stdio.student_management.modal.Student;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class studentDBImpl implements IStudentDB{
    private final static List<Student> students;
    private static int count;
    private static final String PATH = "students.csv";
    private static int page = 0;
    static {
        count = 0;
        students = new ArrayList<>();
    }

    @Override
    public void save() throws IOException {
        File file = new File(PATH);
        if(!file.exists()) {
            file.createNewFile();
        } else {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(PATH));
            for (Student s : students) {
                bufferedWriter.write(s.toStringCSV());
            }
            System.out.println("Ghi file thành công!");
            bufferedWriter.close();
        }
    }

    @Override
    public void load() throws IOException {
        FileInputStream fileInputStream = new FileInputStream(PATH);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
        String line = bufferedReader.readLine();
        while (line != null) {
            String[] list = line.split(",");
            students.add(new Student(Integer.parseInt(list[0]),list[1],list[2],Double.parseDouble(list[3]),Double.parseDouble(list[3])
                    ,Double.parseDouble(list[3]),Double.parseDouble(list[3]),Double.parseDouble(list[3])));
            line = bufferedReader.readLine();
            count = Integer.parseInt(list[0]);
        }
        fileInputStream.close();
        bufferedReader.close();
    /*    for (Student s:
             students) {
            System.out.println(s.toStringCSV());
        }*/
}

    @Override
    public Student getById(int id) {
        for (Student s:
             students) {
            if(s.getId() == id) return s;
        }
        return null;
    }

    @Override
    public void add(Student student) throws IOException {
        ++count;
        student.setId(count);
        students.add(student);
        save();
    }

    @Override
    public void editStudent(int id, Student student) {
        for (Student s:
             students) {
            if(s.getId() == id) {
                s.setName(student.getName());
                s.setGender(student.getGender());
                s.setFirstScoreX1(student.getFirstScoreX1());
                s.setSecondScoreX1(student.getSecondScoreX1());
                s.setScoreX2(student.getScoreX2());
                s.setScoreX3(student.getScoreX3());
                s.setGpa((student.getFirstScoreX1()+student.getSecondScoreX1()+ student.getScoreX2()*2 + student.getScoreX3()*3)/7);
            }
        }
    }

    @Override
    public Student deleteById(int id) throws IOException {
        for (Student s:
                students) {
            if(s.getId() == id) {
                students.remove(s);
                count--;
                save();
                return s;
            }
        }
        return null;
    }

    @Override
    public void printListStudent() {
        try {
            if (count - page >= 5) {
                for (int i = page; i < page + 5 ; i++) {
                    System.out.println(students.get(i).toStringCSV());
                }
                if(count - page > 5) {
                    page+=5;
                }
            } else {
                for (int i = page; i < count; i++) {
                    System.out.println(students.get(i).toStringCSV());
                }
            }
        }
        catch(IndexOutOfBoundsException e) {
            System.out.println("Index out of bounds exception => " + e.getMessage());
        }

    }

    @Override
    public List<String> searchByName(String name) {
        Pattern pattern = Pattern.compile(name, Pattern.CASE_INSENSITIVE);
        Matcher matcher;
        List<String> nameFound = new ArrayList<>();
        for (Student s:
             students) {
            matcher = pattern.matcher(s.getName());
            if (matcher.find()) {
                nameFound.add(s.getName());
            }
        }
        return nameFound;
    }

    @Override
    public void sortByGPA() {
        Collections.sort(students, Comparator.comparingDouble(Student::getGpa));
    }

    @Override
    public void sortByName() {
        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
    }

    @Override
    public void sortById() {
        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getId() > o2.getId() ? (o1.getId() == o2.getId() ? 0 : 1 ) : -1;
            }
        });
    }


}
