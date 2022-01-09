package com.system.demo.service;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.system.demo.model.PersonRol;
import com.system.demo.model.PersonRolPK;
import com.system.demo.repository.UserRolRepository;


@Service
@Transactional
public class UserRolServiceImplements implements UserRolService {
	@Autowired
	UserRolRepository repository;

	@Override
	public PersonRol createPersonRol(PersonRol personRol) throws Exception {
		personRol = repository.save(personRol);
		return personRol;
	}

	@Override
	public void deletePersonRol(Long idUser, long idRole) throws Exception {
		PersonRolPK personRolPk = new PersonRolPK(idUser,idRole);
		repository.deleteById(personRolPk);
	}

}
