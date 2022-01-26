package com.system.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.system.demo.model.OccupationalField;

@Repository
public interface OccupationalFieldRepository extends JpaRepository<OccupationalField,Long> {
	
	public List<OccupationalField> findByProgramId(Long programId);

}