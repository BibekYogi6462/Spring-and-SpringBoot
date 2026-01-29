package com.bibek.beans;

public class Address {
private int houseno;
private String City;
private int pincode;

public Address(int houseno, String City, int pincode) {
	this.houseno = houseno;
	this.City = City;
	this.pincode = pincode;
}

public String toString(){
	return "#"+houseno+", "+City+" -"+pincode;
}

}
