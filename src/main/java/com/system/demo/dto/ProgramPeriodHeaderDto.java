package com.system.demo.dto;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotBlank;

public class ProgramPeriodHeaderDto {
	
	@NotBlank(message = "Ingrese un nombre de encabezado.")
	private String name;
	
	private List<ProgramPeriodDto> programPeriods;

	public ProgramPeriodHeaderDto(@NotBlank(message = "Ingrese un nombre de encabezado.") String name) {
		super();
		this.name = name;
		this.programPeriods = new ArrayList<>();
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
