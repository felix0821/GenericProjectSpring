package com.system.demo.persistence.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.system.demo.persistence.entity.Role;


@Repository
public interface RoleRepository extends CrudRepository<Role, Long>{

	public Optional<Role> findByRoleName(String roleName);
}
