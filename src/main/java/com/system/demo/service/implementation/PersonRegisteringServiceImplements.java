package com.system.demo.service.implementation;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.system.demo.persistence.entity.PersonRegistering;
import com.system.demo.persistence.repository.PersonRegisteringRepository;
import com.system.demo.service.PersonRegisteringService;

@Service
@Transactional
public class PersonRegisteringServiceImplements implements PersonRegisteringService{
	
	@Autowired
	PersonRegisteringRepository personRegisteringRepository;

	@Override
	public PersonRegistering createPersonRegistering(PersonRegistering personRegistering) throws Exception {
		// TODO Auto-generated method stub
		return personRegisteringRepository.save(personRegistering);
	}

}
