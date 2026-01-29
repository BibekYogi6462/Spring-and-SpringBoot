package com.bibek.resources;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.bibek.beans.Address;
import com.bibek.beans.Student;

@Configuration
public class SpringConfigFile {
	@Bean
	public Address createAddrObj() {
		Address addr = new Address();
		addr.setHouseno(123);
		addr.setCity("Ktm");
		addr.setPincode(452);
		
		return addr;
	}
	
	
	@Bean("stdId")
	public Student createStdObj() {
		Student std = new Student();
		std.setName("Bibek");
		std.setRollno(04);
		std.setMarks(94);
		std.setAddress(createAddrObj());
		
		return std;
	}

}
