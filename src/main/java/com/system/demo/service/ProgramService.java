package com.system.demo.service;

import java.util.List;
import java.util.Optional;

import com.system.demo.persistence.entity.Program;

public interface ProgramService {
	
	Iterable<Program> getAllPrograms();
	public Program createProgram(Program program) throws Exception;
	public Program updateProgram(Program fromProgram) throws Exception;
	public void deleteProgram(Long programId) throws Exception;
	
	public Optional<Program> getProgramByIdentifier(String identifier);
	public Program getProgramById(Long programId) throws Exception;
	public List<Program> getProgramByState(Character programState);
}
