package com.system.demo.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.system.demo.persistence.entity.CourseDetail;

@Repository
public interface CourseDetailRepository extends JpaRepository<CourseDetail,Long> {
	
	@Query(value="SELECT c FROM CourseDetail c WHERE c.modulusDetail.modulusDetailPK.programId = :programId AND c.modulusDetail.modulusDetailPK.periodId = :periodId")
	Iterable<CourseDetail> findByPrograPeriodId(@Param(value="programId")long programId, @Param(value="periodId")long periodId);

}
