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
		return personIdentificationRepository.save(personIdentification);
	}

	@Override
	public Optional<PersonIdentification> getPersonIdentificationById(long identificationDocumentId, long personId) {
		return personIdentificationRepository.findById(new PersonIdentificationPK(identificationDocumentId, personId));
	}

}
