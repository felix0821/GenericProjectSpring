package com.system.demo.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.system.demo.model.PedagogicalPeriod;
import com.system.demo.repository.PedagogicalPeriodRepository;
import com.system.demo.service.PedagogicalPeriodService;

@Service
@Transactional
public class PedagogicalPeriodServiceImplements implements PedagogicalPeriodService{
	
	@Autowired
	PedagogicalPeriodRepository pedagogicalPeriodRepository;

	@Override
	public Iterable<PedagogicalPeriod> getAllPedagogicalPeriods() {
		return pedagogicalPeriodRepository.findAll();
	}

	@Override
	public PedagogicalPeriod createPedagogicalPeriod(PedagogicalPeriod pedagogicalPeriod) throws Exception {
		return pedagogicalPeriodRepository.save(pedagogicalPeriod);
	}

}
