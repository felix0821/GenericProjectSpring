package com.system.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.system.demo.model.IdentificationDocument;

@Repository
public interface IdentificationDocumentRepository extends JpaRepository<IdentificationDocument,Long> {

}
