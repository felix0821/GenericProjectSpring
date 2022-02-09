package com.system.demo.dto.specific;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ProgramDetailedOccupationalDto {
	
	@NotNull(message = "Ingrese un id valido")
	private Long id;
	@NotNull(message = "Ingrese un id valido")
	private int index;
	@NotBlank(message = "Ingrese un nombre.")
	private String name;
	@NotNull
	private Character state;
	
	public ProgramDetailedOccupationalDto(@NotNull(message = "Ingrese un id valido") Long id,
			@NotNull(message = "Ingrese un id valido") int index, @NotBlank(message = "Ingrese un nombre.") String name,
			@NotNull Character state) {
		super();
		this.id = id;
		this.index = index;
		this.name = name;
		this.state = state;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Character getState() {
		return state;
	}

	public void setState(Character state) {
		this.state = state;
	}

}
