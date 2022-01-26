package com.system.demo.dto;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ProgramPeriodEnrollmentDto {
	
	@NotBlank(message = "Ingrese un nombre.")
	private String name;
	
	@NotBlank(message = "Ingrese un apellido paterno.")
	private String lastnameFather;
	
	@NotBlank(message = "Ingrese un apellido materno.")
	private String lastnameMother;
	
	@NotNull(message = "Ingrese una fecha de nacimiento.")
	private Date dateRegister;

	public ProgramPeriodEnrollmentDto(@NotBlank(message = "Ingrese un nombre.") String name,
			@NotBlank(message = "Ingrese un apellido paterno.") String lastnameFather,
			@NotBlank(message = "Ingrese un apellido materno.") String lastnameMother,
			@NotNull(message = "Ingrese una fecha de nacimiento.") Date dateRegister) {
		super();
		this.name = name;
		this.lastnameFather = lastnameFather;
		this.lastnameMother = lastnameMother;
		this.dateRegister = dateRegister;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastnameFather() {
		return lastnameFather;
	}

	public void setLastnameFather(String lastnameFather) {
		this.lastnameFather = lastnameFather;
	}

	public String getLastnameMother() {
		return lastnameMother;
	}

	public void setLastnameMother(String lastnameMother) {
		this.lastnameMother = lastnameMother;
	}

	public Date getDateRegister() {
		return dateRegister;
	}

	public void setDateRegister(Date dateRegister) {
		this.dateRegister = dateRegister;
	}

}
