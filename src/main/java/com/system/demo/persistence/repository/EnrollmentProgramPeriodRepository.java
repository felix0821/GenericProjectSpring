package com.system.demo.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.system.demo.persistence.entity.EnrollmentProgramPeriod;
import com.system.demo.persistence.entity.EnrollmentProgramPeriodPK;

@Repository
public interface EnrollmentProgramPeriodRepository extends JpaRepository<EnrollmentProgramPeriod,EnrollmentProgramPeriodPK>{
	
	@Query("SELECT e FROM EnrollmentProgramPeriod e WHERE e.enrollmentProgramPeriodPK.programId = :programId AND e.enrollmentProgramPeriodPK.periodId = :periodId")
	public List<EnrollmentProgramPeriod> findByProgramPeriodId(@Param(value="programId")long programId, @Param(value="periodId")long periodId);

}
