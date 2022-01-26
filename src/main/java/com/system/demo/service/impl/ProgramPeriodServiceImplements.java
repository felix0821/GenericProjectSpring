package com.system.demo.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.system.demo.model.ProgramPeriod;
import com.system.demo.repository.ProgramPeriodRepository;
import com.system.demo.service.ProgramPeriodService;

@Service
@Transactional
public class ProgramPeriodServiceImplements implements ProgramPeriodService {
	
	@Autowired
	ProgramPeriodRepository programPeriodRepository;

	@Override
	public Iterable<ProgramPeriod> getAllProgramPeriods() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProgramPeriod createProgramPeriod(ProgramPeriod programPeriod) throws Exception {
		return programPeriodRepository.save(programPeriod);
	}

	@Override
	public List<ProgramPeriod> getProgramPeriodByProgramId(Long programId) {
		return programPeriodRepository.findByProgramId(programId);
	}

}
