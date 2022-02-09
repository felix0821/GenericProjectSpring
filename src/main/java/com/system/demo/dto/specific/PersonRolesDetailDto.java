package com.system.demo.dto.specific;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class PersonRolesDetailDto {
	
	@NotNull(message = "Ingrese un id valido")
	private Long roleId;
	
	@NotBlank(message = "Ingrese un nombre.")
	private String roleName;
	
	@NotNull(message = "Ingrese un caracter.")
	private Character relationState;

	public PersonRolesDetailDto(@NotNull(message = "Ingrese un id valido") Long roleId,
			@NotBlank(message = "Ingrese un nombre.") String roleName,
			@NotNull(message = "Ingrese un caracter.") Character relationState) {
		super();
		this.roleId = roleId;
		this.roleName = roleName;
		this.relationState = relationState;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Character getRelationState() {
		return relationState;
	}

	public void setRelationState(Character relationState) {
		this.relationState = relationState;
	}

}
