package com.system.demo.service;

import java.util.Optional;

import com.system.demo.persistence.entity.Modulus;

public interface ModulusService {
	
	public Iterable<Modulus> getModulesByProgramId(Long programId);
	public Modulus createModulus(Modulus modulus) throws Exception;
	public Modulus updateModulus(Modulus fromModulus) throws Exception;
	public void deleteModulus(Long modulusId) throws Exception;
	public Optional<Modulus> getModulusById(Long id);
	
	public Optional<Modulus> getModulusByIdentifier(String identifier);

}
