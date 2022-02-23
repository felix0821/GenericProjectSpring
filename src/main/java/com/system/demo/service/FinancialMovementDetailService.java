package com.system.demo.service;

import java.util.Date;

import com.system.demo.persistence.entity.FinancialMovementDetail;

public interface FinancialMovementDetailService {
	
	public Iterable<FinancialMovementDetail> getAllFinancialMovementDetail();
	
	public FinancialMovementDetail createFinancialMovementDetail(FinancialMovementDetail financialMovementDetail);
	public FinancialMovementDetail updateFinancialMovementDetail(FinancialMovementDetail financialMovementDetail);
	
	public FinancialMovementDetail financialMovementDetailById(long idRequisitionDetail, long idFinancialMovement);
	
	public Iterable<FinancialMovementDetail> getAllFinancialMovementDetailByDateRange(Date startDate, Date endDate);
	
	public double getSumAmountTypeByDateRange(Date startDate, Date endDate, Character financialMovementType);

}
