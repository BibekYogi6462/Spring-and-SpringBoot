package com.bibek.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bibek.beans.Student;

public class Main {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/bibek/resources/applicationCOntext.xml");
		
		Student std1 = (Student) context.getBean("stdObj");
		std1.display();
		
		Student std2 = (Student) context.getBean("stdObj2");
		std2.display();
		
	}

}
