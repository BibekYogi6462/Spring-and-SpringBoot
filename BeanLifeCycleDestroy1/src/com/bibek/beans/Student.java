package com.bibek.beans;

import org.springframework.beans.factory.InitializingBean;

public class Student {

	
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
	
  public void init(){
	  name="Bibek";
	  rollno=4
;  }
  
  
  public void destroy() {
	  name="";
	  rollno=0;
  }
  
  
//	@Override
//	public void afterPropertiesSet() throws Exception {
//		// TODO Auto-generated method stub
//		name="Bibek";
//    	rollno=2;
//	}
	

}
