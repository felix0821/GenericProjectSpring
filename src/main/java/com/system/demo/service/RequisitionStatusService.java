package com.system.demo.service;

import java.util.Optional;

import com.system.demo.persistence.entity.RequisitionStatus;

public interface RequisitionStatusService {
	
	Iterable<RequisitionStatus> getAllRequisitionStatus();
	
	public RequisitionStatus createRequisitionStatus(RequisitionStatus requisitionStatus);
	public RequisitionStatus updateRequisitionStatus(RequisitionStatus requisitionStatus);
	
	public Optional<RequisitionStatus> getRequisitionStatusById(Long id);

}
