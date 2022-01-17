package com.system.demo.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class RequisitionRegisterDto {
	
	@NotNull(message = "Ingrese un id valido.")
	private Long idRegister;
	
	@NotNull(message = "Ingrese una cantidad.")
	private Double amount;
	
	@NotBlank(message = "Ingrese un banco.")
	private String banck;
	
	@NotBlank(message = "Ingrese un documento.")
	private String document;
	
	@NotBlank(message = "Ingrese un comentario.")
	private String comment;

	public RequisitionRegisterDto(@NotNull(message = "Ingrese un id valido.") Long idRegister,
			@NotNull(message = "Ingrese una cantidad.") Double amount,
			@NotBlank(message = "Ingrese un banco.") String banck,
			@NotBlank(message = "Ingrese un documento.") String document,
			@NotBlank(message = "Ingrese un comentario.") String comment) {
		super();
		this.idRegister = idRegister;
		this.amount = amount;
		this.banck = banck;
		this.document = document;
		this.comment = comment;
	}

	public Long getIdRegister() {
		return idRegister;
	}

	public void setIdRegister(Long idRegister) {
		this.idRegister = idRegister;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getBanck() {
		return banck;
	}

	public void setBanck(String banck) {
		this.banck = banck;
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
