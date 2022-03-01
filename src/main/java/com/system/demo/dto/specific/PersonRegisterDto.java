package com.system.demo.dto.specific;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class PersonRegisterDto {
	
	@NotBlank(message = "Ingrese un nombre de usuario o correo.")
	@Size(max = 128, message = "Él limite de carácteres para el nombre de usuario o correo no debe sobrepasar los 128.")
	@Size(min = 6, message = "El nombre de usuario o correo necesita al menos 5 caracteres.")
	private String username;
	
	@NotBlank(message = "Ingrese una contraseña.")
	@Size(max = 128, message = "Él limite de carácteres para la contraseña no debe sobrepasar los 128.")
	@Size(min = 6, message = "La contraseña necesita al menos 6 caracteres.")
	private String password;
	
	/*@NotBlank(message = "Ingrese un correo electronico")
	@Size(max = 128, message = "Él limite de carácteres para el correo electrónico no debe sobrepasar los 128.")
	@Email(message = "Correo electrónico invalido")
	private String email;*/
	
	@NotBlank(message = "Ingrese una documento de identidad.")
	@Size(min = 8, max= 8, message = "El documento de identidad necesita 8 caracteres numéricos.")
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
	/*
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	*/
	public String getDni() {
		return dni;
	}
	
	public void setDni(String dni) {
		this.dni = dni;
	}
}
