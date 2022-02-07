package com.system.demo.dto;

import java.util.Date;

import javax.validation.constraints.NotNull;

public class ProgramPeriodDto {
	
	@NotNull(message = "Ingrese un id valido")
	private String id;
	@NotNull(message = "Ingrese un id valido")
	private int index;
	@NotNull(message = "Ingrese una descripción valida")
	private String description;
	@NotNull(message = "Ingrese una fecha de apertura.")
	private Date dateOpening;
	@NotNull(message = "Ingrese una fecha de apertura.")
	private Date dateClosing;
	@NotNull(message = "Ingrese estado.")
	private Character state;

	public ProgramPeriodDto(@NotNull(message = "Ingrese un id valido") String id,
			@NotNull(message = "Ingrese un id valido") int index,
			@NotNull(message = "Ingrese una descripción valida") String description,
			@NotNull(message = "Ingrese una fecha de apertura.") Date dateOpening,
			@NotNull(message = "Ingrese una fecha de apertura.") Date dateClosing,
			@NotNull(message = "Ingrese estado.") Character state) {
		super();
		this.id = id;
		this.index = index;
		this.description = description;
		this.dateOpening = dateOpening;
		this.dateClosing = dateClosing;
		this.state = state;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDateOpening() {
		return dateOpening;
	}

	public void setDateOpening(Date dateOpening) {
		this.dateOpening = dateOpening;
	}

	public Date getDateClosing() {
		return dateClosing;
	}

	public void setDateClosing(Date dateClosing) {
		this.dateClosing = dateClosing;
	}

	public Character getState() {
		return state;
	}

	public void setState(Character state) {
		this.state = state;
	}
	

	
}
