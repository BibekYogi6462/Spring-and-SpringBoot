package com.bibek.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Student {
	@Value("Bibek")
  private String name;
	@Value("45")
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
  
  
  public void Display() {
	  System.out.println("Name "+name+"\n");
	  System.out.println("Roll no :"+rollno);
  }
}
