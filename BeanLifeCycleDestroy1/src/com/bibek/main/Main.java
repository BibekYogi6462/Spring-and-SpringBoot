package com.bibek.main;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bibek.beans.Student;

public class Main {
  public static void main(String[] args) {
	AbstractApplicationContext context = new ClassPathXmlApplicationContext("/com/bibek/resources/applicationContext.xml");
	Student std = (Student) context.getBean("stdId");
	std.display();
	
	context.registerShutdownHook();
}
}
