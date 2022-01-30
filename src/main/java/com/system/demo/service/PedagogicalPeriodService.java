package com.system.demo.service;

import com.system.demo.persistence.entity.PedagogicalPeriod;

public interface PedagogicalPeriodService {
	//Iteradores
	Iterable<PedagogicalPeriod> getAllPedagogicalPeriods();
	
	public PedagogicalPeriod createPedagogicalPeriod(PedagogicalPeriod pedagogicalPeriod) throws Exception;
	public PedagogicalPeriod updatePedagogicalPeriod(PedagogicalPeriod fromPedagogicalPeriod) throws Exception;
	public void deletePedagogicalPeriod(Long pedagogicalPeriodId) throws Exception;
	
	public PedagogicalPeriod getPedagogicalPeriodById(Long pedagogicalPeriodId) throws Exception;

}
