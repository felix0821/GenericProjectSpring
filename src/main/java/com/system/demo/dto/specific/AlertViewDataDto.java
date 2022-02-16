package com.system.demo.dto.specific;

public class AlertViewDataDto {
	
	private Long id;
	
	private String name;
	
	private String value;
	
	private Character type;

	public AlertViewDataDto(Long id, String name, String value, Character type) {
		super();
		this.id = id;
		this.name = name;
		this.value = value;
		this.type = type;
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

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Character getType() {
		return type;
	}

	public void setType(Character type) {
		this.type = type;
	}

}
