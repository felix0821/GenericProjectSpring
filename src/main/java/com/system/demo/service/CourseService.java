package com.system.demo.service;

import java.util.Optional;

import com.system.demo.persistence.entity.Course;

public interface CourseService {
	
	public Iterable<Course> getCoursesByProgramId(Long programId);
	public Iterable<Course> getCoursesByModulusId(Long modulusId);
	public Course createCourse(Course course) throws Exception;
	public Course updateCourse(Course fromCourse) throws Exception;
	public void deleteCourse(Long courseId) throws Exception;
	public Optional<Course> getCourseById(Long id);

}
