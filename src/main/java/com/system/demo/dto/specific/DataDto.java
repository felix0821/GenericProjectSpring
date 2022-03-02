package com.system.demo.dto.specific;

import java.util.ArrayList;
import java.util.List;

public class DataDto {
	
	private Long id;
	
	private String name;
	
	private String value;
	
	private String description;
	
	private String placeholder;
	
	private String type;
	
	private Boolean selection;
	
	private String accept;
	
	private boolean required;
	
	private boolean disable;
	
	private List<DataDetailDto> data_detail;

	public DataDto(Long id, String name, String value, String description, String placeholder, String type, Boolean selection,
			String accept, boolean required, boolean disable) {
		super();
		this.id = id;
		this.name = name;
		this.value = value;
		this.description = description;
		this.placeholder = placeholder;
		this.type = type;
		this.selection = selection;
		this.accept = accept;
		this.required = required;
		this.disable = disable;
		this.data_detail = new ArrayList<>();
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPlaceholder() {
		return placeholder;
	}

	public void setPlaceholder(String placeholder) {
		this.placeholder = placeholder;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Boolean getSelection() {
		return selection;
	}

	public void setSelection(Boolean selection) {
		this.selection = selection;
	}

	public String getAccept() {
		return accept;
	}

	public void setAccept(String accept) {
		this.accept = accept;
	}

	public boolean isRequired() {
		return required;
	}

	public void setRequired(boolean required) {
		this.required = required;
	}

	public List<DataDetailDto> getData_detail() {
		return data_detail;
	}

	public void setData_detail(List<DataDetailDto> data_detail) {
		this.data_detail = data_detail;
	}

	public boolean isDisable() {
		return disable;
	}

	public void setDisable(boolean disable) {
		this.disable = disable;
	}
	

}
