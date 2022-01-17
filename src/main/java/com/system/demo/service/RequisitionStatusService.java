package com.system.demo.service;

import com.system.demo.model.RequisitionStatus;

public interface RequisitionStatusService {
	
	Iterable<RequisitionStatus> getAllRequisitionStatus();
	
	public RequisitionStatus createRequisitionStatus(RequisitionStatus requisitionStatus);
	public RequisitionStatus updateRequisitionStatus(RequisitionStatus requisitionStatus);
	
	public RequisitionStatus RequisitionStatusById(Long id);

}
