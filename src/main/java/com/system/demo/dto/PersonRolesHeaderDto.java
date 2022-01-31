package com.system.demo.dto;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotBlank;

public class PersonRolesHeaderDto {
	
	@NotBlank(message = "Ingrese un nombre.")
	private String name;
	
	private List<PersonRolesDetailDto> roles;

	public PersonRolesHeaderDto(@NotBlank(message = "Ingrese un nombre.") String name) {
		super();
		this.name = name;
		this.roles = new ArrayList<>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<PersonRolesDetailDto> getRoles() {
		return roles;
	}

	public void setRoles(List<PersonRolesDetailDto> roles) {
		this.roles = roles;
	}

}
