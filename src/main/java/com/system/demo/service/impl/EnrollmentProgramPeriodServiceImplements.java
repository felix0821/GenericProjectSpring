package com.system.demo.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.system.demo.model.EnrollmentProgramPeriod;
import com.system.demo.repository.EnrollmentProgramPeriodRepository;
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
	public List<EnrollmentProgramPeriod> getEnrollmentProgramPeriodByProgramPeriodId(long yProgramPeriodId) {
		return enrollmentProgramPeriodRepository.findByProgramPeriodId(yProgramPeriodId);
	}

	

}
