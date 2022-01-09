package com.system.demo.service;

import com.system.demo.model.Role;

public interface RoleService {

	public Iterable<Role> getAllRoles();

	public Role createRole(Role user) throws Exception;

	public Role getRoleById(Long id) throws Exception;
	
	public Role updateRole(Role user) throws Exception;
	
	public void deleteRole(Long id) throws Exception;
	
}
