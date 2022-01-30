package com.system.demo.service;

import com.system.demo.persistence.entity.RequisitionDetail;

public interface RequisitionDetailService {
	
	Iterable<RequisitionDetail> getAllRequisitionDetails();
	
	public RequisitionDetail createRequisitionDetail(RequisitionDetail requisitionDetail);
	public RequisitionDetail updateRequisitionDetail(RequisitionDetail requisitionDetail);
	
	public RequisitionDetail RequisitionDetailById(Long id);

}
