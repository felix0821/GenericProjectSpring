package com.system.demo.dto.specific;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class AlertObserveDto {
	
	@NotNull(message = "Ingrese un id valido")
	private Long id;
	
	@NotBlank(message = "Ingrese una observación.")
	private String content;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
