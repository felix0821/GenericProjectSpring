package com.system.demo.dto;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class RoleHeaderDto {
	
	@NotNull(message = "Ingrese un caracter.")
	private Character type;
	
	@NotBlank(message = "Ingrese un nombre de encabezado.")
	private String name;
	
	private List<RoleTypeDto> rolesType;

	public RoleHeaderDto(@NotNull(message = "Ingrese un caracter.") Character type,
			@NotBlank(message = "Ingrese un nombre de encabezado.") String name) {
		super();
		this.type = type;
		this.name = name;
		this.rolesType = new ArrayList<>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Character getType() {
		return type;
	}

	public void setType(Character type) {
		this.type = type;
	}

	public List<RoleTypeDto> getRolesType() {
		return rolesType;
	}

	public void setRolesType(List<RoleTypeDto> rolesType) {
		this.rolesType = rolesType;
	}

}
