package com.bibek.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.bibek.beans.Student;

public class Main {
 public static void main(String[] args) {
	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
	context.register(Student.class);
	context.refresh();
	Student std  = (Student) context.getBean("student");
	
	std.Display();
}
}
