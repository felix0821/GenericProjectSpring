package com.system.demo.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.system.demo.persistence.entity.Modulus;

@Repository
public interface ModulusRepository extends JpaRepository<Modulus,Long> {

}
