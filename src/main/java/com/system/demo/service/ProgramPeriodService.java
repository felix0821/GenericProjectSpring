package com.system.demo.service;

import java.util.List;

import com.system.demo.persistence.entity.ProgramPeriod;

public interface ProgramPeriodService {
	
	Iterable<ProgramPeriod> getAllProgramPeriods();
	
	public ProgramPeriod createProgramPeriod(ProgramPeriod programPeriod) throws Exception;
	public List<ProgramPeriod> getProgramPeriodByProgramId(Long programId);
	public List<ProgramPeriod> getProgramPeriodByPedagogicalPeriodId(Long pedagogicalPeriodId);

}
