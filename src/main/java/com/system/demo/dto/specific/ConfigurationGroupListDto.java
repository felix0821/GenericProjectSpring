package com.system.demo.dto.specific;

public class ConfigurationGroupListDto {
	
	private Long id;
	private String name;
	private Integer capacity;
	private Character state;
	public ConfigurationGroupListDto(Long id, String name, Integer capacity, Character state) {
		super();
		this.id = id;
		this.name = name;
		this.capacity = capacity;
		this.state = state;
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
	public Integer getCapacity() {
		return capacity;
	}
	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}
	public Character getState() {
		return state;
	}
	public void setState(Character state) {
		this.state = state;
	}

}
