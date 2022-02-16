package com.system.demo.service;

import com.system.demo.persistence.entity.RequisitionData;

public interface RequisitionDataService {
	
	public Iterable<RequisitionData> getRequisitionDatasByRequisitionId(long requisitionId);
	
	public RequisitionData createRequisitionData(RequisitionData RequisitionData) throws Exception;

}
