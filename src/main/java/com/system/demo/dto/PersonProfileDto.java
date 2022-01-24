package com.system.demo.dto;

import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class PersonProfileDto {
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
	
	@Email(message = "Ingrese un correo electronico.")
	private String email;
	
	private String dni;
	
	@NotNull(message = "Ingrese una fecha de nacimiento.")
	private Date dateBirth;
	
	private String urlProfilepicture;
	
	public PersonProfileDto(@NotNull(message = "Ingrese un id valido") Long id,
			@NotBlank @Size(max = 20, min = 3, message = "Usuario invalido") String username,
			@NotBlank(message = "Ingrese un nombre.") String name,
			@NotBlank(message = "Ingrese un apellido paterno.") String lastnameFather,
			@NotBlank(message = "Ingrese un apellido materno.") String lastnameMother,
			@Email(message = "Ingrese un correo electronico.") String email,
			String dni,
			@NotNull(message = "Ingrese una fecha de nacimiento.") Date dateBirth, String urlProfilepicture) {
		super();
		this.id = id;
		this.username = username;
		this.name = name;
		this.lastnameFather = lastnameFather;
		this.lastnameMother = lastnameMother;
		this.email = email;
		this.dni = dni;
		this.dateBirth = dateBirth;
		this.urlProfilepicture = urlProfilepicture;
	}

	public PersonProfileDto() {}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public void setLastnameFather(String lastname) {
		this.lastnameFather = lastname;
	}

	public String getLastnameMother() {
		return lastnameMother;
	}

	public void setLastnameMother(String lastnameMother) {
		this.lastnameMother = lastnameMother;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public Date getDateBirth() {
		return dateBirth;
	}

	public void setDateBirth(Date dateBirth) {
		this.dateBirth = dateBirth;
	}

	public String getUrlProfilepicture() {
		return urlProfilepicture;
	}

	public void setUrlProfilepicture(String urlProfilepicture) {
		this.urlProfilepicture = urlProfilepicture;
	}

}
