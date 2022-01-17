package com.system.demo.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.system.demo.model.FinancialMovementDetail;
import com.system.demo.repository.FinancialMovementDetailRepository;

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
	public FinancialMovementDetail FinancialMovementDetailById(long idRequisitionDetail, long idFinancialMovement) {
		// TODO Auto-generated method stub
		return null;
	}

}
