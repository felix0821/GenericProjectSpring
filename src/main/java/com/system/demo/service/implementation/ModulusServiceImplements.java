package com.system.demo.service.implementation;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.system.demo.persistence.entity.Modulus;
import com.system.demo.persistence.repository.ModulusRepository;
import com.system.demo.service.ModulusService;

@Service
@Transactional
public class ModulusServiceImplements implements ModulusService{
	
	@Autowired
	ModulusRepository modulusRepository;

	@Override
	public Iterable<Modulus> getModulesByProgramId(Long programId) {
		return modulusRepository.findByProgramId(programId);
	}

	@Override
	public Modulus createModulus(Modulus modulus) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Modulus updateModulus(Modulus fromModulus) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteModulus(Long modulusId) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
