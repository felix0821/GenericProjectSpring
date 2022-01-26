package com.system.demo.service;

import com.system.demo.model.PedagogicalPeriod;

public interface PedagogicalPeriodService {
	//Iteradores
	Iterable<PedagogicalPeriod> getAllPedagogicalPeriods();
	
	public PedagogicalPeriod createPedagogicalPeriod(PedagogicalPeriod pedagogicalPeriod) throws Exception;

}
