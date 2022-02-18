package com.system.demo.service;

import com.system.demo.persistence.entity.GroupTeaching;

public interface GroupTeachingService {
	
	public Iterable<GroupTeaching> getGroupTeachingByNotProgramId(Long programId);

}
