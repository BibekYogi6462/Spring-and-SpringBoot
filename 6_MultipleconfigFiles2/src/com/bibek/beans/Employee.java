package com.bibek.beans;

public class Employee {

	private String empName;
	private int empId;
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	
	
	public void empDisplay() {
		System.out.println("Emp Name: "+empName);
		System.out.println("Emp Id : "+empId);
	}
	
}
