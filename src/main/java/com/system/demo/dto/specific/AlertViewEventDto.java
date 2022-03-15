package com.system.demo.dto.specific;

public class AlertViewEventDto {
	
	private Long value;
	
	private String text;

	public AlertViewEventDto(Long value, String text) {
		super();
		this.value = value;
		this.text = text;
	}

	public Long getValue() {
		return value;
	}

	public void setValue(Long value) {
		this.value = value;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
}
