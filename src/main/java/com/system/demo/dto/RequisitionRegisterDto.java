package com.system.demo.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class RequisitionRegisterDto {
	
	@NotNull(message = "Ingrese un id valido.")
	private Long idProgram;
	
	@NotNull(message = "Ingrese una cantidad.")
	private Double amount;
	
	@NotBlank(message = "Ingrese un banco.")
	private String bank;
	
	@NotNull(message = "Ingrese un numero de operación.")
	private int operation;
	
	@NotBlank(message = "Ingrese una imagen")
	private String image;
	
	private String comment;

	public RequisitionRegisterDto(@NotNull(message = "Ingrese un id valido.") Long idProgram,
			@NotNull(message = "Ingrese una cantidad.") Double amount,
			@NotBlank(message = "Ingrese un banco.") String bank,
			@NotNull(message = "Ingrese un numero de operación.") int operation,
			@NotBlank(message = "Ingrese una imagen") String image, String comment) {
		super();
		this.idProgram = idProgram;
		this.amount = amount;
		this.bank = bank;
		this.operation = operation;
		this.image = image;
		this.comment = comment;
	}

	public Long getIdProgram() {
		return idProgram;
	}

	public void setIdProgram(Long idProgram) {
		this.idProgram = idProgram;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getBank() {
		return bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	public int getOperation() {
		return operation;
	}

	public void setOperation(int operation) {
		this.operation = operation;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}


}
