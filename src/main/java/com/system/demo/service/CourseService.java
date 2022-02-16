package com.system.demo.service;

import com.system.demo.persistence.entity.Course;

public interface CourseService {
	
	public Iterable<Course> getCoursesByProgramId(Long programId);
	public Iterable<Course> getCoursesByModulusId(Long modulusId);
	public Course createCourse(Course course) throws Exception;
	public Course updateCourse(Course fromCourse) throws Exception;
	public void deleteCourse(Long courseId) throws Exception;

}
