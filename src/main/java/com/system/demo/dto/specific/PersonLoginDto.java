package com.system.demo.dto.specific;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class PersonLoginDto {
	@NotBlank(message = "Ingrese un nombre de usuario.")
	@Size(max = 128, message = "Él limite de carácteres para el nombre de usuario o correo no debe sobrepasar los 128.")
	@Size(min = 6, message = "El nombre de usuario o correo necesita al menos 5 caracteres.")
    private String username;
	
    @NotBlank(message = "Ingrese una contraseña.")
    @Size(max = 128, message = "Él limite de carácteres para la contraseña no debe sobrepasar los 128.")
	@Size(min = 6, message = "La contraseña necesita al menos 6 caracteres.")
    private String password;
    
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
    
}