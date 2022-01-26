package com.system.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.system.demo.model.EnrollmentProgramPeriod;
import com.system.demo.model.EnrollmentProgramPeriodPK;

@Repository
public interface EnrollmentProgramPeriodRepository extends JpaRepository<EnrollmentProgramPeriod,EnrollmentProgramPeriodPK>{
	
	public List<EnrollmentProgramPeriod> findByProgramPeriodId(long programPeriodId);

}
