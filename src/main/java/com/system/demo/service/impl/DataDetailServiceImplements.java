package com.system.demo.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.system.demo.model.DataDetail;
import com.system.demo.repository.DataDetailRepository;
import com.system.demo.service.DataDetailService;

@Service
@Transactional
public class DataDetailServiceImplements implements DataDetailService {
	
	@Autowired
	DataDetailRepository dataDetailRepository;

	@Override
	public DataDetail createDataDetail(DataDetail dataDetail) throws Exception {
		return dataDetailRepository.save(dataDetail);
	}

}
