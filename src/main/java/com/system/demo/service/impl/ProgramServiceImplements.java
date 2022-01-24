package com.system.demo.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.system.demo.model.Program;
import com.system.demo.repository.ProgramRepository;
import com.system.demo.service.ProgramService;

@Service
@Transactional
public class ProgramServiceImplements implements ProgramService{

	@Autowired
	ProgramRepository programRepository;
	
	@Override
	public Iterable<Program> getAllPrograms() {
		return null;
	}

	@Override
	public Program createProgram(Program program) throws Exception {
		return null;
	}

}
