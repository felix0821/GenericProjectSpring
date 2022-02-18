package com.system.demo.service;

import com.system.demo.persistence.entity.ProgramGroup;

public interface ProgramGroupService {
	
	public Iterable<ProgramGroup> getProgramGroupByProgramId(Long programId);
	public ProgramGroup createProgramGroup(ProgramGroup programGroup);
	public void deleteProgramGroup(long programId, long groupId);
	
}
