package com.system.demo.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.system.demo.model.UserRol;
import com.system.demo.model.UserRolPK;
import com.system.demo.repository.UserRolRepository;


@Service
public class UserRolServiceImplements implements UserRolService {
	@Autowired
	UserRolRepository repository;

	@Override
	public UserRol createUserRol(UserRol userRol) throws Exception {
		userRol = repository.save(userRol);
		return userRol;
	}

	@Override
	public void deleteUserRol(Long idUser, long idRole) throws Exception {
		UserRolPK userRolPk = new UserRolPK(idUser,idRole);
		repository.deleteById(userRolPk);
	}

}
