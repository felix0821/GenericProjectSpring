package com.system.demo.service;

import java.util.Optional;

import com.system.demo.persistence.entity.PersonIdentification;

public interface PersonIdentificationService {
	
	public PersonIdentification createPersonIdentification(PersonIdentification personIdentificationDocument);
	public Optional<PersonIdentification> getPersonIdentificationById(long identificationDocumentId, long personId);

}
