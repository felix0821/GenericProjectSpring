package com.system.demo.dto.specific;

import java.util.Date;

public class AlertDto {
	
	private Long id;
	
	private String name;
	
	private String sender;
	
	private Date date;

	public AlertDto(Long id, String name, String sender, Date date) {
		super();
		this.id = id;
		this.name = name;
		this.sender = sender;
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

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
