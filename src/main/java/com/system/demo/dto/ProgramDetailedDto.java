package com.system.demo.dto;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ProgramDetailedDto {
	
	@NotNull(message = "Ingrese un id valido")
	private Long id;
	@NotBlank(message = "Ingrese un nombre.")
	private String name;
	@NotBlank(message = "Ingrese un acrónimo.")
	private String acronym;
	@NotBlank(message = "Ingrese una descripción.")
	private String description;
	private String requirement;
	private String curriculum;
	private String image;
	@NotNull
	private Character area;
	@NotNull
	private Character state;
	private List<ProgramDetailedOccupationalDto> occupationals;
	
	public ProgramDetailedDto(@NotNull(message = "Ingrese un id valido") Long id,
			@NotBlank(message = "Ingrese un nombre.") String name,
			@NotBlank(message = "Ingrese un acrónimo.") String acronym,
			@NotBlank(message = "Ingrese una descripción.") String description, String requirement, String curriculum,
			String image, @NotNull Character area, @NotNull Character state) {
		super();
		this.id = id;
		this.name = name;
		this.acronym = acronym;
		this.description = description;
		this.requirement = requirement;
		this.curriculum = curriculum;
		this.image = image;
		this.area = area;
		this.state = state;
		this.occupationals = new ArrayList<>();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getRequirement() {
		return requirement;
	}

	public void setRequirement(String requirement) {
		this.requirement = requirement;
	}

	public String getCurriculum() {
		return curriculum;
	}

	public void setCurriculum(String curriculum) {
		this.curriculum = curriculum;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Character getArea() {
		return area;
	}

	public void setArea(Character area) {
		this.area = area;
	}

	public Character getState() {
		return state;
	}

	public void setState(Character state) {
		this.state = state;
	}

	public List<ProgramDetailedOccupationalDto> getOccupationals() {
		return occupationals;
	}

	public void setOccupationals(List<ProgramDetailedOccupationalDto> occupationals) {
		this.occupationals = occupationals;
	}

}
