package com.system.demo.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ProgramOccupationalRegisterDto {
	
	@NotNull(message = "Ingrese un id valido")
	private Long idProgram;
	
	@NotBlank(message = "Ingrese un nombre.")
	private String name;

	public Long getIdProgram() {
		return idProgram;
	}

	public void setIdProgram(Long idProgram) {
		this.idProgram = idProgram;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
