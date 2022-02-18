package com.system.demo.dto.specific;

public class ConfigurationCourseListDto {
	
	private Long id;
	private String identifier;
	private String name;
	private Integer index;
	private String acronym;
	private Character state;
	public ConfigurationCourseListDto(Long id, String identifier, String name, Integer index, String acronym,
			Character state) {
		super();
		this.id = id;
		this.identifier = identifier;
		this.name = name;
		this.index = index;
		this.acronym = acronym;
		this.state = state;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getIdentifier() {
		return identifier;
	}
	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getIndex() {
		return index;
	}
	public void setIndex(Integer index) {
		this.index = index;
	}
	public String getAcronym() {
		return acronym;
	}
	public void setAcronym(String acronym) {
		this.acronym = acronym;
	}
	public Character getState() {
		return state;
	}
	public void setState(Character state) {
		this.state = state;
	}

}
