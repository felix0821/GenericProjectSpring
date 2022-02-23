package com.system.demo.dto.specific;

import java.util.Date;

public class MyProceduresObserveDto {
	
	private String content;
	
	private Date date;
	
	private String sender;

	public MyProceduresObserveDto(String content, Date date, String sender) {
		super();
		this.content = content;
		this.date = date;
		this.sender = sender;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

}
