package com.system.demo.service;

import java.util.Date;
import java.util.Optional;

import com.system.demo.persistence.entity.RequisitionDetail;

public interface RequisitionDetailService {
	
	public Iterable<RequisitionDetail> getAllRequisitionDetailByNotCheckingByPersonId(Long personId);
	
	public Iterable<RequisitionDetail> getAllRequisitionDetails();
	
	public RequisitionDetail createRequisitionDetail(RequisitionDetail requisitionDetail);
	public RequisitionDetail updateRequisitionDetail(RequisitionDetail requisitionDetail);
	
	public Optional<RequisitionDetail> RequisitionDetailById(Long id);
	
	public void checkingRequisitionDetailById(Long id);
	
	public Iterable<RequisitionDetail> getAllRequisitionDetailByPersonId(Long personId);
	
	public Iterable<RequisitionDetail> getAllRequisitionDetailsByDateRange(Date startDate, Date endDate);

}
