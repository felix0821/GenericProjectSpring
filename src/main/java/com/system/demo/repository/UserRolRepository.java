package com.system.demo.repository;

import org.springframework.stereotype.Repository;

import com.system.demo.model.PersonRol;
import com.system.demo.model.PersonRolPK;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface UserRolRepository extends JpaRepository<PersonRol,PersonRolPK>{
	public List<PersonRol> findByIdPerson(long idPerson);
	public List<PersonRol> findByIdRole(long idRole);

}
