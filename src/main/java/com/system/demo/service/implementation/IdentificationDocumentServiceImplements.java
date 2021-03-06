package com.system.demo.service.implementation;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.system.demo.persistence.entity.IdentificationDocument;
import com.system.demo.persistence.repository.IdentificationDocumentRepository;
import com.system.demo.service.IdentificationDocumentService;

@Service
@Transactional
public class IdentificationDocumentServiceImplements implements IdentificationDocumentService{
	
	@Autowired
	IdentificationDocumentRepository identificationDocumentRepository;

	@Override
	public IdentificationDocument createIdentificationDocument(IdentificationDocument identificationDocument)
			throws Exception {
		return identificationDocumentRepository.save(identificationDocument);
	}

}
