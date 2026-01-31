package com.bibek.Hb.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.bibek.beans.Student;

public class App {
    public static void main(String[] args) {

        Student std = new Student();
        std.setStdId(1);
        std.setName("Bibek");
        std.setRollno(4);
        std.setEmail("bibek@gmail.com");
        std.setGender("Male");
        std.setCity("Kathmandu");

        Configuration cfg = new Configuration();
        cfg.configure("/com/bibek/resources/hibernate.cfg.xml");

        SessionFactory sessionFactory = cfg.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        try {
            session.save(std);
            transaction.commit();
            System.out.println("Success");
        } catch (Exception e) {
            transaction.rollback();
            System.out.println("Failed");
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
