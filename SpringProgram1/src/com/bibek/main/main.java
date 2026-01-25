package com.bibek.main;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.bibek.beans.Student;

public class main {
    public static void main(String[] args) {
    	Resource resource = new ClassPathResource("/com/bibek/resources/applicationContext.xml");
		BeanFactory container = new XmlBeanFactory(resource);
		
		Student std = (Student) container.getBean("std");
		std.display();
	}
}
