package com.system.demo.service.implementation;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.system.demo.persistence.entity.PersonIdentification;
import com.system.demo.persistence.entity.PersonIdentificationPK;
import com.system.demo.persistence.repository.PersonIdentificationRepository;
import com.system.demo.service.PersonIdentificationService;

@Service
@Transactional
public class PersonIdentificationServiceImplements implements PersonIdentificationService{
	
	@Autowired
	PersonIdentificationRepository personIdentificationRepository;
	
	@Override
	public PersonIdentification createPersonIdentification(PersonIdentification personIdentification) {
		// TODO Auto-generated method stub
		return personIdentificationRepository.save(personIdentification);
	}

	@Override
	public Optional<PersonIdentification> getPersonIdentificationById(long personId, long identificationDocumentId) {
		// TODO Auto-generated method stub
		return personIdentificationRepository.findById(new PersonIdentificationPK(personId, identificationDocumentId));
	}

	@Override
	public boolean existsPersonIdentificationByValue(String value) {
		// TODO Auto-generated method stub
		return personIdentificationRepository.existsByPersonIdentificationValue(value);
	}

}
