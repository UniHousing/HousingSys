package com.webapp.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class ResidenceHall extends IdEntity<ResidenceHall> {

	private String name;
	private String addr;
	private String tel;
	private String managerId;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getManagerId() {
		return managerId;
	}
	public void setManagerId(String managerId) {
		this.managerId = managerId;
	}
}