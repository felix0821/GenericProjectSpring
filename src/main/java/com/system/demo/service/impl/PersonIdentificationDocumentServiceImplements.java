package com.system.demo.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.system.demo.model.PersonIdentificationDocument;
import com.system.demo.model.PersonIdentificationDocumentPK;
import com.system.demo.repository.PersonIdentificationDocumentRepository;
import com.system.demo.service.PersonIdentificationDocumentService;

@Service
@Transactional
public class PersonIdentificationDocumentServiceImplements implements PersonIdentificationDocumentService{
	
	@Autowired
	PersonIdentificationDocumentRepository personIdentificationDocumentRepository;
	
	@Override
	public PersonIdentificationDocument createPersonIdentificationDocument(
			PersonIdentificationDocument personIdentificationDocument) {
		return personIdentificationDocumentRepository.save(personIdentificationDocument);
	}

	@Override
	public PersonIdentificationDocument personIdentificationDocumentById(long identificationDocumentId, long personId) {
		PersonIdentificationDocumentPK PersonIdentificationDocumentPK = new PersonIdentificationDocumentPK(identificationDocumentId,
				personId);
		return personIdentificationDocumentRepository.getById(PersonIdentificationDocumentPK);
	}

}
