package com.dark.Service;

import com.dark.Entity.*;
import com.dark.Util.JPAUtil;
import javax.persistence.*;

import java.util.*;

public class AttendanceService {

    public void takeAttendence(List<String> studentsPresent, String classId){
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try{
            tx.begin();
            // Classroom
            Classroom classroom = em.find(Classroom.class,classId);
            if(classroom!=null){
                classroom.setTotalClassesHeld(classroom.getTotalClassesHeld()+1);
                em.merge(classroom);
            }
            // Fro Students
            if(studentsPresent!=null && !studentsPresent.isEmpty()) {
                for (String student : studentsPresent) {
                    Student stu = em.find(Student.class, student);
                    if (stu != null) {
                        stu.setDaysPresent(stu.getDaysPresent() + 1);
                        em.merge(stu);
                    }
                }
                tx.commit();
            }
        } catch (Exception e) {
            if(tx.isActive()){
                tx.rollback();
            }
            System.out.println("There's a problem with the transaction : " + e.getMessage());
        } finally {
            em.close();
        }

    }
}
