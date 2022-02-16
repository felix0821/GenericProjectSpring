package com.system.demo.service.implementation;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.system.demo.persistence.entity.Data;
import com.system.demo.persistence.repository.DataRepository;
import com.system.demo.service.DataService;

@Service
@Transactional
public class DataServiceImplements implements DataService {
	
	@Autowired
	DataRepository dataRepository;

	@Override
	public Iterable<Data> getDatasByRequisitionId(Long RequisitionId) {
		return dataRepository.findByRequisitionId(RequisitionId);
	}
	
	@Override
	public Data createData(Data data) throws Exception {
		return dataRepository.save(data);
	}

	@Override
	public Optional<Data> getDataById(Long dataId) {
		return dataRepository.findById(dataId);
	}


}
