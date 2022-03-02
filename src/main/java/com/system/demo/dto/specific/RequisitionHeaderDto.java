package com.system.demo.dto.specific;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.system.demo.dto.generic.HeaderDataDto;

public class RequisitionHeaderDto<Type> extends HeaderDataDto<Type> {
	
	private Long reference;

	public RequisitionHeaderDto(@NotNull(message = "Ingrese un id valido") String id,
			@NotBlank(message = "Ingrese un nombre.") String name, Long reference) {
		super(id, name);
		// TODO Auto-generated constructor stub
		this.reference = reference;
	}

	public Long getReference() {
		return reference;
	}

	public void setReference(Long reference) {
		this.reference = reference;
	}

}
