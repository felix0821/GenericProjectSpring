package com.system.demo.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class AcademicProgramRegisterDto {
	
	@NotBlank(message = "Ingrese un nombre de programa.")
	@Size(max = 64, min = 3, message = "Ingrese entre 3 a 64 caracteres.")
	private String name;
	
	@NotBlank(message = "Ingrese un acrónimo de programa.")
	@Size(max = 4, min = 1, message = "Ingrese entre 1 a 4 caracteres.")
	private String acronym;
	
	@NotBlank(message = "Ingrese una descripción de programa.")
	@Size(max = 512, min = 1, message = "Ingrese entre 1 a 512 caracteres.")
	private String description;
	
	@NotBlank(message = "Ingrese un área de programa.")
	private Character area;
	
	private String image;

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

	public Character getArea() {
		return area;
	}

	public void setArea(Character area) {
		this.area = area;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

}
