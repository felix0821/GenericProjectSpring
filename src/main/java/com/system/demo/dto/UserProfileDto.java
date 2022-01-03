package com.system.demo.dto;

import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class UserProfileDto {
	@NotBlank
	private Long id;
	@NotBlank
	private String username;
	private String password;
	@NotBlank
	private String name;
	@NotBlank
	private String lastname;
	@NotBlank
	private String lastnameMother;
	@Email
	private String email;
	@NotBlank
	private String dni;
	@NotNull
	private Date dateBirth;
	private Character state;
	
	public UserProfileDto(@NotBlank Long id, @NotBlank String username, @NotBlank String name,
			@NotBlank String lastname, @NotBlank String lastnameMother,
			@Email String email, @NotBlank String dni, @NotNull Date dateBirth,
			@NotBlank Character state, String password) {
		this.id = id;
		this.username = username;
		this.name = name;
		this.lastname = lastname;
		this.lastnameMother = lastnameMother;
		this.email = email;
		this.dni = dni;
		this.dateBirth = dateBirth;
		this.state = state;
		this.setPassword(password);
	}

	public UserProfileDto() {}
	
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

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
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

	public Character getState() {
		return state;
	}

	public void setState(Character state) {
		this.state = state;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
