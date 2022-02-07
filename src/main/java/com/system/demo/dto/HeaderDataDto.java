package com.system.demo.dto;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class HeaderDataDto<T> {
	
	@NotNull(message = "Ingrese un id valido")
	private String id;
	
	@NotBlank(message = "Ingrese un nombre.")
	private String name;
	
	private List<T> list;

	public HeaderDataDto(@NotNull(message = "Ingrese un id valido") String id,
			@NotBlank(message = "Ingrese un nombre.") String name) {
		super();
		this.id = id;
		this.name = name;
		this.list = new ArrayList<>();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

}
