package com.bibek.Hb.main;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.bibek.beans.Student;
import com.bibek.util.HibernateUtil;

public class App {
    public static void main(String[] args) {

        Student std = new Student();
        std.setStdId(1);
        std.setName("Bibek");
        std.setRollno(4);
        std.setEmail("bibek@gmail.com");
        std.setGender("Male");
        std.setCity("Kathmandu");

        Transaction tx = null;

        try (Session session =
                HibernateUtil.getSessionFactory().openSession()) {

            tx = session.beginTransaction();

            session.persist(std);   // modern alternative to save()

            tx.commit();
            System.out.println("Success");

        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }
}
