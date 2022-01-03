package com.system.demo.service;

import com.system.demo.model.UserRol;

public interface UserRolService {
	public UserRol createUserRol(UserRol userRol) throws Exception;
	public void deleteUserRol(Long idUser, long idRole) throws Exception;
	
}
