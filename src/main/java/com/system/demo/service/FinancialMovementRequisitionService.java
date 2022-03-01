package com.system.demo.service;

import com.system.demo.persistence.entity.FinancialRequisition;

public interface FinancialMovementRequisitionService {
	
	public Iterable<FinancialRequisition> getFinancialMovementRequisitionByFinancialMovementDetailId(long financialMovementDetailId);

}
