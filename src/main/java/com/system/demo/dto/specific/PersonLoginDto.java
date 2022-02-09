package com.system.demo.dto.specific;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class PersonLoginDto {
	@NotBlank(message = "Ingrese un nombre de usuario.")
	@Size(max = 20, min = 3, message = "Ingrese entre 3 a 30 caracteres.")
    private String username;
    @NotBlank(message = "Ingrese una contraseña.")
    @Size(min = 4, message = "Ingrese al menos 4 caracteres.")
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