package com.system.demo.dto.specific;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class PersonEditDto {
	
	@NotNull(message = "Ingrese un id valido")
	private Long id;
	
	@NotBlank(message = "Ingrese un nombre.")
	private String name;
	
	@NotBlank(message = "Ingrese un apellido paterno.")
	private String lastnameFather;
	
	@NotBlank(message = "Ingrese un apellido materno.")
	private String lastnameMother;
	
	@NotNull(message = "Ingrese una fecha de nacimiento.")
	private Date dateBirth;
	
	@NotNull
	private Character state;

	public PersonEditDto(@NotNull(message = "Ingrese un id valido") Long id,
			@NotBlank(message = "Ingrese un nombre.") String name,
			@NotBlank(message = "Ingrese un apellido paterno.") String lastnameFather,
			@NotBlank(message = "Ingrese un apellido materno.") String lastnameMother,
			@NotNull(message = "Ingrese una fecha de nacimiento.") Date dateBirth,
			@NotNull(message = "Ingrese una fecha de nacimiento.") Character state) {
		super();
		this.id = id;
		this.name = name;
		this.lastnameFather = lastnameFather;
		this.lastnameMother = lastnameMother;
		this.dateBirth = dateBirth;
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

	public Date getDateBirth() {
		return dateBirth;
	}

	public void setDateBirth(Date dateBirth) {
		this.dateBirth = dateBirth;
	}

	public Character getState() {
		return state;
	}

	public void setState(Character state) {
		this.state = state;
	}

}
