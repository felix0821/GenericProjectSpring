package com.system.demo.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.system.demo.model.FinancialMovement;
import com.system.demo.repository.FinancialMovementRepository;

@Service
@Transactional
public class FinancialMovementServiceImplements implements FinancialMovementService {
	
	@Autowired
	FinancialMovementRepository financialMovementRepository;

	@Override
	public Iterable<FinancialMovement> getAllFinancialMovement() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FinancialMovement createFinancialMovement(FinancialMovement financialMovement) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FinancialMovement updateFinancialMovement(FinancialMovement financialMovement) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FinancialMovement FinancialMovementById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
