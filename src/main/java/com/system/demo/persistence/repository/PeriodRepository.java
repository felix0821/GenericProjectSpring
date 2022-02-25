package com.system.demo.persistence.repository;

import java.util.Date;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.system.demo.persistence.entity.Period;

@Repository
public interface PeriodRepository extends JpaRepository<Period,Long> {
	
	public Optional<Period> findByPeriodIdentifier(String periodIdentifier);
	
	@Query(value = "SELECT DISTINCT p FROM Period p INNER JOIN ProgramPeriod pp ON p.periodId = pp.programPeriodPK.periodId WHERE pp.programPeriodOpening <= :currentDate AND pp.programPeriodEnrollmentClosure >= :currentDate")
	public Iterable<Period> findDistintByJoinProgramPeriodEnrollmentAvailable(@Param("currentDate")Date currentDate);
}
