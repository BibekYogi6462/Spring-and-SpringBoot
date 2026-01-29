package com.bibek.main;

import com.bibek.beans.Address;
import com.bibek.beans.Student;

public class Main {
	
	public static void main(String[] args) {
		Address addr = new Address();
		addr.setHouseno(123);
		addr.setCity("Kathamandu");
		addr.setPincode(123456);
		
		Student std = new Student();
		std.setName("Bibek");
		std.setRollno(14);
		std.setAddress(addr);
		
		std.display();
		
	}

}
