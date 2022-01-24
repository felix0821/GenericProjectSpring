package com.system.demo.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class PersonRegisterDto {
	
	@NotBlank(message = "Ingrese un nombre de usuario.")
	@Size(max = 20, min = 3, message = "Ingrese entre 3 a 30 caracteres.")
	private String username;
	
	@NotBlank(message = "Ingrese una contraseña.")
	@Size(min = 4, message = "Ingrese al menos 4 caracteres.")
	private String password;
	
	//@NotBlank(message = "Campo de correo vacio")
	//@Email(message = "Correo electronico invalido")
	private String email;
	
	@NotBlank(message = "Ingrese una documento de identidad.")
	@Size(min = 8, message = "Ingrese al menos 8 caracteres.")
	private String dni;

	
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
}
