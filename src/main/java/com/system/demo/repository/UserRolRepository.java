package com.system.demo.repository;

import org.springframework.stereotype.Repository;

import com.system.demo.model.UserRol;
import com.system.demo.model.UserRolPK;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface UserRolRepository extends JpaRepository<UserRol,UserRolPK>{
	public List<UserRol> findByIdUser(long idUser);
	public List<UserRol> findByIdRole(long idRole);

}
