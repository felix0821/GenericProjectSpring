package com.system.demo.dto.generic;

import javax.validation.constraints.NotNull;

public class Relationship2Dto {
	
	@NotNull(message = "Ingrese un id valido")
	private Long idOne;
	
	@NotNull(message = "Ingrese un id valido")
	private Long idTwo;

	public Long getIdOne() {
		return idOne;
	}

	public void setIdOne(Long idOne) {
		this.idOne = idOne;
	}

	public Long getIdTwo() {
		return idTwo;
	}

	public void setIdTwo(Long idTwo) {
		this.idTwo = idTwo;
	}

}
