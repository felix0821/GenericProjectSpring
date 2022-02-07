package com.system.demo.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;

import com.system.demo.persistence.entity.Course;
import com.system.demo.persistence.repository.CourseRepository;
import com.system.demo.service.CourseService;

public class CourseServiceImplements implements CourseService{
	
	@Autowired
	CourseRepository courseRepository;

	@Override
	public Iterable<Course> getCoursesByProgramId(Long programId) {
		return courseRepository.findByCourseProgramId(programId);
	}

	@Override
	public Course createCourse(Course createCourse) {
		return courseRepository.save(createCourse);
	}

}
