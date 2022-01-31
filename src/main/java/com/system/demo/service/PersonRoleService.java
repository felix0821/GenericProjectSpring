 package com.system.demo.service;

import com.system.demo.persistence.entity.PersonRole;

public interface PersonRoleService {
	public PersonRole createPersonRol(PersonRole personRol) throws Exception;
	public void deletePersonRol(long personId, long roleId) throws Exception;
	public Iterable<PersonRole> getPersonRoleByPersonId(long personId);
}
