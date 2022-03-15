package com.system.demo.dto.specific;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AlertViewDto<T> {
	
	private Long id;
	
	private String name;
	
	private Date date;
	
	private String sender;
	
	private List<AlertViewDataDto> data;
	
	private List<AlertViewEventDto<T>> actions;

	public AlertViewDto(Long id, String name, Date date, String sender) {
		super();
		this.id = id;
		this.name = name;
		this.date = date;
		this.sender = sender;
		this.data = new ArrayList<>();
		this.actions = new ArrayList<>();
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

	public List<AlertViewDataDto> getData() {
		return data;
	}

	public void setData(List<AlertViewDataDto> data) {
		this.data = data;
	}

	public List<AlertViewEventDto<T>> getActions() {
		return actions;
	}

	public void setActions(List<AlertViewEventDto<T>> actions) {
		this.actions = actions;
	}

}
