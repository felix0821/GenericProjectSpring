package com.system.demo.service.implementation;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.system.demo.persistence.entity.Requisition;
import com.system.demo.persistence.repository.RequisitionRepository;
import com.system.demo.service.RequisitionService;

@Service
@Transactional
public class RequisitionServiceImplements implements RequisitionService{
	
	@Autowired
	RequisitionRepository requisitionRepository;

	@Override
	public Iterable<Requisition> getAllRequisitions() {
		return requisitionRepository.findAll();
	}

	@Override
	public Requisition createRequisition(Requisition requisition) {
		return requisitionRepository.save(requisition);
	}

	@Override
	public Requisition updateRequisition(Requisition requisition) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Requisition> getRequisitionById(Long id) throws Exception{
		return requisitionRepository.findById(id);
	}

}
