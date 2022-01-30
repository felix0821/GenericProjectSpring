package com.system.demo.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.system.demo.persistence.entity.ProgramPeriod;

@Repository
public interface ProgramPeriodRepository extends JpaRepository<ProgramPeriod,Long> {
	
	public List<ProgramPeriod> findByProgramId(Long programId);
	public List<ProgramPeriod> findByPedagogicalPeriodId(Long pedagogicalPeriodId);

}
