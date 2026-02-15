package com.dark.Entity;

import javax.persistence.*;
import java.util.*;

@Entity
public class Classroom {
    @Id
    @Column(name ="class_id")
    private String class_id; // Field name can stay with underscore if you want

    @Column(name = "class_held")
    private int totalClassesHeld;

    @OneToMany(mappedBy = "classroom")
    private List <Student> students;

    // --- FIX STARTS HERE ---

    // Change getClass_id() -> getClassId()
    public String getClassId() {
        return class_id;
    }

    // Change setClass_id() -> setClassId()
    public void setClassId(String class_id) {
        this.class_id = class_id;
    }

    // --- FIX ENDS HERE ---

    public int getTotalClassesHeld() {
        return totalClassesHeld;
    }
    public void setTotalClassesHeld(int totalClassesHeld) {
        this.totalClassesHeld = totalClassesHeld;
    }

    public List<Student> getStudents() {
        return students;
    }
    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public Classroom(String class_id, int totalClassesHeld) {
        this.class_id = class_id;
        this.totalClassesHeld = totalClassesHeld;
    }
    public Classroom() {}
}