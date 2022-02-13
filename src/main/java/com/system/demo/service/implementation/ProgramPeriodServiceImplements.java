package com.system.demo.service.implementation;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.system.demo.persistence.entity.ProgramPeriod;
import com.system.demo.persistence.entity.ProgramPeriodPK;
import com.system.demo.persistence.repository.ProgramPeriodRepository;
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
	public List<ProgramPeriod> getProgramPeriodByProgramId(long programId) {
		return programPeriodRepository.findByProgramId(programId);
	}

	@Override
	public List<ProgramPeriod> getProgramPeriodByPedagogicalPeriodId(long periodId) {
		return programPeriodRepository.findByPeriodId(periodId);
	}

	@Override
	public Optional<ProgramPeriod> getProgramPeriodById(long programId, long periodId) {
		return programPeriodRepository.findById(new ProgramPeriodPK(programId, periodId));
	}

	@Override
	public long getTotalProgramPeriodByPeriodId(long periodId) {
		return programPeriodRepository.countByPeriodId(periodId);
	}

	@Override
	public void deleteProgramPeriod(long programId, long periodId) {
		ProgramPeriod programPeriod = getProgramPeriodById(programId, periodId).get();
		programPeriodRepository.delete(programPeriod);
	}

}
