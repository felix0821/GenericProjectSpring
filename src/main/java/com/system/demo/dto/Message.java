package com.system.demo.dto;

import javax.validation.constraints.NotBlank;

public class Message {
	@NotBlank
	private String content;

	public Message(@NotBlank String content) {
		this.content = content;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
