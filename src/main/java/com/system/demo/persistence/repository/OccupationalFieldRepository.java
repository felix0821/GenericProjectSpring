package com.system.demo.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.system.demo.persistence.entity.OccupationalField;

@Repository
public interface OccupationalFieldRepository extends JpaRepository<OccupationalField,Long> {
	
	@Query("SELECT o FROM OccupationalField o WHERE o.programId.programId = :programId")
	public List<OccupationalField> findByProgramId(Long programId);

}
