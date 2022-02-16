package com.system.demo.service;

import java.util.Optional;

import com.system.demo.persistence.entity.Data;

public interface DataService {
	public Iterable<Data> getDatasByRequisitionId(Long RequisitionId);
	public Data createData(Data data) throws Exception;
	public Optional<Data> getDataById(Long dataId);

}
