package com.system.demo.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;

import com.system.demo.persistence.entity.GroupTeaching;
import com.system.demo.persistence.repository.GroupTeachingRepository;
import com.system.demo.service.GroupTeachingService;

public class GroupTeachingServiceImplements implements GroupTeachingService {
	
	@Autowired
	GroupTeachingRepository groupTeachingRepository;

	@Override
	public Iterable<GroupTeaching> getGroupTeachingByNotProgramId(Long programId) {
		// TODO Auto-generated method stub
		return groupTeachingRepository.findByGroupTeachingNotProgramId(programId);
	}

}
