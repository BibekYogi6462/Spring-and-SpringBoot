package com.bibek.beans;

import org.springframework.beans.factory.InitializingBean;

public class Student implements InitializingBean{

	
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
		System.out.println(name + " "+ rollno);
//		System.out.println("hello");
	}
	
  
	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		name="Bibek";
    	rollno=2;
	}
	

}
