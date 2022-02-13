package com.system.demo.service;

import java.util.List;
import java.util.Optional;

import com.system.demo.persistence.entity.ProgramPeriod;

public interface ProgramPeriodService {
	
	Iterable<ProgramPeriod> getAllProgramPeriods();
	
	public ProgramPeriod createProgramPeriod(ProgramPeriod programPeriod) throws Exception;
	public List<ProgramPeriod> getProgramPeriodByProgramId(long programId);
	public List<ProgramPeriod> getProgramPeriodByPedagogicalPeriodId(long periodId);
	public void deleteProgramPeriod(long programId, long periodId);
	
	public Optional<ProgramPeriod> getProgramPeriodById(long programId, long periodId);
	
	public long getTotalProgramPeriodByPeriodId(long periodId);

}
