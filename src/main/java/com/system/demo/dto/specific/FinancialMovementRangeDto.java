package com.system.demo.dto.specific;

import java.util.Date;

import javax.validation.constraints.NotNull;

public class FinancialMovementRangeDto {
	
	@NotNull(message = "Ingrese una fecha de inicio.")
	private Date startDate;
	
	@NotNull(message = "Ingrese una fecha de cierre.")
	private Date endDate;

	public FinancialMovementRangeDto(@NotNull(message = "Ingrese una fecha de inicio.") Date startDate,
			@NotNull(message = "Ingrese una fecha de cierre.") Date endDate) {
		super();
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

}
