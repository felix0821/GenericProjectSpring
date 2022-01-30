package com.system.demo.service.implementation;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.system.demo.persistence.entity.PersonIdentificationDocument;
import com.system.demo.persistence.entity.PersonIdentificationDocumentPK;
import com.system.demo.persistence.repository.PersonIdentificationDocumentRepository;
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
