package com.stdio.student_management.view;

import com.stdio.student_management.service.IStudentService;
import com.stdio.student_management.service.StudentServiceImpl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final IStudentService studentService = new StudentServiceImpl();
    //Tim kiem gan dung vd: chuogn -> chuong
    private static Scanner sc = new Scanner(System.in);
    private static int page = 0;

    private static void printMenu() {
        System.out.println("1.Add student\n" +
                "2. Delete student by student id\n" +
                "3. Put score for student by student id\n" +
                "4. Edit student information (edit name +)\n" +
                "5. Print list student\n" +
                "6. Search name student\n" +
                "7. Exist\n");
    }
    private static void addStudent() {
        String name, gender;
        System.out.print("Enter a name: ");
        name = sc.nextLine();
        System.out.print("Enter a gender: ");
        gender = sc.nextLine();
        try {
            studentService.add(name,gender);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static void deleteStudentbyId() {
        System.out.println("Enter a id: ");
        int id = sc.nextInt();
        try {
            System.out.println("Sinh vien bi xoa:  " + studentService.deleteById(id));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static void putScore() {
        System.out.print("Enter a id: ");
        int id = sc.nextInt();
        System.out.print("Enter a FirstScoreX1: ");
        double firstscoreX1 = sc.nextDouble();
        System.out.print("Enter a SecondScoreX1: ");
        double secondscoreX1 = sc.nextDouble();
        System.out.print("Enter a ScoreX2: ");
        double scoreX2 = sc.nextDouble();
        System.out.print("Enter a ScoreX3: ");
        double scoreX3 = sc.nextDouble();
        try {
            studentService.putScore(id,firstscoreX1,secondscoreX1,scoreX2,scoreX3);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static void editStudent() throws IOException {
        System.out.println("Enter a id: ");
        int id = Integer.parseInt(sc.nextLine());
        System.out.println("Enter a new name: ");
        String newName = sc.nextLine();
        System.out.println("Enter a new gender: ");
        String newGender = sc.nextLine();
        studentService.editStudent(id,newName,newGender);
    }
    private static void loadMore() {
        studentService.printList();
    }
    private static void printListStudent() {
        studentService.printList();
        System.out.println("Your next choice:\n"
                        + "0. Exit\t\t"
                        + "1. Load More");
        int choice = sc.nextInt();
        while (choice!=0) {
            switch (choice) {
                case 0:
                    break;
                case 1:
                    loadMore();
                    break;
            }
            System.out.println("Your next choice:\n"
                    + "0. Exit\t\t"
                    + "1. Load More");
            choice = sc.nextInt();
        }

    }
    private static void Menu() throws IOException {
        printMenu();
        System.out.print("Enter your choice: ");
        int choice = Integer.parseInt(sc.nextLine());
        while (choice!=7) {
            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    deleteStudentbyId();
                    break;
                case 3:
                    putScore();
                    break;
                case 4:
                    editStudent();
                    break;
                case 5:
                    printListStudent();
                    break;
                case 6:
                    searchStudentName();
                    break;
            }
            printMenu();
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();
        }
    }

    private static void searchStudentName() {
        System.out.print("Enter name: ");
        String nameFind = sc.nextLine();
        List<String>  nameFound = studentService.searchByName(nameFind);
        System.out.println("Name found: ");
        for (String name:
             nameFound) {
            System.out.println(name);
        }
    }

    public static void main(String[] args) {
        try {
            studentService.loadFromDB();
            Menu();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
