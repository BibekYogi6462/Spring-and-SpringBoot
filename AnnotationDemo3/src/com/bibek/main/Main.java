package com.bibek.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bibek.beans.Student;
import com.bibek.resources.JavaConfigFile;

public class Main {
    public static void main(String[] args) {

        ApplicationContext context =
            new AnnotationConfigApplicationContext(JavaConfigFile.class);

        Student std = (Student) context.getBean("student");

        std.Display();
    }
}
