package com.system.demo.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.system.demo.persistence.entity.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course,Long> {
	
	@Query(value="SELECT c FROM Course c WHERE c.modulusId.modulusId IN (SELECT m.modulusId FROM Modulus m WHERE m.programId.programId = :programId)")
	public Iterable<Course> findByProgramId(@Param(value="programId")Long programId);
	
	@Query(value="SELECT c FROM Course c WHERE c.modulusId.modulusId = :modulusId")
	public Iterable<Course> findByModulusId(@Param(value="modulusId")Long modulusId);

}
