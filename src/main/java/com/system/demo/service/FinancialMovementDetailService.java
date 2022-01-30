package com.system.demo.service;

import com.system.demo.persistence.entity.FinancialMovementDetail;

public interface FinancialMovementDetailService {
	
	Iterable<FinancialMovementDetail> getAllFinancialMovementDetail();
	
	public FinancialMovementDetail createFinancialMovementDetail(FinancialMovementDetail financialMovementDetail);
	public FinancialMovementDetail updateFinancialMovementDetail(FinancialMovementDetail financialMovementDetail);
	
	public FinancialMovementDetail financialMovementDetailById(long idRequisitionDetail, long idFinancialMovement);

}
