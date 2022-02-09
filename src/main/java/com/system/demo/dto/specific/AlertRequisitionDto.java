package com.system.demo.dto.specific;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class AlertRequisitionDto {
	@NotNull(message = "Ingrese un id valido.")
	private Long idRegister;
	
	@NotBlank(message = "Ingrese un banco.")
	private String bank;
	
	@NotBlank(message = "Ingrese un documento.")
	private String document;
	
	private String comment;

	public AlertRequisitionDto(@NotNull(message = "Ingrese un id valido.") Long idRegister,
			@NotBlank(message = "Ingrese un banco.") String bank,
			@NotBlank(message = "Ingrese un documento.") String document, String comment) {
		super();
		this.idRegister = idRegister;
		this.bank = bank;
		this.document = document;
		this.comment = comment;
	}

	public Long getIdRegister() {
		return idRegister;
	}

	public void setIdRegister(Long idRegister) {
		this.idRegister = idRegister;
	}

	public String getBank() {
		return bank;
	}

	public void setBank(String banck) {
		this.bank = banck;
	}

	public String getDocument() {
		return document;
	}

	public void setDocument(String document) {
		this.document = document;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

}
