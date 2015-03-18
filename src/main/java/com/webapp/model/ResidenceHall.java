package com.webapp.model;

import org.springframework.stereotype.Component;

@Component
public class ResidenceHall extends IdEntity<ResidenceHall> {

	private String name;
	private String addr;
	private String tel;
	private int managerId;
	
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
	public int getManagerId() {
		return managerId;
	}
	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}

}