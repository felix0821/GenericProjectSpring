package com.system.demo.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.system.demo.model.Data;
import com.system.demo.repository.DataRepository;
import com.system.demo.service.DataService;

@Service
@Transactional
public class DataServiceImplements implements DataService {
	
	@Autowired
	DataRepository dataRepository;

	@Override
	public Data createData(Data data) throws Exception {
		return dataRepository.save(data);
	}

}
