package com.system.demo.dto;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class DocumentaryListDetailDto {
	
	@NotNull(message = "Ingrese una id correcto.")
	private Long idRequisition;
	
	@NotBlank(message = "Ingrese un nombre de usuario.")
	private String username;
	
	@NotBlank(message = "Ingrese un tipo de solicitud.")
	private String typeRequisition;
	
	private Date date;

	public DocumentaryListDetailDto(@NotNull(message = "Ingrese una id correcto.") Long idRequisition,
			@NotBlank(message = "Ingrese un nombre de usuario.") String username,
			@NotBlank(message = "Ingrese un tipo de solicitud.") String typeRequisition, Date date) {
		super();
		this.idRequisition = idRequisition;
		this.username = username;
		this.typeRequisition = typeRequisition;
		this.date = date;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getTypeRequisition() {
		return typeRequisition;
	}

	public void setTypeRequisition(String typeRequisition) {
		this.typeRequisition = typeRequisition;
	}

	public Date getObservation() {
		return date;
	}

	public void setObservation(Date date) {
		this.date = date;
	}

	public Long getIdRequisition() {
		return idRequisition;
	}

	public void setIdRequisition(Long idRequisition) {
		this.idRequisition = idRequisition;
	}


}
