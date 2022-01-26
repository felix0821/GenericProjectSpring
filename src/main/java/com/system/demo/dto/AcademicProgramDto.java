package com.system.demo.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class AcademicProgramDto {
	
	@NotNull(message = "Ingrese un id valido")
	private Long id;
	
	@NotNull(message = "Ingrese un id valido")
	private int index;
	
	@NotBlank(message = "Ingrese un nombre.")
	private String name;
	
	@NotBlank(message = "Ingrese un acrónimo.")
	private String acronym;
	
	@NotBlank(message = "Ingrese una descripción.")
	private String description;
	
	@NotNull
	private Character state;
	
	public AcademicProgramDto(@NotNull(message = "Ingrese un id valido") Long id,
			@NotNull(message = "Ingrese un id valido") int index, @NotBlank(message = "Ingrese un nombre.") String name,
			@NotBlank(message = "Ingrese un acrónimo.") String acronym, @NotNull Character state) {
		super();
		this.id = id;
		this.index = index;
		this.name = name;
		this.acronym = acronym;
		this.state = state;
		this.description = "Programa de enseñanza";
	}

	public AcademicProgramDto(@NotNull(message = "Ingrese un id valido") Long id,
			@NotNull(message = "Ingrese un id valido") int index, @NotBlank(message = "Ingrese un nombre.") String name,
			@NotBlank(message = "Ingrese un acrónimo.") String acronym,
			@NotBlank(message = "Ingrese un acrónimo.") String description, @NotNull Character state) {
		super();
		this.id = id;
		this.index = index;
		this.name = name;
		this.acronym = acronym;
		this.description = description;
		this.state = state;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Character getState() {
		return state;
	}

	public void setState(Character state) {
		this.state = state;
	}

}
