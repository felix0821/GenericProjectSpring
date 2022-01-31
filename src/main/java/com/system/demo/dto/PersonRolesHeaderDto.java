package com.system.demo.dto;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class PersonRolesHeaderDto {
	
	@NotNull(message = "Ingrese un id valido")
	private Long personId;
	
	@NotBlank(message = "Ingrese un nombre.")
	private String name;
	
	private List<PersonRolesDetailDto> roles;
	
	public PersonRolesHeaderDto(@NotNull(message = "Ingrese un id valido") Long personId,
			@NotBlank(message = "Ingrese un nombre.") String name) {
		super();
		this.personId = personId;
		this.name = name;
		this.roles = new ArrayList<>();
	}

	public Long getPersonId() {
		return personId;
	}

	public void setPersonId(Long personId) {
		this.personId = personId;
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
