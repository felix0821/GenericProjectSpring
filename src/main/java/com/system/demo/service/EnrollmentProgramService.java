package com.system.demo.service;

import java.util.List;

import com.system.demo.persistence.entity.EnrollmentProgram;

public interface EnrollmentProgramService {
	
	public EnrollmentProgram createEnrollmentProgramPeriod(EnrollmentProgram enrollmentProgramPeriod) throws Exception;
	public Iterable<EnrollmentProgram> getEnrollmentProgramPeriodByProgramPeriodId(long programId, long pedagogicalPeriodId);

}
