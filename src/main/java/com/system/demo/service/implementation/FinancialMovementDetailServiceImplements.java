package com.system.demo.service.implementation;

import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.system.demo.persistence.entity.FinancialMovementDetail;
import com.system.demo.persistence.repository.FinancialMovementDetailRepository;
import com.system.demo.service.FinancialMovementDetailService;

@Service
@Transactional
public class FinancialMovementDetailServiceImplements implements FinancialMovementDetailService{
	
	@Autowired
	FinancialMovementDetailRepository financialMovementDetailRepository;

	@Override
	public Iterable<FinancialMovementDetail> getAllFinancialMovementDetail() {
		return financialMovementDetailRepository.findAll();
	}

	@Override
	public FinancialMovementDetail createFinancialMovementDetail(FinancialMovementDetail financialMovementDetail) {
		return financialMovementDetailRepository.save(financialMovementDetail);
	}

	@Override
	public FinancialMovementDetail updateFinancialMovementDetail(FinancialMovementDetail financialMovementDetail) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FinancialMovementDetail financialMovementDetailById(long idRequisitionDetail, long idFinancialMovement) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<FinancialMovementDetail> getAllFinancialMovementDetailByDateRange(Date startDate, Date endDate) {
		// TODO Auto-generated method stub
		return financialMovementDetailRepository.findByFinancialMovementDetailDateRange(startDate, endDate);
	}

	@Override
	public double getSumAmountTypeByDateRange(Date startDate, Date endDate, Character financialMovementType) {
		// TODO Auto-generated method stub
		Double result = financialMovementDetailRepository.sumAmountTypeByFinancialMovementDetailDateRange(startDate, endDate, financialMovementType);
		return (result==null)? 0: result;
	}

}
