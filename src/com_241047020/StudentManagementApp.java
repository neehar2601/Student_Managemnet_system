package com_241047020;

import java.util.Scanner;

public class StudentManagementApp {
    public static void main(String[] args) {
        StudentDAO studentDAO = new StudentDAOImpl();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Student Information System ---");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student by Roll Number");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Roll Number: ");
                    int rollNumber = scanner.nextInt();
                    scanner.nextLine(); // consume newline
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter DOB (YYYY-MM-DD): ");
                    String dob = scanner.nextLine();
                    System.out.print("Enter Subject: ");
                    String subject = scanner.nextLine();
                    System.out.print("Enter Contact Number: ");
                    String contactNumber = scanner.nextLine();

                    Student student = new Student(rollNumber, name, dob, subject, contactNumber);
                    studentDAO.addStudent(student);
                    break;

                case 2:
                    for (Student s : studentDAO.getAllStudents()) {
                        System.out.println(s);
                    }
                    break;

                case 3:
                    System.out.print("Enter Roll Number to Search: ");
                    int searchRoll = scanner.nextInt();
                    try {
                        Student foundStudent = studentDAO.getStudentByRollNumber(searchRoll);
                        System.out.println(foundStudent);
                    } catch (StudentNotFoundException e) {
                        System.err.println(e.getMessage());
                    }
                    break;

                case 4:
                    System.out.println("Exiting... Goodbye!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
