package com.system.demo.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.system.demo.persistence.entity.PersonIdentification;
import com.system.demo.persistence.entity.PersonIdentificationPK;

@Repository
public interface PersonIdentificationRepository extends JpaRepository<PersonIdentification,PersonIdentificationPK> {

}
