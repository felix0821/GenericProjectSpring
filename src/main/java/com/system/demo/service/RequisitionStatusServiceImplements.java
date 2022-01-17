package com.system.demo.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.system.demo.model.RequisitionStatus;
import com.system.demo.repository.RequisitionStatusRepository;

@Service
@Transactional
public class RequisitionStatusServiceImplements implements RequisitionStatusService{
	
	@Autowired
	RequisitionStatusRepository requisitionStatusRepository;

	@Override
	public Iterable<RequisitionStatus> getAllRequisitionStatus() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RequisitionStatus createRequisitionStatus(RequisitionStatus requisitionStatus) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RequisitionStatus updateRequisitionStatus(RequisitionStatus requisitionStatus) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RequisitionStatus RequisitionStatusById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
