package com_241047020;

import java.util.List;

public interface StudentDAO {
    void addStudent(Student student);
    List<Student> getAllStudents();
    Student getStudentByRollNumber(int rollNumber) throws StudentNotFoundException;
}

