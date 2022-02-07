package com.system.demo.service;

import java.util.Optional;

import com.system.demo.persistence.entity.PedagogicalPeriod;

public interface PedagogicalPeriodService {
	//Iteradores
	Iterable<PedagogicalPeriod> getAllPedagogicalPeriods();
	//Consultas CRUD
	public PedagogicalPeriod createPedagogicalPeriod(PedagogicalPeriod pedagogicalPeriod) throws Exception;
	public PedagogicalPeriod updatePedagogicalPeriod(PedagogicalPeriod fromPedagogicalPeriod) throws Exception;
	public void deletePedagogicalPeriod(Long pedagogicalPeriodId) throws Exception;
	//Consultas Operaciones
	public boolean existsPedagogicalPeriodById(Long pedagogicalPeriodId);
	public Optional<PedagogicalPeriod> getPedagogicalPeriodByIdentifier(String pedagogicalPeriodIdentifier);
	public PedagogicalPeriod getPedagogicalPeriodById(Long pedagogicalPeriodId) throws Exception;

}
