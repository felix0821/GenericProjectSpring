package com.system.demo.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.system.demo.persistence.entity.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course,Long> {
	
	@Query("SELECT c FROM Course c WHERE c.programId.programId = :programId")
	public Iterable<Course> findByCourseProgramId(Long programId);

}
