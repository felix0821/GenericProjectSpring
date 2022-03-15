package com.system.demo.dto.specific;

public class AlertViewEventDto<T> {
	
	private Long event;
	
	private T value;

	public AlertViewEventDto(Long event, T value) {
		super();
		this.event = event;
		this.value = value;
	}

	public Long getEvent() {
		return event;
	}

	public void setEvent(Long event) {
		this.event = event;
	}

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}
	
}
