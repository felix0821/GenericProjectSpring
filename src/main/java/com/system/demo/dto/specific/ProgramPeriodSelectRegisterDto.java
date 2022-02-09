package com.system.demo.dto.specific;

import java.util.Date;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

public class ProgramPeriodSelectRegisterDto {
	
	@NotNull(message = "Ingrese un id valido")
	private Long idPeriod;
	
	@NotNull(message = "Ingrese un id valido")
	private Long idProgram;
	
	@NotNull(message = "Ingrese una fecha valida")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateOpening;
	
	@NotNull(message = "Ingrese una fecha valida")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateClosingEnrollmet;
	
	@NotNull(message = "Ingrese una fecha valida")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateClosing;
	
	@DecimalMin(value = "0", message = "Ingrese un número mayor a 0")
	private double payEnrollmet;
	
	@DecimalMin(value = "0", message = "Ingrese un número mayor a 0")
	private double payPension;

	public ProgramPeriodSelectRegisterDto(@NotNull(message = "Ingrese un id valido") Long idPeriod,
			@NotNull(message = "Ingrese un id valido") Long idProgram,
			@NotNull(message = "Ingrese una fecha valida") Date dateOpening,
			@NotNull(message = "Ingrese una fecha valida") Date dateClosingEnrollmet,
			@NotNull(message = "Ingrese una fecha valida") Date dateClosing,
			@DecimalMin(value = "0", message = "Ingrese un número mayor a 0") double payEnrollmet,
			@DecimalMin(value = "0", message = "Ingrese un número mayor a 0") double payPension) {
		super();
		this.idPeriod = idPeriod;
		this.idProgram = idProgram;
		this.dateOpening = dateOpening;
		this.dateClosingEnrollmet = dateClosingEnrollmet;
		this.dateClosing = dateClosing;
		this.payEnrollmet = payEnrollmet;
		this.payPension = payPension;
	}

	public Long getIdPeriod() {
		return idPeriod;
	}

	public void setIdPeriod(Long idPeriod) {
		this.idPeriod = idPeriod;
	}

	public Long getIdProgram() {
		return idProgram;
	}

	public void setIdProgram(Long idProgram) {
		this.idProgram = idProgram;
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
