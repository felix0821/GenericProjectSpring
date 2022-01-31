package com.system.demo.dto;

import javax.validation.constraints.NotNull;

public class PersonRoleRegisterDto {
	
	@NotNull(message = "Ingrese un id valido")
	private Long roleId;
	
	@NotNull(message = "Ingrese un id valido")
	private Long personId;

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public Long getPersonId() {
		return personId;
	}

	public void setPersonId(Long personId) {
		this.personId = personId;
	}

}
