package com.system.demo.dto.generic;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class HeaderDataDto<Type> {
	
	@NotNull(message = "Ingrese un id valido")
	private String id;
	
	@NotBlank(message = "Ingrese un nombre.")
	private String name;
	
	private List<Type> list;

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

	public List<Type> getList() {
		return list;
	}

	public void setList(List<Type> list) {
		this.list = list;
	}
	
	public void setItemList(Type item) {
		this.list.add(item);
	}

}
