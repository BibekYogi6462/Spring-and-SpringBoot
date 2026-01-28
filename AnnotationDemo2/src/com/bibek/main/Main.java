package com.bibek.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bibek.beans.Student;

public class Main {
    public static void main(String[] args) {

        ApplicationContext context =
            new ClassPathXmlApplicationContext("com/bibek/resources/applicationContext.xml");

        Student std = (Student) context.getBean("student");

        std.Display();
    }
}
