package com.system.demo.service.implementation;

import java.util.Optional;

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
	public Optional<PersonIdentificationDocument> getPersonIdentificationDocumentById(long identificationDocumentId, long personId) {
		return personIdentificationDocumentRepository.findById(new PersonIdentificationDocumentPK(identificationDocumentId, personId));
	}

}
