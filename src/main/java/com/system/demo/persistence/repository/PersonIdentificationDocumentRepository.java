package com.system.demo.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.system.demo.persistence.entity.PersonIdentificationDocument;
import com.system.demo.persistence.entity.PersonIdentificationDocumentPK;

@Repository
public interface PersonIdentificationDocumentRepository extends JpaRepository<PersonIdentificationDocument,PersonIdentificationDocumentPK> {

}
