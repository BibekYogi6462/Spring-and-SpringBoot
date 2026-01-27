package com.bibek.resources;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.bibek.beans.Employee;

@Configuration
public class EmpConfigFile {
	
	
	@Bean
	public Employee empObj() {
		Employee emp = new Employee();
		emp.setEmpId(1);
		emp.setEmpName("Bibek Meployee");
		
		return emp;
		
	}

}
