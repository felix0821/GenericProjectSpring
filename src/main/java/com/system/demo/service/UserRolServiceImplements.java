package com.system.demo.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.system.demo.model.PersonRol;
import com.system.demo.model.PersonRolPK;
import com.system.demo.repository.UserRolRepository;


@Service
public class UserRolServiceImplements implements UserRolService {
	@Autowired
	UserRolRepository repository;

	@Override
	public PersonRol createUserRol(PersonRol personRol) throws Exception {
		personRol = repository.save(personRol);
		return personRol;
	}

	@Override
	public void deleteUserRol(Long idUser, long idRole) throws Exception {
		PersonRolPK userRolPk = new PersonRolPK(idUser,idRole);
		repository.deleteById(userRolPk);
	}

}
