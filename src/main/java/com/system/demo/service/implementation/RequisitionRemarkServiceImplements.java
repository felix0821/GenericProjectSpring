package com.system.demo.service.implementation;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.system.demo.persistence.entity.RequisitionRemark;
import com.system.demo.persistence.repository.RequisitionRemarkRepository;
import com.system.demo.service.RequisitionRemarkService;

@Service
@Transactional
public class RequisitionRemarkServiceImplements implements RequisitionRemarkService {
	
	@Autowired
	RequisitionRemarkRepository requisitionRemarkRepository;

	@Override
	public Iterable<RequisitionRemark> getRequisitionRemarksByRequisitionDetailId(Long requisitionDetailId) {
		// TODO Auto-generated method stub
		return requisitionRemarkRepository.findByRequisitionDetailId(requisitionDetailId);
	}

	@Override
	public RequisitionRemark createRequisitionRemark(RequisitionRemark requisitionRemark) throws Exception {
		// TODO Auto-generated method stub
		return requisitionRemarkRepository.save(requisitionRemark);
	}

}
