package com.system.demo.service;

import com.system.demo.persistence.entity.FinancialMovementRequisition;

public interface FinancialMovementRequisitionService {
	
	public Iterable<FinancialMovementRequisition> getFinancialMovementRequisitionByFinancialMovementDetailId(long financialMovementDetailId);

}
