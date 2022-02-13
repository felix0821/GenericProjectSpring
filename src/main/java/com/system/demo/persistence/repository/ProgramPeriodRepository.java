package com.system.demo.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.system.demo.persistence.entity.ProgramPeriod;
import com.system.demo.persistence.entity.ProgramPeriodPK;

@Repository
public interface ProgramPeriodRepository extends JpaRepository<ProgramPeriod,ProgramPeriodPK> {
	
	public List<ProgramPeriod> findByProgramId(long programId);
	
	public List<ProgramPeriod> findByPeriodId(long periodId);
	
	@Query(value="SELECT COUNT(p) FROM ProgramPeriod p WHERE p.programPeriodPK.periodId = :periodId")
	public Long countByPeriodId(@Param(value="periodId")long pedagogicalPeriodId);

}
