package com.system.demo.service;

import com.system.demo.model.PersonRol;

public interface UserRolService {
	public PersonRol createUserRol(PersonRol personRol) throws Exception;
	public void deleteUserRol(Long idUser, long idRole) throws Exception;
	
}
