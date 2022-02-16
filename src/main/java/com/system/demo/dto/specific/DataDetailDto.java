package com.system.demo.dto.specific;

public class DataDetailDto {
	
	private String text;
	
	private String value;

	public DataDetailDto(String text, String value) {
		super();
		this.text = text;
		this.value = value;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
