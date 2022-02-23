package com.system.demo.dto.specific;

import java.util.List;

public class FinancialMovementHeaderDto {
	
	double income;
	
	double egress;
	
	double difference;
	
	List<FinancialMovementListDto> list;

	public FinancialMovementHeaderDto(double income, double egress, double difference) {
		super();
		this.income = income;
		this.egress = egress;
		this.difference = difference;
	}

	public double getIncome() {
		return income;
	}

	public void setIncome(double income) {
		this.income = income;
	}

	public double getEgress() {
		return egress;
	}

	public void setEgress(double egress) {
		this.egress = egress;
	}

	public double getDifference() {
		return difference;
	}

	public void setDifference(double difference) {
		this.difference = difference;
	}

	public List<FinancialMovementListDto> getList() {
		return list;
	}

	public void setList(List<FinancialMovementListDto> list) {
		this.list = list;
	}

}
