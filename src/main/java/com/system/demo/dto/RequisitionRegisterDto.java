package com.system.demo.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class RequisitionRegisterDto {
	
	@NotNull(message = "Ingrese un id valido.")
	private Long idRegister;
	
	@NotNull(message = "Ingrese una cantidad.")
	private Double amount;
	
	@NotBlank(message = "Ingrese un banco.")
	private String banck;
	
	@NotBlank(message = "Ingrese un documento.")
	private String document;
	
	@NotBlank(message = "Ingrese un documento.")
	private String comment;

}
