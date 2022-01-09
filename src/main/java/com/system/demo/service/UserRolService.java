package com.system.demo.service;

import com.system.demo.model.PersonRol;

public interface UserRolService {
	public PersonRol createPersonRol(PersonRol personRol) throws Exception;
	public void deletePersonRol(Long idUser, long idRole) throws Exception;
	
}
