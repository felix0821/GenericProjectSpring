package com.system.demo.dto.specific;

public class MyProceduresStatusDto {
	
	String name;
	
	String color;

	public MyProceduresStatusDto(String name, String color) {
		super();
		this.name = name;
		this.color = color;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

}
