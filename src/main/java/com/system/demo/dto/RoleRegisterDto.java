package com.system.demo.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class RoleRegisterDto {
	
	@NotBlank(message = "Ingrese un nombre de rol.")
	@Size(max = 64, min = 3, message = "Ingrese entre 3 a 64 caracteres.")
	private String name;
	
	private String description;

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
	
}
