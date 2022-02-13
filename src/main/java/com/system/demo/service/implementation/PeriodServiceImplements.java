package com.system.demo.service.implementation;

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
		return periodRepository.findAll();
	}

	@Override
	public Period createPeriod(Period period) throws Exception {
		return periodRepository.save(period);
	}

	@Override
	public Period updatePeriod(Period fromPeriod) throws Exception {
		Period toPedagogicalPeriod = getPeriodById(fromPeriod.getPeriodId());
		mapPedagogicalPeriod(fromPeriod, toPedagogicalPeriod);
		return periodRepository.save(toPedagogicalPeriod);
	}

	@Override
	public void deletePeriod(Long periodId) throws Exception {
		Period period = getPeriodById(periodId);
		periodRepository.delete(period);
	}

	@Override
	public Period getPeriodById(Long periodId) throws Exception {
		return periodRepository.findById(periodId).orElseThrow();
	}
	
	protected void mapPedagogicalPeriod(Period from, Period to) {
		to.setPeriodName(from.getPeriodName());
		to.setPeriodDescription(from.getPeriodDescription());
		to.setPeriodYear(from.getPeriodYear());
		to.setPeriodModality(from.getPeriodModality());
		to.setPeriodState(from.getPeriodState());
	}

	@Override
	public boolean existsPeriodById(Long periodId) {
		return periodRepository.existsById(periodId);
	}

	@Override
	public Optional<Period> getPeriodByIdentifier(String periodIdentifier) {
		return periodRepository.findByPeriodIdentifier(periodIdentifier);
	}

}
