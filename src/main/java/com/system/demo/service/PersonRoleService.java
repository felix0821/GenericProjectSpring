 package com.system.demo.service;

import com.system.demo.model.PersonRole;

public interface PersonRoleService {
	public PersonRole createPersonRol(PersonRole personRol) throws Exception;
	public void deletePersonRol(Long idPerson, long idRole) throws Exception;
}
