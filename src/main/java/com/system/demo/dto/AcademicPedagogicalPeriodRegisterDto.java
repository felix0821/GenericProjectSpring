package com.system.demo.dto;

import java.util.Date;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class AcademicPedagogicalPeriodRegisterDto {
	
	@NotBlank(message = "Ingrese un nombre de período pedagógico.")
	@Size(max = 64, min = 3, message = "Ingrese entre 3 a 32 caracteres.")
	private String name;
	@NotNull(message = "Ingrese una modalidad.")
	private Character modality;
	@NotNull(message = "Ingrese un año valido")
	@Min(value = 2000, message = "Ingrese un número mayor a 2000")
	private int year;
	@NotNull
	private boolean blockRegistration;
	private Date dateOpening;
	private Date dateClosing;
	@DecimalMin(value = "-1", message = "Ingrese un número mayor a 0")
	private double payEnrollmet=0;
	@DecimalMin(value = "-1", message = "Ingrese un número mayor a 0")
	private double payPension=0;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Character getModality() {
		return modality;
	}
	public void setModality(Character modality) {
		this.modality = modality;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public boolean isBlockRegistration() {
		return blockRegistration;
	}
	public void setBlockRegistration(boolean blockRegistration) {
		this.blockRegistration = blockRegistration;
	}
	public Date getDateOpening() {
		return dateOpening;
	}
	public void setDateOpening(Date dateOpening) {
		this.dateOpening = dateOpening;
	}
	public Date getDateClosing() {
		return dateClosing;
	}
	public void setDateClosing(Date dateClosing) {
		this.dateClosing = dateClosing;
	}
	public double getPayEnrollmet() {
		return payEnrollmet;
	}
	public void setPayEnrollmet(double payEnrollmet) {
		this.payEnrollmet = payEnrollmet;
	}
	public double getPayPension() {
		return payPension;
	}
	public void setPayPension(double payPension) {
		this.payPension = payPension;
	}

	
}
