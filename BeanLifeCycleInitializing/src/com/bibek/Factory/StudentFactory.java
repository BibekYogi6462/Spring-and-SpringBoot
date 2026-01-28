package com.bibek.Factory;

import com.bibek.beans.Student;

public class StudentFactory {
	
	public Student createStdObj() {
		Student std = new Student("Factory method Invoked");
		return std;
	}

}
