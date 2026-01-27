package com.bibek.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bibek.beans.Employee;
import com.bibek.beans.Student;
import com.bibek.resources.EmpConfigFile;
import com.bibek.resources.StdConfigFile;

public class Main {
	public static void main(String[] args) {
//		ApplicationContext context = new ClassPathXmlApplicationContext("/com/bibek/resources/stdAppContext.xml",
//				"com/bibek/resources/empAppContext.xml");
//		Student std = (Student) context.getBean("stdObj");
//		Employee emp = (Employee) context.getBean("empObj");
//		
//		std.stdDisplay();
//		emp.empDisplay();
		
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(StdConfigFile.class, EmpConfigFile.class);
		
		Student std = (Student) context.getBean("stdObj");
		Employee emp = (Employee) context.getBean("empObj");
		
		std.stdDisplay();
		emp.empDisplay();
		
		
		
		
	}

}
