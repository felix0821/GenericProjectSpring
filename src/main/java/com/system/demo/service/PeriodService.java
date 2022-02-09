package com.system.demo.service;

import java.util.Optional;

import com.system.demo.persistence.entity.Period;

public interface PeriodService {
	//Iteradores
	Iterable<Period> getAllPedagogicalPeriods();
	//Consultas CRUD
	public Period createPeriod(Period period) throws Exception;
	public Period updatePeriod(Period fromPeriod) throws Exception;
	public void deletePeriod(Long periodId) throws Exception;
	//Consultas Operaciones
	public boolean existsPeriodById(Long periodId);
	public Optional<Period> getPeriodByIdentifier(String periodIdentifier);
	public Period getPeriodById(Long periodId) throws Exception;

}
