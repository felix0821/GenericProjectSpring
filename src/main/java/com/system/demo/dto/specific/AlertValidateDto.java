package com.system.demo.dto.specific;

import javax.validation.constraints.NotNull;

public class AlertValidateDto {
	
	@NotNull(message = "Ingrese un id valido")
	private Long id;

}
