package com.system.demo.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.system.demo.persistence.entity.ProgramPeriod;
import com.system.demo.persistence.entity.ProgramPeriodPK;

@Repository
public interface ProgramPeriodRepository extends JpaRepository<ProgramPeriod,ProgramPeriodPK> {
	
	public List<ProgramPeriod> findByProgramId(long programId);
	
	public List<ProgramPeriod> findByPedagogicalPeriodId(long pedagogicalPeriodId);

}
