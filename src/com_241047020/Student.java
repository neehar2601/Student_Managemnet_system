package com_241047020;

public class Student {
    private int rollNumber;
    private String name;
    private String dob;
    private String subject;
    private String contactNumber;

    public Student(int rollNumber, String name, String dob, String subject, String contactNumber) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.dob = dob;
        this.subject = subject;
        this.contactNumber = contactNumber;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public String getName() {
        return name;
    }

    public String getDob() {
        return dob;
    }

    public String getSubject() {
        return subject;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    @Override
    public String toString() {
        return "Roll No: " + rollNumber + ", Name: " + name + ", DOB: " + dob +
                ", Subject: " + subject + ", Contact: " + contactNumber;
    }
}
