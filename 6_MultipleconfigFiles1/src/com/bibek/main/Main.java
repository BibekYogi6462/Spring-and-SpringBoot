package com.bibek.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bibek.beans.Employee;
import com.bibek.beans.Student;

public class Main {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("/com/bibek/resources/stdAppContext.xml",
				"com/bibek/resources/empAppContext.xml");
		Student std = (Student) context.getBean("stdObj");
		Employee emp = (Employee) context.getBean("empObj");
		
		std.stdDisplay();
		emp.empDisplay();		
		
	}

}
