package com.system.demo.dto.specific;

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
	
	@NotBlank(message = "Ingrese un tipo de registro.")
	private String registerType;

	private int operationNumber;
	
	
	public FinancialMovementListDto(@NotNull(message = "Ingrese un id valido") Long id,
			@NotBlank(message = "Ingrese un nombre.") String name,
			@NotBlank(message = "Ingrese un simbolo.") String symbol,
			@NotNull(message = "Ingrese una cantidad.") Double amount,
			@NotBlank(message = "Ingrese un tipo de registro.") String registerType, int operationNumber) {
		super();
		this.id = id;
		this.name = name;
		this.symbol = symbol;
		this.amount = amount;
		this.registerType = registerType;
		this.operationNumber = operationNumber;
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

	public String getRegisterType() {
		return registerType;
	}

	public void setRegisterType(String registerType) {
		this.registerType = registerType;
	}

	public int getOperationNumber() {
		return operationNumber;
	}

	public void setOperationNumber(int operationNumber) {
		this.operationNumber = operationNumber;
	}

}
