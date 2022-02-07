package com.system.demo.service.implementation;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.system.demo.persistence.entity.EnrollmentProgramPeriod;
import com.system.demo.persistence.repository.EnrollmentProgramPeriodRepository;
import com.system.demo.service.EnrollmentProgramPeriodService;

@Service
@Transactional
public class EnrollmentProgramPeriodServiceImplements implements EnrollmentProgramPeriodService {
	
	@Autowired
	EnrollmentProgramPeriodRepository enrollmentProgramPeriodRepository;

	@Override
	public EnrollmentProgramPeriod createEnrollmentProgramPeriod(EnrollmentProgramPeriod enrollmentProgramPeriod)
			throws Exception {
		return enrollmentProgramPeriodRepository.save(enrollmentProgramPeriod);
	}
	
	@Override
	public Iterable<EnrollmentProgramPeriod> getEnrollmentProgramPeriodByProgramPeriodId(long programId, long pedagogicalPeriodId) {
		return enrollmentProgramPeriodRepository.findByProgramPeriodId(programId, pedagogicalPeriodId);
	}

	

}
