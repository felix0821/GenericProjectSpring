package com.system.demo.dto.specific;

import java.util.Date;

public class DocumentaryRequisitionDto {

	private Long idRequisition;
	
	private String name;
	
	private String username;
	
	private Date date;
	
	private boolean verify;

	public DocumentaryRequisitionDto(Long idRequisition, String name, String username, Date date, boolean verify) {
		super();
		this.idRequisition = idRequisition;
		this.name = name;
		this.username = username;
		this.date = date;
		this.verify = verify;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getIdRequisition() {
		return idRequisition;
	}

	public void setIdRequisition(Long idRequisition) {
		this.idRequisition = idRequisition;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public boolean isVerify() {
		return verify;
	}

	public void setVerify(boolean verify) {
		this.verify = verify;
	}
	
	
}
