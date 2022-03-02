package com.system.demo.service.implementation;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.system.demo.persistence.entity.PeriodModality;
import com.system.demo.persistence.repository.PeriodModalityRepository;
import com.system.demo.service.PeriodModalityService;

@Service
@Transactional
public class PeriodModalityServiceImplements implements PeriodModalityService {
	
	@Autowired
	PeriodModalityRepository periodModalityRepository;

	@Override
	public PeriodModality getPeriodModalityById(String id) throws Exception {
		// TODO Auto-generated method stub
		return periodModalityRepository.findById(id).orElseThrow();
	}

}
