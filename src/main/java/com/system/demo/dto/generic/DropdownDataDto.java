package com.system.demo.dto.generic;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class DropdownDataDto {
	
	private Long id;
	
	private String name;

	public DropdownDataDto(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
}
