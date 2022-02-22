package com.system.demo.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.system.demo.persistence.entity.PersonRegistering;

@Repository
public interface PersonRegisteringRepository extends JpaRepository<PersonRegistering,Long> {

}
