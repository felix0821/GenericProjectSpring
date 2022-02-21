package com.system.demo.dto.specific;

import java.util.Date;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

public class ProgramPeriodNewRegisterDto {
	
	@NotNull(message = "Ingrese un id valido")
	private Long idPeriod;
	
	@NotBlank(message = "Ingrese un nombre de programa.")
	@Size(max = 64, min = 3, message = "Ingrese entre 3 a 64 caracteres.")
	private String name;
	
	@NotBlank(message = "Ingrese un acrónimo de programa.")
	@Size(max = 4, min = 1, message = "Ingrese entre 1 a 4 caracteres.")
	private String acronym;
	
	@NotBlank(message = "Ingrese una descripción de programa.")
	@Size(max = 512, min = 1, message = "Ingrese entre 1 a 512 caracteres.")
	private String description;
	
	@NotNull(message = "Ingrese un área de programa.")
	private Character area;
	
	@NotNull(message = "Ingrese una fecha valida")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateOpening;
	
	@NotNull(message = "Ingrese una fecha valida")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateClosingEnrollmet;
	
	@Min(value = 0, message = "Ingrese un número mayor a 0")
	private int weeks;
	
	@DecimalMin(value = "0", message = "Ingrese un número mayor a 0")
	private double payEnrollmet;
	
	@DecimalMin(value = "0", message = "Ingrese un número mayor a 0")
	private double payPension;

	public Long getIdPeriod() {
		return idPeriod;
	}

	public void setIdPeriod(Long idPeriod) {
		this.idPeriod = idPeriod;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAcronym() {
		return acronym;
	}

	public void setAcronym(String acronym) {
		this.acronym = acronym;
	}

	public Character getArea() {
		return area;
	}

	public void setArea(Character area) {
		this.area = area;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDateOpening() {
		return dateOpening;
	}

	public void setDateOpening(Date dateOpening) {
		this.dateOpening = dateOpening;
	}

	public Date getDateClosingEnrollmet() {
		return dateClosingEnrollmet;
	}

	public void setDateClosingEnrollmet(Date dateClosingEnrollmet) {
		this.dateClosingEnrollmet = dateClosingEnrollmet;
	}

	public int getWeeks() {
		return weeks;
	}

	public void setWeeks(int weeks) {
		this.weeks = weeks;
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
