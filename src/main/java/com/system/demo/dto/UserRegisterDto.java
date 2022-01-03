package com.system.demo.dto;

import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class UserRegisterDto {
	@NotBlank(message = "Campo de usuario vacio")
	private String username;
	@NotBlank(message = "Campo de contraseña vacio")
	private String password;
	@NotBlank(message = "Campo de correo vacio")
	@Email(message = "Correo electronico invalido")
	private String email;
	@NotBlank(message = "Campo de dni vacio")
	private String dni;
	@NotNull(message = "No se selecciono Fecha")
	private Date dateBirth;
	public UserRegisterDto() {};
	public UserRegisterDto(@NotBlank(message = "Campo de usuario vacio") String username,
			@NotBlank(message = "Campo de contraseña vacio") String password,
			@NotBlank(message = "Campo de correo vacio") @Email(message = "Correo electronico invalido") String email,
			@NotBlank(message = "Campo de dni vacio") String dni,
			@NotNull(message = "No se selecciono Fecha") Date dateBirth) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.dni = dni;
		this.dateBirth = dateBirth;
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
}
