package com.system.demo.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class FinancialMovementListDto {
	
	@NotNull(message = "Ingrese un id valido")
	private Long id;
	
	@NotBlank(message = "Ingrese un nombre.")
	private String name;
	
	@NotBlank(message = "Ingrese un simbolo.")
	private String symbol;
	
	@NotNull(message = "Ingrese una cantidad.")
	private Double amount;
	
	@NotBlank(message = "Ingrese un banco.")
	private String bank;
	
	@NotBlank(message = "Ingrese un documento.")
	private String document;

	public FinancialMovementListDto(@NotNull(message = "Ingrese un id valido") Long id,
			@NotBlank(message = "Ingrese un nombre.") String name,
			@NotBlank(message = "Ingrese un simbolo.") String symbol,
			@NotNull(message = "Ingrese una cantidad.") Double amount,
			@NotBlank(message = "Ingrese un banco.") String bank,
			@NotBlank(message = "Ingrese un documento.") String document) {
		super();
		this.id = id;
		this.name = name;
		this.symbol = symbol;
		this.amount = amount;
		this.bank = bank;
		this.document = document;
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

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
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

	public String getDocument() {
		return document;
	}

	public void setDocument(String document) {
		this.document = document;
	}

}
