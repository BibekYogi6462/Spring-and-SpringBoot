package com.bibek.resources;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.bibek.beans.Address;
import com.bibek.beans.Student;



@Configuration
public class SpringConfigfile {
	
	
	@Bean
	public Address createAddrObj() {
		Address addr = new Address();
		addr.setHouseno(4);
		addr.setCity("ktm");
		addr.setPincode(56);
		
		return addr;
	}
	
	@Bean
	public Student createStdObj() {
		Student std = new Student();
		std.setName("Bibek");
		std.setRollno(5);
		std.setAddress(createAddrObj());
		
		return std;
	}


}
