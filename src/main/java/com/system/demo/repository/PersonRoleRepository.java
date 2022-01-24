package com.system.demo.repository;

import org.springframework.stereotype.Repository;

import com.system.demo.model.PersonRole;
import com.system.demo.model.PersonRolePK;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface PersonRoleRepository extends JpaRepository<PersonRole,PersonRolePK>{
	public List<PersonRole> findByPersonId(long personId);
	public List<PersonRole> findByRoleId(long roleId);

}
