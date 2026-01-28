package com.bibek.beans;

public class Student {
	
	public Student(String a) {
		System.out.println("Constructor invoked");;
	}
	
	private String name;
	private int rollno;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getRollno() {
		return rollno;
	}
	public void setRollno(int rollno) {
		this.rollno = rollno;
	}
	
	
	
	public void display() {
//		System.out.println(name + " "+ rollno);
		System.out.println("hello");
	}
	
	
	public static Student createStdObj()
	{
		return new Student("Hello");
	}
	

}
