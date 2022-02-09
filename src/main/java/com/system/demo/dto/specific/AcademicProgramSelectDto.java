package com.system.demo.dto.specific;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class AcademicProgramSelectDto {
	
	@NotNull(message = "Ingrese un id valido")
	private Long id;
	
	@NotBlank(message = "Ingrese un nombre.")
	private String name;
	
	@NotBlank(message = "Ingrese un acrónimo.")
	private String acronym;
	
	@NotBlank(message = "Ingrese una descripción.")
	private String description;
	
	@NotNull
	private Character state;

}
