package com.system.demo.dto.specific;

import java.util.Date;
import java.util.List;

public class MyProceduresViewDto {
	
	private String name;
	
	private Date date;
	
	private boolean checking;
	
	private List<AlertViewDataDto> data;
	
	private List<MyProceduresObserveDto> observes;
	
	private List<MyProceduresStatusDto> states;

	public MyProceduresViewDto(String name, boolean checking, Date date) {
		super();
		this.name = name;
		this.checking = checking;
		this.date = date;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isChecking() {
		return checking;
	}

	public void setChecking(boolean checking) {
		this.checking = checking;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public List<AlertViewDataDto> getData() {
		return data;
	}

	public void setData(List<AlertViewDataDto> data) {
		this.data = data;
	}

	public List<MyProceduresObserveDto> getObserves() {
		return observes;
	}

	public void setObserves(List<MyProceduresObserveDto> observes) {
		this.observes = observes;
	}

	public List<MyProceduresStatusDto> getStates() {
		return states;
	}

	public void setStates(List<MyProceduresStatusDto> states) {
		this.states = states;
	}

}
