package com.system.demo.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class PersonListDto {
	
	@NotNull(message = "Ingrese un id valido")
	private Long id;
	
	@NotBlank
	@Size(max = 20, min = 3, message = "Usuario invalido")
	private String username;
	
	@NotBlank(message = "Ingrese un nombre.")
	private String name;
	
	@NotBlank(message = "Ingrese un apellido paterno.")
	private String lastnameFather;
	
	@NotBlank(message = "Ingrese un apellido materno.")
	private String lastnameMother;
	
	@NotNull
	private Character state;


	public PersonListDto(@NotNull(message = "Ingrese un id valido") Long id,
			@NotBlank @Size(max = 20, min = 3, message = "Usuario invalido") String username,
			@NotBlank(message = "Ingrese un nombre.") String name,
			@NotBlank(message = "Ingrese un apellido paterno.") String lastnameFather,
			@NotBlank(message = "Ingrese un apellido materno.") String lastnameMother, @NotNull Character state) {
		super();
		this.id = id;
		this.username = username;
		this.name = name;
		this.lastnameFather = lastnameFather;
		this.lastnameMother = lastnameMother;
		this.state = state;
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

	public String getLastnameFather() {
		return lastnameFather;
	}

	public void setLastnameFather(String lastnameFather) {
		this.lastnameFather = lastnameFather;
	}

	public String getLastnameMother() {
		return lastnameMother;
	}

	public void setLastnameMother(String lastnameMother) {
		this.lastnameMother = lastnameMother;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Character getState() {
		return state;
	}

	public void setState(Character state) {
		this.state = state;
	}

}
