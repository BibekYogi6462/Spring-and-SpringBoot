package com.bibek.main;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.bibek.entity.Student;

public class App {
    public static void main(String[] args) {

        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("main-persistence-unit");
        EntityManager em = emf.createEntityManager();

        try {
            String jpqlQuery = "SELECT s FROM Student s WHERE s.id = :stdId";
            TypedQuery<Student> query = em.createQuery(jpqlQuery,Student.class);
            query.setParameter("stdId", 102);
           Student s = query.getSingleResult();
           System.out.println(
                   s.getId() + " | " +
                   s.getName() + " | " +
                   s.getEmail() + " | " +
                   s.getMarks()
           );

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
            emf.close();
        }
    }
}
