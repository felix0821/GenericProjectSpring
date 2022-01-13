 package com.system.demo.service;

import com.system.demo.model.PersonRol;

public interface PersonRolService {
	public PersonRol createPersonRol(PersonRol personRol) throws Exception;
	public void deletePersonRol(Long idPerson, long idRole) throws Exception;
}
