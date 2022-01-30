package com.system.demo.service;

import java.util.Optional;

import com.system.demo.persistence.entity.Requisition;

public interface RequisitionService {
	
	Iterable<Requisition> getAllRequisitions();
	
	public Requisition createRequisition(Requisition requisition);
	public Requisition updateRequisition(Requisition requisition);
	
	public Optional<Requisition> getRequisitionById(Long id) throws Exception;

}
