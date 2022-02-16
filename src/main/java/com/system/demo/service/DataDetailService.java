package com.system.demo.service;

import com.system.demo.persistence.entity.DataDetail;

public interface DataDetailService {
	
	public DataDetail createDataDetail(DataDetail dataDetail) throws Exception;
	
	public Iterable<DataDetail> getDataDetailsByDataId(Long DataId);

}
