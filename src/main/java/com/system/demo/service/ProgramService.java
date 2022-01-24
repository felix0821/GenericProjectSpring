package com.system.demo.service;

import com.system.demo.model.Program;

public interface ProgramService {
	
	Iterable<Program> getAllPrograms();
	
	public Program createProgram(Program program) throws Exception;

}
