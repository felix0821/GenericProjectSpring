package com.system.demo.service;

import com.system.demo.persistence.entity.Course;

public interface CourseService {
	
	public Iterable<Course> getCoursesByProgramId(Long programId);
	
	public Course createCourse(Course createCourse);

}
