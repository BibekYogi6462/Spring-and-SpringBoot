package com.bibek.main;

import com.bibek.beans.Student;

public class Main {
	public static void main(String[] args) {
		Student std = new Student();
		std.setName("Bibek");
		std.setRollno(5);
		
		std.display();
	}

}
