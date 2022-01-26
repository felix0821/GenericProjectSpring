package com.system.demo.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.system.demo.model.RequisitionDataDetail;
import com.system.demo.repository.RequisitionDataDetailRepository;
import com.system.demo.service.RequisitionDataDetailService;

@Service
@Transactional
public class RequisitionDataDetailServiceImplements implements RequisitionDataDetailService {
	
	@Autowired
	RequisitionDataDetailRepository requisitionDataDetailRepository;

	@Override
	public RequisitionDataDetail createRequisitionDataDetail(RequisitionDataDetail requisitionDataDetail) {
		return requisitionDataDetailRepository.save(requisitionDataDetail);
	}

}
