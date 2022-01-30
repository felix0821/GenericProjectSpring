package com.system.demo.service;

import com.system.demo.persistence.entity.PersonIdentificationDocument;

public interface PersonIdentificationDocumentService {
	
	public PersonIdentificationDocument createPersonIdentificationDocument(PersonIdentificationDocument personIdentificationDocument);
	public PersonIdentificationDocument personIdentificationDocumentById(long identificationDocumentId, long personId);

}
