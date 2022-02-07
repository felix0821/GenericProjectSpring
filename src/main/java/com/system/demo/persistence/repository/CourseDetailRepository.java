package com.system.demo.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.system.demo.persistence.entity.CourseDetail;

@Repository
public interface CourseDetailRepository extends JpaRepository<CourseDetail,Long> {
	
	@Query("SELECT c FROM CourseDetail c WHERE c.programPeriod.programPeriodPK.programId = :programId AND c.programPeriod.programPeriodPK.pedagogicalPeriodId = :pedagogicalPeriodId")
	Iterable<CourseDetail> findByPrograPeriodId(long programId, long pedagogicalPeriodId);

}
