package com.system.demo.service;

import com.system.demo.model.Requisition;

public interface RequisitionService {
	
	Iterable<Requisition> getAllRequisitions();
	
	public Requisition createRequisition(Requisition requisition);
	public Requisition updateRequisition(Requisition requisition);
	
	public Requisition getRequisitionById(Long id);

}
