package com.system.demo.dto.specific;

import java.util.Date;

public class FinancialMovementListDto {
	
	private Long id;
	
	private Date date;
	
	private String name;
	
	private String symbol;
	
	private Double amount;
	
	private String registerType;

	private int operationNumber;
	
	private String image;

	public FinancialMovementListDto(Long id, Date date, String name, String symbol, Double amount, String registerType,
			int operationNumber, String image) {
		super();
		this.id = id;
		this.date = date;
		this.name = name;
		this.symbol = symbol;
		this.amount = amount;
		this.registerType = registerType;
		this.operationNumber = operationNumber;
		this.image = image;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getRegisterType() {
		return registerType;
	}

	public void setRegisterType(String registerType) {
		this.registerType = registerType;
	}

	public int getOperationNumber() {
		return operationNumber;
	}

	public void setOperationNumber(int operationNumber) {
		this.operationNumber = operationNumber;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

}
