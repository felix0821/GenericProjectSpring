package com.system.demo.service;

import com.system.demo.model.FinancialMovementDetail;

public interface FinancialMovementDetailService {
	
	Iterable<FinancialMovementDetail> getAllFinancialMovementDetail();
	
	public FinancialMovementDetail createFinancialMovementDetail(FinancialMovementDetail financialMovementDetail);
	public FinancialMovementDetail updateFinancialMovementDetail(FinancialMovementDetail financialMovementDetail);
	
	public FinancialMovementDetail FinancialMovementDetailById(long idRequisitionDetail, long idFinancialMovement);

}