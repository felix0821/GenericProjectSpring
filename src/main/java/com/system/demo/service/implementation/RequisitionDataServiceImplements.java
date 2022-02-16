package com.system.demo.service.implementation;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.system.demo.persistence.entity.RequisitionData;
import com.system.demo.persistence.repository.RequisitionDataRepository;
import com.system.demo.service.RequisitionDataService;

@Service
@Transactional
public class RequisitionDataServiceImplements implements RequisitionDataService{
	
	@Autowired
	RequisitionDataRepository requisitionDataRepository;

	@Override
	public Iterable<RequisitionData> getRequisitionDatasByRequisitionId(long requisitionId) {
		return requisitionDataRepository.findByRequisitionId(requisitionId);
	}
	
	@Override
	public RequisitionData createRequisitionData(RequisitionData RequisitionData) throws Exception {
		return requisitionDataRepository.save(RequisitionData);
	}

}
