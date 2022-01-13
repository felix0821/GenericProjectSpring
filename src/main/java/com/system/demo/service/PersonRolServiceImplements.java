package com.system.demo.service;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.system.demo.model.PersonRol;
import com.system.demo.model.PersonRolPK;
import com.system.demo.repository.PersonRolRepository;


@Service
@Transactional
public class PersonRolServiceImplements implements PersonRolService {
	@Autowired
	PersonRolRepository repository;

	@Override
	public PersonRol createPersonRol(PersonRol personRol) throws Exception {
		personRol = repository.save(personRol);
		return personRol;
	}

	@Override
	public void deletePersonRol(Long idPerson, long idRole) throws Exception {
		PersonRolPK personRolPk = new PersonRolPK(idPerson,idRole);
		repository.deleteById(personRolPk);
	}

}
