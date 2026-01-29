package com.bibek.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bibek.beans.Student;
import com.bibek.resources.SpringConfigfile;

public class Main {
    public static void main(String[] args) {

        ApplicationContext context =
                new AnnotationConfigApplicationContext(SpringConfigfile.class);

        Student std = (Student) context.getBean(Student.class);
        std.display();
    }
}
