package com.system.demo.service.implementation;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.system.demo.persistence.entity.PedagogicalPeriod;
import com.system.demo.persistence.repository.PedagogicalPeriodRepository;
import com.system.demo.service.PedagogicalPeriodService;

@Service
@Transactional
public class PedagogicalPeriodServiceImplements implements PedagogicalPeriodService{
	
	@Autowired
	PedagogicalPeriodRepository pedagogicalPeriodRepository;

	@Override
	public Iterable<PedagogicalPeriod> getAllPedagogicalPeriods() {
		return pedagogicalPeriodRepository.findAll();
	}

	@Override
	public PedagogicalPeriod createPedagogicalPeriod(PedagogicalPeriod pedagogicalPeriod) throws Exception {
		return pedagogicalPeriodRepository.save(pedagogicalPeriod);
	}

	@Override
	public PedagogicalPeriod updatePedagogicalPeriod(PedagogicalPeriod fromPedagogicalPeriod) throws Exception {
		PedagogicalPeriod toPedagogicalPeriod = getPedagogicalPeriodById(fromPedagogicalPeriod.getPedagogicalPeriodId());
		mapPedagogicalPeriod(fromPedagogicalPeriod, toPedagogicalPeriod);
		return pedagogicalPeriodRepository.save(toPedagogicalPeriod);
	}

	@Override
	public void deletePedagogicalPeriod(Long pedagogicalPeriodId) throws Exception {
		PedagogicalPeriod pedagogicalPeriod = getPedagogicalPeriodById(pedagogicalPeriodId);
		pedagogicalPeriodRepository.delete(pedagogicalPeriod);
	}

	@Override
	public PedagogicalPeriod getPedagogicalPeriodById(Long pedagogicalPeriodId) throws Exception {
		return pedagogicalPeriodRepository.findById(pedagogicalPeriodId).orElseThrow();
	}
	
	protected void mapPedagogicalPeriod(PedagogicalPeriod from, PedagogicalPeriod to) {
		to.setPedagogicalPeriodName(from.getPedagogicalPeriodName());
		to.setPedagogicalPeriodDescription(from.getPedagogicalPeriodDescription());
		to.setPedagogicalPeriodYear(from.getPedagogicalPeriodYear());
		to.setPedagogicalPeriodModality(from.getPedagogicalPeriodModality());
		to.setPedagogicalPeriodState(from.getPedagogicalPeriodState());
	}

}
