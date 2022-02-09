package com.system.demo.persistence.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.system.demo.persistence.entity.Program;

@Repository
public interface ProgramRepository extends JpaRepository<Program,Long> {
	
	public Optional<Program> findByProgramIdentifier(String programIdentifier);
	
	public List<Program> findByProgramState(Character programState);
	
	@Query(value = "SELECT p FROM Program p WHERE p.programId NOT IN (SELECT pg.programPeriodPK.programId FROM ProgramPeriod pg WHERE pg.programPeriodPK.pedagogicalPeriodId = :pedagogicalPeriodId)")
	public Iterable<Program> findByProgramNotPedagogicalPeriodId(@Param(value = "pedagogicalPeriodId")Long pedagogicalPeriodId);

}
