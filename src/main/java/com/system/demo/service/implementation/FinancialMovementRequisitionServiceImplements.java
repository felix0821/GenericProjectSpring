package com.system.demo.service.implementation;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.system.demo.persistence.entity.FinancialMovementRequisition;
import com.system.demo.persistence.repository.FinancialMovementRequisitionRepository;
import com.system.demo.service.FinancialMovementRequisitionService;

@Service
@Transactional
public class FinancialMovementRequisitionServiceImplements implements FinancialMovementRequisitionService {
	
	@Autowired
	FinancialMovementRequisitionRepository financialMovementRequisitionRepository;

	@Override
	public Iterable<FinancialMovementRequisition> getFinancialMovementRequisitionByFinancialMovementDetailId(
			long financialMovementDetailId) {
		// TODO Auto-generated method stub
		return financialMovementRequisitionRepository.findByFinancialMovementDetailId(financialMovementDetailId);
	}

}
