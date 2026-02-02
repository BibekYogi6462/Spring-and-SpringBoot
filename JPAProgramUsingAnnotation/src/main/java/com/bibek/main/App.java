package com.bibek.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.bibek.entity.Student;

public class App {
    public static void main(String[] args) {

        Student std = new Student();
        std.setId(2);
        std.setName("Bibek");
        std.setEmail("bibek@gmail.com");
        std.setMarks(94.7f);

        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("main-persistence-unit");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        try {
            et.begin();
            em.persist(std);   // ✅ FIXED
            et.commit();
            System.out.println("Success");

        } catch (Exception e) {
            e.printStackTrace();
            et.rollback();
            System.out.println("Failed");
        } finally {
            em.close();       // ✅ correct
            emf.close();
        }
    }
}
