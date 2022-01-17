package com.system.demo.service;

import com.system.demo.model.FinancialMovement;

public interface FinancialMovementService {
	
	Iterable<FinancialMovement> getAllFinancialMovement();
	
	public FinancialMovement createFinancialMovement(FinancialMovement financialMovement);
	public FinancialMovement updateFinancialMovement(FinancialMovement financialMovement);
	
	public FinancialMovement FinancialMovementById(Long id);

}
