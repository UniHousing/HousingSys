package com.webapp.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class FamilyMember extends IdEntity<FamilyMember> {
	
	private String studentId;
	private String name;
	private String birthDate;
	
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public String getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
