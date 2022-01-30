package com.system.demo.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class AcademicPedagogicalPeriodDto {
	
	@NotNull(message = "Ingrese un id valido")
	private Long id;
	
	@NotNull(message = "Ingrese un año valido")
	private int year;
	
	@NotBlank(message = "Ingrese un nombre.")
	private String name;
	
	@NotNull(message = "Ingrese una modalidad.")
	private Character modality;
	
	@NotNull(message = "Ingrese un estado.")
	private Character state;

	public AcademicPedagogicalPeriodDto(@NotNull(message = "Ingrese un id valido") Long id,
			@NotNull(message = "Ingrese un año valido") int year, @NotBlank(message = "Ingrese un nombre.") String name,
			@NotNull(message = "Ingrese una modalidad.") Character modality,
			@NotNull(message = "Ingrese un estado.") Character state) {
		super();
		this.id = id;
		this.year = year;
		this.name = name;
		this.modality = modality;
		this.state = state;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

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

	public Character getState() {
		return state;
	}

	public void setState(Character state) {
		this.state = state;
	}

}
