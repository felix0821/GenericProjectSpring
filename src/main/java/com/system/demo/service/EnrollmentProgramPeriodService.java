package com.system.demo.service;

import java.util.List;

import com.system.demo.model.EnrollmentProgramPeriod;

public interface EnrollmentProgramPeriodService {
	
	public EnrollmentProgramPeriod createEnrollmentProgramPeriod(EnrollmentProgramPeriod enrollmentProgramPeriod) throws Exception;
	public List<EnrollmentProgramPeriod> getEnrollmentProgramPeriodByProgramPeriodId(long yProgramPeriodId);

}
