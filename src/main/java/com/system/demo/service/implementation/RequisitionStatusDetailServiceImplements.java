package com.system.demo.service.implementation;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.system.demo.persistence.entity.RequisitionStatusDetail;
import com.system.demo.persistence.repository.RequisitionStatusDetailRepository;
import com.system.demo.service.RequisitionStatusDetailService;

@Service
@Transactional
public class RequisitionStatusDetailServiceImplements implements RequisitionStatusDetailService {
	
	@Autowired
	RequisitionStatusDetailRepository requisitionStatusDetailRepository;

	@Override
	public RequisitionStatusDetail createRequisitionStatusDetail(RequisitionStatusDetail requisitionStatusDetail)
			throws Exception {
		return requisitionStatusDetailRepository.save(requisitionStatusDetail);
	}

}