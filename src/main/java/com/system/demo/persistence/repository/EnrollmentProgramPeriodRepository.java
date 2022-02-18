package com.system.demo.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.system.demo.persistence.entity.EnrollmentProgram;
import com.system.demo.persistence.entity.EnrollmentProgramPK;

@Repository
public interface EnrollmentProgramPeriodRepository extends JpaRepository<EnrollmentProgram,EnrollmentProgramPK>{
	
	@Query("SELECT e FROM EnrollmentProgram e WHERE e.enrollmentProgramPK.programId = :programId AND e.enrollmentProgramPK.periodId = :periodId")
	public List<EnrollmentProgram> findByProgramPeriodId(@Param(value="programId")long programId, @Param(value="periodId")long periodId);

}
