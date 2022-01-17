package com.system.demo.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.system.demo.model.RequisitionDetail;
import com.system.demo.repository.RequisitionDetailRepository;

@Service
@Transactional
public class RequisitionDetailServiceImplements implements RequisitionDetailService{
	
	@Autowired
	RequisitionDetailRepository requisitionDetailRepository;

	@Override
	public Iterable<RequisitionDetail> getAllRequisitionDetails() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RequisitionDetail createRequisitionDetail(RequisitionDetail requisitionDetail) {
		return requisitionDetailRepository.save(requisitionDetail);
	}

	@Override
	public RequisitionDetail updateRequisitionDetail(RequisitionDetail requisitionDetail) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RequisitionDetail RequisitionDetailById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
