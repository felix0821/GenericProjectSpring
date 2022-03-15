package com.system.demo.persistence.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.system.demo.persistence.entity.Role;

/**
 * @apiNote Requires in model: JsonIgnore in multiple relations
 */

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{
	
	public Optional<Role> findByRoleName(@Param(value="roleName")String roleName);
	
	public Iterable<Role> findByRoleType(@Param(value="roleType")Character roleType);
	
	@Query(value="SELECT r FROM Role r WHERE r.roleId NOT IN (SELECT p.personRolePK.roleId FROM PersonRole p WHERE p.personRolePK.personId = :personId)")
	public Iterable<Role> findByRoleNotPersonId(@Param(value="personId")Long personId);
}
