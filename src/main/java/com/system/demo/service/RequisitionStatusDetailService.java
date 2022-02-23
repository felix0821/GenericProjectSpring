package com.system.demo.service;

import com.system.demo.persistence.entity.RequisitionStatusDetail;

public interface RequisitionStatusDetailService {
	
	public RequisitionStatusDetail createRequisitionStatusDetail(RequisitionStatusDetail requisitionStatusDetail) throws Exception;
	public RequisitionStatusDetail updateRequisitionStatusDetail(RequisitionStatusDetail fromRequisitionStatusDetail) throws Exception;
	public Iterable<RequisitionStatusDetail> getRequisitionStatusDetailsByRequisitionDetailId(long requisitionStatusDetailId);

}
