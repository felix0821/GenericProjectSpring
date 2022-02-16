package com.system.demo.service.implementation;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.system.demo.persistence.entity.RequisitionStatus;
import com.system.demo.persistence.repository.RequisitionStatusRepository;
import com.system.demo.service.RequisitionStatusService;

@Service
@Transactional
public class RequisitionStatusServiceImplements implements RequisitionStatusService{
	
	@Autowired
	RequisitionStatusRepository requisitionStatusRepository;

	@Override
	public Iterable<RequisitionStatus> getAllRequisitionStatus() {
		return requisitionStatusRepository.findAll();
	}

	@Override
	public RequisitionStatus createRequisitionStatus(RequisitionStatus requisitionStatus) {
		return requisitionStatusRepository.save(requisitionStatus);
	}

	@Override
	public RequisitionStatus updateRequisitionStatus(RequisitionStatus requisitionStatus) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<RequisitionStatus> getRequisitionStatusById(Long id) {
		return requisitionStatusRepository.findById(id);
	}

}
