package com.system.demo.service;

import com.system.demo.persistence.entity.RequisitionRemark;

public interface RequisitionRemarkService {
	
	public Iterable<RequisitionRemark> getRequisitionRemarksByRequisitionDetailId(Long requisitionDetailId);
	
	public RequisitionRemark createRequisitionRemark(RequisitionRemark requisitionRemark) throws Exception;

}
