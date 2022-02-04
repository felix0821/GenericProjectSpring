package com.system.demo.service;

import java.util.Optional;

import com.system.demo.persistence.entity.PersonIdentificationDocument;

public interface PersonIdentificationDocumentService {
	
	public PersonIdentificationDocument createPersonIdentificationDocument(PersonIdentificationDocument personIdentificationDocument);
	public Optional<PersonIdentificationDocument> getPersonIdentificationDocumentById(long identificationDocumentId, long personId);

}
