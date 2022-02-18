package com.system.demo.persistence.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.system.demo.persistence.entity.Modulus;

@Repository
public interface ModulusRepository extends JpaRepository<Modulus,Long> {
	
	@Query(value="SELECT m FROM Modulus m WHERE m.programId.programId = :programId")
	public Iterable<Modulus> findByProgramId(@Param(value="programId")Long programId);

	public Optional<Modulus> findByModulusIdentifier(@Param(value="modulusIdentifier")String modulusIdentifier);
}
