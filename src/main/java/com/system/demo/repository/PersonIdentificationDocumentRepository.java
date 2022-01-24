package com.system.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.system.demo.model.PersonIdentificationDocument;
import com.system.demo.model.PersonIdentificationDocumentPK;

@Repository
public interface PersonIdentificationDocumentRepository extends JpaRepository<PersonIdentificationDocument,PersonIdentificationDocumentPK> {

}
