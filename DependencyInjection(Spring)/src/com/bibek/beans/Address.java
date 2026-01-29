package com.bibek.beans;

public class Address {
private int houseno;
private String City;
private int pincode;
public int getHouseno() {
	return houseno;
}
public void setHouseno(int houseno) {
	this.houseno = houseno;
}
public String getCity() {
	return City;
}
public void setCity(String city) {
	City = city;
}
public int getPincode() {
	return pincode;
}
public void setPincode(int pincode) {
	this.pincode = pincode;
}

public String toString(){
	return "#"+houseno+", "+City+" -"+pincode;
}

}
