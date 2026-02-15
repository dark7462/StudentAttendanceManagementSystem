package com.dark.Entity;

import javax.persistence.*;

@Entity
public class Teacher {
    @Id
    private String emp_id;
    private String name;
    private String password;
    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "class_id")
    private Classroom classroom;

    public String getEmp_id() {
        return emp_id;
    }
    public void setEmp_id(String emp_id) {
        this.emp_id = emp_id;
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

    public Teacher(String emp_id, String name, String password, Classroom classroom) {
        this.emp_id = emp_id;
        this.name = name;
        this.password = password;
        this.classroom = classroom;
    } public Teacher() {}
}