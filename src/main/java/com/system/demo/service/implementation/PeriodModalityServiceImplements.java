package com.system.demo.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;

import com.system.demo.persistence.entity.PeriodModality;
import com.system.demo.persistence.repository.PeriodModalityRepository;
import com.system.demo.service.PeriodModalityService;

public class PeriodModalityServiceImplements implements PeriodModalityService {
	
	@Autowired
	PeriodModalityRepository periodModalityRepository;

	@Override
	public PeriodModality getPeriodModalityById(String id) throws Exception {
		// TODO Auto-generated method stub
		return periodModalityRepository.findById(id).orElseThrow();
	}

}
