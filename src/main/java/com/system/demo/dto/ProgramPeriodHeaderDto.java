package com.system.demo.dto;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ProgramPeriodHeaderDto {
	
	@NotNull(message = "Ingrese un id valido")
	private String identifier;
	
	@NotBlank(message = "Ingrese un nombre de encabezado.")
	private String name;
	
	private List<ProgramPeriodDto> programPeriods;
	
	public ProgramPeriodHeaderDto(@NotNull(message = "Ingrese un id valido") String identifier,
			@NotBlank(message = "Ingrese un nombre de encabezado.") String name) {
		super();
		this.identifier = identifier;
		this.name = name;
		this.programPeriods = new ArrayList<>();
	}

	public String getIdentifier() {
		return identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<ProgramPeriodDto> getProgramPeriods() {
		return programPeriods;
	}

	public void setProgramPeriods(List<ProgramPeriodDto> programPeriods) {
		this.programPeriods = programPeriods;
	}

}
