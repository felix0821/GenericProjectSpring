package com.system.demo.service.implementation;

import java.util.Date;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.system.demo.persistence.entity.RequisitionDetail;
import com.system.demo.persistence.repository.RequisitionDetailRepository;
import com.system.demo.service.RequisitionDetailService;

@Service
@Transactional
public class RequisitionDetailServiceImplements implements RequisitionDetailService{
	
	@Autowired
	RequisitionDetailRepository requisitionDetailRepository;
	
	@Override
	public Iterable<RequisitionDetail> getAllRequisitionDetailByNotCheckingByPersonId(Long personId) {
		// TODO Auto-generated method stub
		return requisitionDetailRepository.findByPersonIdAndNotChecking(personId);
	}

	@Override
	public Iterable<RequisitionDetail> getAllRequisitionDetails() {
		// TODO Auto-generated method stub
		return requisitionDetailRepository.findAll();
	}

	@Override
	public RequisitionDetail createRequisitionDetail(RequisitionDetail requisitionDetail) {
		// TODO Auto-generated method stub
		return requisitionDetailRepository.save(requisitionDetail);
	}

	@Override
	public RequisitionDetail updateRequisitionDetail(RequisitionDetail requisitionDetail) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<RequisitionDetail> RequisitionDetailById(Long id) {
		return requisitionDetailRepository.findById(id);
	}

	@Override
	public void checkingRequisitionDetailById(Long id) {
		// TODO Auto-generated method stub
		requisitionDetailRepository.checkingByRequisitionDetailId(id);
	}

	@Override
	public Iterable<RequisitionDetail> getAllRequisitionDetailByPersonId(Long personId) {
		// TODO Auto-generated method stub
		return requisitionDetailRepository.findByPersonId(personId);
	}

	@Override
	public Iterable<RequisitionDetail> getAllRequisitionDetailsByDateRange(Date startDate, Date endDate) {
		// TODO Auto-generated method stub
		return requisitionDetailRepository.findByRequisitionDetailDateRange(startDate, endDate);
	}

}
