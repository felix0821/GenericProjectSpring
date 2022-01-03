package com.system.demo.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.system.demo.model.Role;


@Repository
public interface RoleRepository extends CrudRepository<Role, Long>{

	public Role findByNameRole(String nameRole);
}
