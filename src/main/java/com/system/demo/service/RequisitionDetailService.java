package com.system.demo.service;

import java.util.Optional;

import com.system.demo.persistence.entity.RequisitionDetail;

public interface RequisitionDetailService {
	
	public Iterable<RequisitionDetail> getRequisitionDetailsByRequisitionIdNotChecking(Long requisitionId);
	
	public Iterable<RequisitionDetail> getAllRequisitionDetails();
	
	public RequisitionDetail createRequisitionDetail(RequisitionDetail requisitionDetail);
	public RequisitionDetail updateRequisitionDetail(RequisitionDetail requisitionDetail);
	
	public Optional<RequisitionDetail> RequisitionDetailById(Long id);

}
