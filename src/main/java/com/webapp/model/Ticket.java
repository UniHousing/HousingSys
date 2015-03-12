package com.webapp.model;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Ticket extends IdEntity<Ticket> {

	private String type; 
	private String studentId;
	private Date data;
	private String location;
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
}
