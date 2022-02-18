package com.system.demo.service.implementation;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.system.demo.persistence.entity.EnrollmentProgram;
import com.system.demo.persistence.repository.EnrollmentProgramRepository;
import com.system.demo.service.EnrollmentProgramService;

@Service
@Transactional
public class EnrollmentProgramServiceImplements implements EnrollmentProgramService {
	
	@Autowired
	EnrollmentProgramRepository enrollmentProgramRepository;

	@Override
	public EnrollmentProgram createEnrollmentProgramPeriod(EnrollmentProgram enrollmentProgramPeriod)
			throws Exception {
		return enrollmentProgramRepository.save(enrollmentProgramPeriod);
	}
	
	@Override
	public Iterable<EnrollmentProgram> getEnrollmentProgramPeriodByProgramPeriodId(long programId, long pedagogicalPeriodId) {
		return enrollmentProgramRepository.findByProgramPeriodId(programId, pedagogicalPeriodId);
	}

	

}
