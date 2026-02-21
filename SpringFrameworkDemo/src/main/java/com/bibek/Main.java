package com.bibek;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
//        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);
       Doctor doctor = context.getBean(Doctor.class);
       doctor.assist();
       doctor.setQualification("MBBS");
        System.out.println(doctor);



//        System.out.println(staff.getQualification());
    }
}