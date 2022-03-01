package com.system.demo.service.implementation;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.system.demo.persistence.entity.FinancialRequisition;
import com.system.demo.persistence.repository.FinancialRequisitionRepository;
import com.system.demo.service.FinancialMovementRequisitionService;

@Service
@Transactional
public class FinancialMovementRequisitionServiceImplements implements FinancialMovementRequisitionService {
	
	@Autowired
	FinancialRequisitionRepository financialRequisitionRepository;

	@Override
	public Iterable<FinancialRequisition> getFinancialMovementRequisitionByFinancialMovementDetailId(
			long financialMovementDetailId) {
		// TODO Auto-generated method stub
		return financialRequisitionRepository.findByFinancialMovementDetailId(financialMovementDetailId);
	}

}
