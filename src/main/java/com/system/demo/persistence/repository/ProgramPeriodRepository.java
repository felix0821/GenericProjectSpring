package com.system.demo.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.system.demo.persistence.entity.ProgramPeriod;

@Repository
public interface ProgramPeriodRepository extends JpaRepository<ProgramPeriod,Long> {
	
	@Query("SELECT p FROM ProgramPeriod p WHERE p.programId.programId = :programId")
	public List<ProgramPeriod> findByProgramId(Long programId);
	
	@Query("SELECT p FROM ProgramPeriod p WHERE p.pedagogicalPeriodId.pedagogicalPeriodId = :pedagogicalPeriodId")
	public List<ProgramPeriod> findByPedagogicalPeriodId(Long pedagogicalPeriodId);

}
