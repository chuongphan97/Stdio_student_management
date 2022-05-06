package com.stdio.student_management.view;

import com.stdio.student_management.modal.Student;
import com.stdio.student_management.service.IStudentService;
import com.stdio.student_management.service.StudentServiceImpl;

import java.io.IOException;
import java.util.Scanner;


public class Main {
    private static final IStudentService studentService = new StudentServiceImpl();
    public static void main(String[] agrs) throws IOException {
        try {
            studentService.loadFromDB();
            showMenu();
            while (true) {
                int choose = new Scanner(System.in).nextInt();
                switch (choose) {
                    case 1:
                        addStudent();
                        break;
                    case 2:
                        deleteStudent();
                        break;
                    case 3:
                        putScore();
                        break;
                    case 4:
                        editStudent();
                        break;
                    case 5:
                        printStudent();
                        break;
                    case 6:
                        studentService.sortByGPA();
                        break;
                    case 7:
                        studentService.sortByName();
                        break;
                    case 8:
                        studentService.sortById();
                        break;
                    case 9:
                        findName();
                        break;
                    case 0:
                        System.out.println("exit");
                        System.exit(0);


                }
                showMenu();
            }
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    public static void showMenu() {

        System.out.println("-----------menu------------");
        System.out.println("1. Add student.");
        System.out.println("2. Delete student by student id.");
        System.out.println("3. Put score for student by student id.");
        System.out.println("4. Edit student information .");
        System.out.println("5. Print list student.");
        System.out.println("6. Sort GPA.");
        System.out.println("7. Sort Name.");
        System.out.println("8. Sort Id.");
        System.out.println("9. Find Name.");
        System.out.println("0. exit.");
        System.out.println("---------------------------");
        System.out.print("Please choose: ");

    }

    public  static  void addStudent() throws IOException {

        System.out.println("enter student name:");
        String name = new Scanner(System.in).nextLine();
        System.out.println("enter student gender");
        String gender = new Scanner(System.in).nextLine();
        studentService.add(name,gender);
        System.out.println("Added New Student");

    }

    public static void deleteStudent() throws IOException {

        System.out.println("enter id:");
        int id = new Scanner(System.in).nextInt();
        studentService.deleteById(id);

    }

    public static void putScore() throws IOException {

        System.out.println("enter id:");
        int id = new Scanner(System.in).nextInt();
        System.out.println("enter firstScoreX1:");
        double fs1 = new Scanner(System.in).nextDouble();
        System.out.println("enter secondScoreX1:");
        double ss1 = new Scanner(System.in).nextDouble();
        System.out.println("enter scoreX2:");
        double sc1 = new Scanner(System.in).nextDouble();
        System.out.println("enter scoreX3:");
        double sc2 = new Scanner(System.in).nextDouble();
        studentService.putScore(id,fs1,ss1,sc1,sc2);
        System.out.println("Added New Score");

    }

    public static void editStudent() throws IOException {

        System.out.println("enter id:");
        int id = new Scanner(System.in).nextInt();
        System.out.println("enter student name:");
        String name = new Scanner(System.in).nextLine();
        System.out.println("enter student gender");
        String gender = new Scanner(System.in).nextLine();
        studentService.editStudent(id,name,gender);


    }
     public static void printStudent() throws IOException {

        studentService.printList();

     }

     public static void findName() throws IOException {
        System.out.println("input name:");
        String name = new Scanner(System.in).nextLine();
        studentService.findName(name);
     }


}
