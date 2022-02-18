package com.system.demo.service.implementation;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.system.demo.persistence.entity.GroupTeaching;
import com.system.demo.persistence.repository.GroupTeachingRepository;
import com.system.demo.service.GroupTeachingService;

@Service
@Transactional
public class GroupTeachingServiceImplements implements GroupTeachingService {
	
	@Autowired
	GroupTeachingRepository groupTeachingRepository;

	@Override
	public Iterable<GroupTeaching> getGroupTeachingByNotProgramId(Long programId) {
		// TODO Auto-generated method stub
		return groupTeachingRepository.findByGroupTeachingNotProgramId(programId);
	}

}
