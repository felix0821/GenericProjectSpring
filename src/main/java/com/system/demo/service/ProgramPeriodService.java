package com.system.demo.service;

import java.util.List;

import com.system.demo.model.ProgramPeriod;

public interface ProgramPeriodService {
	
	Iterable<ProgramPeriod> getAllProgramPeriods();
	
	public ProgramPeriod createProgramPeriod(ProgramPeriod programPeriod) throws Exception;
	public List<ProgramPeriod> getProgramPeriodByProgramId(Long programId);

}
