package com.bibek.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.bibek.beans.Student;
import com.bibek.resources.SpringConfigFile;

public class Main {
	public static void main(String[] args) {
		
		
		ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfigFile.class);
		
		Student std = (Student) context.getBean("std1");
		std.display();
		Student std1 = (Student) context.getBean("std2");
		std1.display();
	}

}
