package com.system.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.system.demo.model.Modulus;

@Repository
public interface ModulusRepository extends JpaRepository<Modulus,Long> {

}
