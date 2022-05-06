package com.stdio.student_management.dao;

import com.stdio.student_management.modal.Student;


import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class studentDBImpl implements IStudentDB{
    private final static List<Student> students;
    private static int count;
    private static final String PATH = "students.csv";

    static {
        count = 0;
        students = new ArrayList<>();
    }

    @Override
    public void save() throws IOException {
        File file = new File(PATH);
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(PATH));

        for (Student student : students) {
            bufferedWriter.write(student.toStringCSV());
        }
        bufferedWriter.close();
    }

    @Override
    public void load() throws IOException {
        List<Student> students2 = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(PATH));
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            String[] arr = line.split(",");
            students2.add(new Student(Integer.parseInt(arr[0]), arr[1], arr[2],Double.parseDouble(arr[3]),Double.parseDouble(arr[4]),Double.parseDouble(arr[5]),Double.parseDouble(arr[6]),Double.parseDouble(arr[7])));
        }
        bufferedReader.close();
        for (Student s :
                students2) {
            System.out.println(s.toStringCSV());
        }

    }

    @Override
    public void findName(String name) {
        for (int i = 0;i<students.size();i++ ){
            if (students.get(i).getName().contains(name)){
                System.out.println(students.get(i).toStringCSV());
            }
        }

    }

    @Override
    public Student getById(int id) {
        for (Student s: students) {
            if (s.getId()==id){
                return s;
            }
        }
       return null ;
    }


    @Override
    public void add(Student student) {
        student.setId(++count);
        students.add(student);
    }

    @Override
    public void editStudent(int id, Student student) {
        for (Student st:
            students ) {
            if (st.getId()== id ){
                if(null!=student.getName()){
                    st.setName(student.getName());
                }
                if (null!=student.getGender()){
                    st.setGender(student.getGender());
                }
                if (student.getFirstScoreX1()!=0){
                    st.setFirstScoreX1(student.getFirstScoreX1());
                }
                if (student.getSecondScoreX1()!=0){
                    st.setSecondScoreX1(student.getSecondScoreX1());
                }
                if (student.getScoreX2()!=0){
                    st.setScoreX2(student.getScoreX2());
                }
                if (student.getScoreX3()!=0){
                    st.setScoreX3(student.getScoreX3());
                }
                if (student.getGpa()!=0){
                    st.setGpa(student.getGpa());
                }
            }
        }
    }

    @Override
    public Student deleteById(int id) {
        Student student= this.getById(id);
        students.remove(student);
        return student;
    }

    @Override
    public void printListStudent() {
        int count=1;
        for (int i = 0;i<students.size();i++) {
             System.out.println(students.get(i).toStringCSV());
          if (count%5==0){
              menu();
              int choose= new Scanner(System.in).nextInt();
              switch (choose){
                  case 1:
                      break;
                  case 2:
                      System.exit(0);
              }
          }
          count++;
        }

    }

    @Override
    public void sortByGPA() {
      students.sort((o1, o2) -> {
          return Double.compare(o1.getGpa(),o2.getGpa());
      });
    }

    @Override
    public void sortByName() {
        Collections.sort(students,(o1, o2) -> {
            return o1.getName().compareTo(o2.getName());
        });
    }

    @Override
    public void sortById() {
       students.sort((o1, o2) -> {
           return Integer.compare(o1.getId(),o2.getId());
       });
    }
    public static void menu(){
        System.out.println("------menu------");
        System.out.println("1.load 5 student");
        System.out.println("2.exit");
        System.out.println("please choose:");
    }

}
