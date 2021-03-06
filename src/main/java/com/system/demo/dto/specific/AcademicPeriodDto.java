package com.system.demo.dto.specific;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class AcademicPeriodDto {
	
	@NotNull(message = "Ingrese un id valido")
	private Long id;
	
	@NotNull(message = "Ingrese un id valido")
	private String identifier;
	
	@NotNull(message = "Ingrese un año valido")
	private int year;
	
	@NotBlank(message = "Ingrese un nombre.")
	private String name;
	
	private String description;
	
	private Long countPrograms;
	
	@NotNull
	private String modality;
	
	@NotNull
	private Character state;

	public AcademicPeriodDto(@NotNull(message = "Ingrese un id valido") Long id,
			@NotNull(message = "Ingrese un id valido") String identifier,
			@NotNull(message = "Ingrese un año valido") int year, @NotBlank(message = "Ingrese un nombre.") String name,
			String description, Long countPrograms, @NotNull String  modality, @NotNull Character state) {
		super();
		this.id = id;
		this.identifier = identifier;
		this.year = year;
		this.name = name;
		this.description = description;
		this.countPrograms = countPrograms;
		this.modality = modality;
		this.state = state;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIdentifier() {
		return identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
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

	public Long getCountPrograms() {
		return countPrograms;
	}

	public void setCountPrograms(Long countPrograms) {
		this.countPrograms = countPrograms;
	}

	public String  getModality() {
		return modality;
	}

	public void setModality(String  modality) {
		this.modality = modality;
	}

	public Character getState() {
		return state;
	}

	public void setState(Character state) {
		this.state = state;
	}
}
