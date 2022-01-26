package com.system.demo.service;

import java.util.Optional;

import com.system.demo.model.Program;

public interface ProgramService {
	
	Iterable<Program> getAllPrograms();
	public Program createProgram(Program program) throws Exception;
	public Program updateProgram(Program fromProgram) throws Exception;
	public void deleteProgram(Long programId) throws Exception;
	
	public Program getProgramById(Long programId) throws Exception;
	
}
