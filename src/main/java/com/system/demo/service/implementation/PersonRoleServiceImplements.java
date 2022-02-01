package com.system.demo.service.implementation;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.system.demo.persistence.entity.PersonRole;
import com.system.demo.persistence.entity.PersonRolePK;
import com.system.demo.persistence.repository.PersonRoleRepository;
import com.system.demo.service.PersonRoleService;


@Service
@Transactional
public class PersonRoleServiceImplements implements PersonRoleService {
	@Autowired
	PersonRoleRepository repository;

	@Override
	public PersonRole createPersonRol(PersonRole personRole) throws Exception {
		personRole = repository.save(personRole);
		return personRole;
	}

	@Override
	public void deletePersonRol(long personId, long roleId){
		//PersonRolePK personRolPk = new PersonRolePK(personId, roleId);
		//PersonRole personRole = repository.findById(personRolPk).orElseThrow();
		//repository.delete(personRole);
		repository.deletePersonRole(personId, roleId);
	}

	@Override
	public Iterable<PersonRole> getPersonRoleByPersonId(long personId) {
		return repository.findByPersonId(personId);
	}

}
