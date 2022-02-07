package com.system.demo.service.implementation;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.system.demo.persistence.entity.Program;
import com.system.demo.persistence.repository.ProgramRepository;
import com.system.demo.service.ProgramService;

@Service
@Transactional
public class ProgramServiceImplements implements ProgramService{

	@Autowired
	ProgramRepository programRepository;
	
	@Override
	public Iterable<Program> getAllPrograms() {
		return programRepository.findAll();
	}

	@Override
	public Program createProgram(Program program) throws Exception {
		return programRepository.save(program);
	}
	
	@Override
	public Program updateProgram(Program fromProgram) throws Exception {
		Program toProgram = getProgramById(fromProgram.getProgramId());
		mapProgram(fromProgram, toProgram);
		return programRepository.save(toProgram);
	}

	@Override
	public void deleteProgram(Long programId) throws Exception {
		Program program = getProgramById(programId);
		programRepository.delete(program);
	}
	
	@Override
	public Program getProgramById(Long id) throws Exception {
		return programRepository.findById(id).orElseThrow();
	}
	
	@Override
	public List<Program> getProgramByState(Character programState) {
		return programRepository.findByProgramState(programState);
	}

	//----------------------------------Methods Complements----------------------------------//
	
	protected void mapProgram(Program from, Program to) {
		to.setProgramIndex(from.getProgramIndex());
		to.setProgramName(from.getProgramName());
		to.setProgramAcronym(from.getProgramAcronym());
		to.setProgramDescription(from.getProgramDescription());
		to.setProgramRequirement(from.getProgramRequirement());
		to.setProgramCurriculum(from.getProgramCurriculum());
		to.setProgramImage(from.getProgramImage());
		to.setProgramArea(from.getProgramArea());
		to.setProgramState(from.getProgramState());
	}

	@Override
	public Optional<Program> getProgramByIdentifier(String identifier) {
		return programRepository.findByProgramIdentifier(identifier);
	}

	

	

}
