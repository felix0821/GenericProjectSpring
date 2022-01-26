package com.system.demo.dto;

import java.util.Date;

import javax.validation.constraints.NotNull;

public class ProgramPeriodDto {
	
	@NotNull(message = "Ingrese un id valido")
	private Long id;
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
	
	public ProgramPeriodDto(@NotNull(message = "Ingrese un id valido") Long id,
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
	

	
}
