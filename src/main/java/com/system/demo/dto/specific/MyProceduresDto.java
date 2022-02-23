package com.system.demo.dto.specific;

import java.util.Date;

public class MyProceduresDto {
	
	Long id;
	
	String name;
	
	Boolean checking;
	
	Date date;

	public MyProceduresDto(Long id, String name, Boolean checking, Date date) {
		super();
		this.id = id;
		this.name = name;
		this.checking = checking;
		this.date = date;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getChecking() {
		return checking;
	}

	public void setChecking(Boolean checking) {
		this.checking = checking;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
