package com.system.demo.service.implementation;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.system.demo.persistence.entity.Course;
import com.system.demo.persistence.repository.CourseRepository;
import com.system.demo.service.CourseService;

@Service
@Transactional
public class CourseServiceImplements implements CourseService{
	
	@Autowired
	CourseRepository courseRepository;

	@Override
	public Iterable<Course> getCoursesByProgramId(Long programId) {
		// TODO Auto-generated method stub
		return courseRepository.findByProgramId(programId);
	}
	
	@Override
	public Iterable<Course> getCoursesByModulusId(Long modulusId) {
		// TODO Auto-generated method stub
		return courseRepository.findByModulusId(modulusId);
	}

	@Override
	public Course createCourse(Course createCourse) throws Exception {
		// TODO Auto-generated method stub
		return courseRepository.save(createCourse);
	}

	@Override
	public Course updateCourse(Course fromCourse) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteCourse(Long courseId) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
