package com.system.demo.service.impl;

import com.system.demo.model.ProgramPeriod;

public interface ProgramPeriodService {
	
	Iterable<ProgramPeriod> getAllProgramPeriods();
	
	public ProgramPeriod createProgramPeriod(ProgramPeriod programPeriod) throws Exception;

}
