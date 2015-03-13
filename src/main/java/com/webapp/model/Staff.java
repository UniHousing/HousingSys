package com.webapp.model;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class Staff extends IdEntity<Staff> {

	private String fname;
	private String lname;
	private String addr;
	private String city;
	private int postCode;
	private Date birthDate;
	private String gender;
	private String position;
	private String workAt;
	
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getPostCode() {
		return postCode;
	}
	public void setPostCode(int postCode) {
		this.postCode = postCode;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getWorkAt() {
		return workAt;
	}
	public void setWorkAt(String workAt) {
		this.workAt = workAt;
	}
}
