package com.dark.Entity;

import javax.persistence.*;

@Entity
public class Student {
    @Id
    @Column(name = "roll_number")
    private String rollNumber;
    private String name;
    private String password;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "class_id")
    private Classroom classroom;
    @Column(name = "days_present")
    private int daysPresent;

    public String getRollNumber() {
        return rollNumber;
    }
    public void setRollNumber(String rollNumber) {
        this.rollNumber = rollNumber;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public Classroom getClassroom() {
        return classroom;
    }
    public void setClassroom(Classroom classroom) {
        this.classroom = classroom;
    }

    public int getDaysPresent() {
        return daysPresent;
    }
    public void setDaysPresent(int daysPresent) {
        this.daysPresent = daysPresent;
    }

    public Student(String rollNumber, String name, String password, Classroom classroom, int class_present) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.password = password;
        this.classroom = classroom;
        this.daysPresent = class_present;
    }
    public Student() {}

    // attendence percent age
    public double getAttendencePercentage() {
        if( classroom == null || classroom.getTotalClassesHeld() < 1 || daysPresent == 0) return 0.0;
        return ((double) daysPresent /classroom.getTotalClassesHeld())*100;
    }

}