package com.system.demo.service;

import com.system.demo.persistence.entity.RequisitionDataDetail;

public interface RequisitionDataDetailService {
	
	public RequisitionDataDetail createRequisitionDataDetail(RequisitionDataDetail requisitionDataDetail);
	
	public Iterable<RequisitionDataDetail> getRequisitionDetailsByRequisitionDetailId(Long requisitionDetailId);

}
