package com.system.demo.service;

import com.system.demo.persistence.entity.CourseDetail;

public interface CourseDetailService {
	
	Iterable<CourseDetail> getCourseDetailsByNotProgramPeriodId(long programId, long pedagogicalPeriodId);
	Iterable<CourseDetail> getCourseDetailsByProgramPeriodId(long programId, long pedagogicalPeriodId);

}
