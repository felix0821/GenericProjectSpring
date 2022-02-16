package com.system.demo.service;

import com.system.demo.persistence.entity.Modulus;

public interface ModulusService {
	
	public Iterable<Modulus> getModulesByProgramId(Long programId);
	public Modulus createModulus(Modulus modulus) throws Exception;
	public Modulus updateModulus(Modulus fromModulus) throws Exception;
	public void deleteModulus(Long modulusId) throws Exception;

}
