package com.system.demo.service.implementation;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.system.demo.persistence.entity.CourseDetail;
import com.system.demo.persistence.repository.CourseDetailRepository;
import com.system.demo.service.CourseDetailService;

@Service
@Transactional
public class CourseDetailServiceImplements implements CourseDetailService {
	
	@Autowired
	CourseDetailRepository courseDetailRepository;

	@Override
	public Iterable<CourseDetail> getCourseDetailsByNotProgramPeriodId(long programId, long pedagogicalPeriodId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<CourseDetail> getCourseDetailsByProgramPeriodId(long programId, long pedagogicalPeriodId) {
		return courseDetailRepository.findByPrograPeriodId(programId, pedagogicalPeriodId);
	}

}
