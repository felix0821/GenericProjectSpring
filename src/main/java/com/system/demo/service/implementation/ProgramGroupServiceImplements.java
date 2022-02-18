package com.system.demo.service.implementation;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.system.demo.persistence.entity.ProgramGroup;
import com.system.demo.persistence.entity.ProgramGroupPK;
import com.system.demo.persistence.repository.ProgramGroupRepository;
import com.system.demo.service.ProgramGroupService;

@Service
@Transactional
public class ProgramGroupServiceImplements implements ProgramGroupService{
	
	@Autowired
	ProgramGroupRepository programGroupRepository;

	@Override
	public Iterable<ProgramGroup> getProgramGroupByProgramId(Long programId) {
		// TODO Auto-generated method stub
		return programGroupRepository.findByProgramId(programId);
	}

	@Override
	public ProgramGroup createProgramGroup(ProgramGroup programGroup) {
		// TODO Auto-generated method stub
		return programGroupRepository.save(programGroup);
	}

	@Override
	public void deleteProgramGroup(long programId, long groupId) {
		// TODO Auto-generated method stub
		ProgramGroup programGroup = getProgramGroupById(programId, groupId).get();
		programGroupRepository.delete(programGroup);
	}
	
	private Optional<ProgramGroup> getProgramGroupById(long programId, long groupId) {
		return programGroupRepository.findById(new ProgramGroupPK(programId, groupId));
	}

}
