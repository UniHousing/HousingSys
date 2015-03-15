package com.webapp.model;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

@Document
public class LeaseRequest extends IdEntity<LeaseRequest> {

	private String studentId;
	private String preference1;
	private String preference2;
	private String preference3;
	private String status;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date startDate;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date endDate;
	
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public String getPreference1() {
		return preference1;
	}
	public void setPreference1(String preference1) {
		this.preference1 = preference1;
	}
	public String getPreference2() {
		return preference2;
	}
	public void setPreference2(String preference2) {
		this.preference2 = preference2;
	}
	public String getPreference3() {
		return preference3;
	}
	public void setPreference3(String preference3) {
		this.preference3 = preference3;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
}

