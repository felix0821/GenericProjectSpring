package com.system.demo.persistence.repository;

import org.springframework.stereotype.Repository;

import com.system.demo.persistence.entity.PersonRole;
import com.system.demo.persistence.entity.PersonRolePK;


import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface PersonRoleRepository extends JpaRepository<PersonRole,PersonRolePK>{
	public Iterable<PersonRole> findByPersonId(long personId);
	public Iterable<PersonRole> findByRoleId(long roleId);
	
}
