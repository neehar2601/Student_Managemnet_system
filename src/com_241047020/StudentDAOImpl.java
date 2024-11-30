package com_241047020;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.io.FileInputStream;

public class StudentDAOImpl implements StudentDAO {
    private Connection connection;

    public StudentDAOImpl() {
        try {
            Properties props = new Properties();
            FileInputStream fis = new FileInputStream("db.properties");
            props.load(fis);
            String url = props.getProperty("db.url");
            String username = props.getProperty("db.username");
            String password = props.getProperty("db.password");
            connection = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            System.err.println("Database connection error: " + e.getMessage());
        }
    }

    @Override
    public void addStudent(Student student) {
        try {
            String query = "INSERT INTO Students (rollNumber, name, dob, subject, contactNumber) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.setInt(1, student.getRollNumber());
            pstmt.setString(2, student.getName());
            pstmt.setString(3, student.getDob());
            pstmt.setString(4, student.getSubject());
            pstmt.setString(5, student.getContactNumber());
            pstmt.executeUpdate();
            System.out.println("Student added successfully.");
        } catch (SQLException e) {
            System.err.println("Error adding student: " + e.getMessage());
        }
    }

    @Override
    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        try {
            String query = "SELECT * FROM Students";
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Student student = new Student(
                        rs.getInt("rollNumber"),
                        rs.getString("name"),
                        rs.getString("dob"),
                        rs.getString("subject"),
                        rs.getString("contactNumber")
                );
                students.add(student);
            }
        } catch (SQLException e) {
            System.err.println("Error fetching students: " + e.getMessage());
        }
        return students;
    }

    @Override
    public Student getStudentByRollNumber(int rollNumber) throws StudentNotFoundException {
        try {
            String query = "SELECT * FROM Students WHERE rollNumber = ?";
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.setInt(1, rollNumber);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new Student(
                        rs.getInt("rollNumber"),
                        rs.getString("name"),
                        rs.getString("dob"),
                        rs.getString("subject"),
                        rs.getString("contactNumber")
                );
            } else {
                throw new StudentNotFoundException("Student with roll number " + rollNumber + " not found.");
            }
        } catch (SQLException e) {
            throw new StudentNotFoundException("Error fetching student: " + e.getMessage());
        }
    }
}
