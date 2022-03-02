package com.system.demo.service.implementation;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.system.demo.persistence.entity.RequisitionUses;
import com.system.demo.persistence.repository.RequisitionUsesRepository;
import com.system.demo.service.RequisitionUsesService;

@Service
@Transactional
public class RequisitionUsesServiceImplements implements RequisitionUsesService{

	@Autowired
	RequisitionUsesRepository requisitionUsesRepository;
	
	@Override
	public RequisitionUses createRequisitionUses(RequisitionUses RequisitionUses) throws Exception {
		// TODO Auto-generated method stub
		return requisitionUsesRepository.save(RequisitionUses);
	}

}
