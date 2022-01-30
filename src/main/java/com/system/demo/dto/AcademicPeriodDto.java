package com.system.demo.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class AcademicPeriodDto {
	
	@NotNull(message = "Ingrese un id valido")
	private Long id;
	
	@NotNull(message = "Ingrese un año valido")
	private int year;
	
	@NotBlank(message = "Ingrese un nombre.")
	private String name;
	
	private String description;
	
	@NotNull
	private Character modality;
	
	@NotNull
	private Character state;

	public AcademicPeriodDto(@NotNull(message = "Ingrese un id valido") Long id,
			@NotNull(message = "Ingrese un año valido") int year, @NotBlank(message = "Ingrese un nombre.") String name,
			@NotNull Character modality,
			@NotNull Character state) {
		super();
		this.id = id;
		this.year = year;
		this.name = name;
		this.modality = modality;
		this.state = state;
		this.description = "Ciclo pedagógico de enseñanza";
	}
	
	public AcademicPeriodDto(@NotNull(message = "Ingrese un id valido") Long id,
			@NotNull(message = "Ingrese un año valido") int year, @NotBlank(message = "Ingrese un nombre.") String name,
			String description, @NotNull Character modality, @NotNull Character state) {
		super();
		this.id = id;
		this.year = year;
		this.name = name;
		this.description = description;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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
