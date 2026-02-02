package com.bibek.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="std_marks")
public class Student {
	@Id
	@Column(name ="std_id")
  private int id;
	@Column(name ="std_name")
  private String name;
	
	@Column(name ="std_email")
  private String email;
	@Column(name ="std_marks")
  private float marks;
  public int getId() {
	return id;
  }
  public void setId(int id) {
	this.id = id;
  }
  public String getName() {
	return name;
  }
  public void setName(String name) {
	this.name = name;
  }
  public String getEmail() {
	return email;
  }
  public void setEmail(String email) {
	this.email = email;
  }
  public float getMarks() {
	return marks;
  }
  public void setMarks(float marks) {
	this.marks = marks;
  }
  
  
}
