package com.system.demo.dto.specific;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ConfigurationModulusRegisterDto {
	
	@NotBlank(message = "Ingrese un nombre de modulo.")
	@Size(max = 64, min = 3, message = "Ingrese entre 3 a 64 caracteres.")
	private String name;
	
	@NotNull(message = "Ingrese un numero valido")
	private int order;
	
	@NotBlank(message = "Ingrese una descripción de programa.")
	@Size(max = 512, min = 1, message = "Ingrese entre 1 a 512 caracteres.")
	private String description;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
