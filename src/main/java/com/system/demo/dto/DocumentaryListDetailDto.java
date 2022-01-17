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
	
	private String observation;

	public DocumentaryListDetailDto(@NotNull(message = "Ingrese una id correcto.") Long idRequisition,
			@NotBlank(message = "Ingrese un nombre de usuario.") String username,
			@NotBlank(message = "Ingrese un tipo de solicitud.") String typeRequisition, String observation) {
		super();
		this.idRequisition = idRequisition;
		this.username = username;
		this.typeRequisition = typeRequisition;
		this.observation = observation;
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

	public String getObservation() {
		return observation;
	}

	public void setObservation(String observation) {
		this.observation = observation;
	}

	public Long getIdRequisition() {
		return idRequisition;
	}

	public void setIdRequisition(Long idRequisition) {
		this.idRequisition = idRequisition;
	}


}
