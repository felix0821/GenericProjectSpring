package com.system.demo.service;

import java.util.Optional;

import com.system.demo.model.Program;

public interface ProgramService {
	
	Iterable<Program> getAllPrograms();
	
	public Program createProgram(Program program) throws Exception;
	public Program getProgramById(Long id) throws Exception;

}
