package com.bibek.resources;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.bibek.beans.Student;

@Configuration
public class SpringConfigFile {
	
	@Bean(name="std1")
	public Student stdObj() {
		Student std = new Student();
		std.setName("Bibek");
		std.setRollno(04);
		return std;
		
	}
	
	@Bean(name="std2")
	public Student stdObj2() {
		Student std = new Student();
		std.setName("Raju");
		std.setRollno(04);
		return std;
		
	}

}
