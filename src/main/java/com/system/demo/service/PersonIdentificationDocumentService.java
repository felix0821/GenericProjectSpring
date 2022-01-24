package com.system.demo.service;

import com.system.demo.model.PersonIdentificationDocument;

public interface PersonIdentificationDocumentService {
	
	public PersonIdentificationDocument createPersonIdentificationDocument(PersonIdentificationDocument personIdentificationDocument);
	public PersonIdentificationDocument personIdentificationDocumentById(long identificationDocumentId, long personId);

}
