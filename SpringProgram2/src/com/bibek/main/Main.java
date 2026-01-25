package com.bibek.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bibek.beans.Student;

public class Main {
  public static void main(String[] args) {
	ApplicationContext container = new ClassPathXmlApplicationContext("/com/bibek/resources/applicationContext.xml");
	Student std = (Student) container.getBean("stdObj");
	std.display();
}
}
