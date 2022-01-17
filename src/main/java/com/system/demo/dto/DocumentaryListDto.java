package com.system.demo.dto;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotBlank;

public class DocumentaryListDto {
	
	@NotBlank(message = "Ingrese un nombre.")
	private String name;
	
	@NotBlank(message = "Ingrese una descripcion.")
	private String description;
	
	private List<DocumentaryListDetailDto> documentaries;

	public DocumentaryListDto(@NotBlank(message = "Ingrese un nombre.") String name,
			@NotBlank(message = "Ingrese una descripcion.") String description) {
		super();
		this.name = name;
		this.description = description;
		this.documentaries = new ArrayList<>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<DocumentaryListDetailDto> getDocumentaries() {
		return documentaries;
	}

	public void setDocumentaries(List<DocumentaryListDetailDto> documentaries) {
		this.documentaries = documentaries;
	}

}
