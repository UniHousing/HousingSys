package com.webapp.model;

import javax.persistence.Entity;



@Entity
public class House extends IdEntity<House>{
	
	private String name;

	private String type;

	
	public House() {

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return name;
	}

}
