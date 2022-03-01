package com.system.demo.service.implementation;

import java.util.Date;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.system.demo.persistence.entity.Period;
import com.system.demo.persistence.repository.PeriodRepository;
import com.system.demo.service.PeriodService;

@Service
@Transactional
public class PeriodServiceImplements implements PeriodService{
	
	@Autowired
	PeriodRepository periodRepository;

	@Override
	public Iterable<Period> getAllPedagogicalPeriods() {
		// TODO Auto-generated method stub
		return periodRepository.findAll();
	}

	@Override
	public Period createPeriod(Period period) throws Exception {
		// TODO Auto-generated method stub
		return periodRepository.save(period);
	}

	@Override
	public Period updatePeriod(Period fromPeriod) throws Exception {
		// TODO Auto-generated method stub
		Period toPedagogicalPeriod = getPeriodById(fromPeriod.getPeriodId());
		mapPedagogicalPeriod(fromPeriod, toPedagogicalPeriod);
		return periodRepository.save(toPedagogicalPeriod);
	}

	@Override
	public void deletePeriod(Long periodId) throws Exception {
		// TODO Auto-generated method stub
		Period period = getPeriodById(periodId);
		periodRepository.delete(period);
	}

	@Override
	public Period getPeriodById(Long periodId) throws Exception {
		// TODO Auto-generated method stub
		return periodRepository.findById(periodId).orElseThrow();
	}
	
	protected void mapPedagogicalPeriod(Period from, Period to) {
		to.setPeriodName(from.getPeriodName());
		to.setPeriodDescription(from.getPeriodDescription());
		to.setPeriodYear(from.getPeriodYear());
		to.setPeriodState(from.getPeriodState());
	}

	@Override
	public boolean existsPeriodById(Long periodId) {
		// TODO Auto-generated method stub
		return periodRepository.existsById(periodId);
	}

	@Override
	public Optional<Period> getPeriodByIdentifier(String periodIdentifier) {
		// TODO Auto-generated method stub
		return periodRepository.findByPeriodIdentifier(periodIdentifier);
	}

	@Override
	public Iterable<Period> getAllPeriodByProgramPeriodEnrollmentAvailable(Date currentDate) {
		// TODO Auto-generated method stub
		return periodRepository.findDistintByJoinProgramPeriodEnrollmentAvailable(currentDate);
	}

}
