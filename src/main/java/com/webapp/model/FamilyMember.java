package com.webapp.model;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class FamilyMember extends IdEntity<FamilyMember> {
	
	private String studentId;
	private Date birthDate;
	
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
}
