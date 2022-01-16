package com.system.demo.service;

import com.system.demo.model.Access;

public interface AccessService {
	
	public Iterable<Access> getAllAccess();
	
	public Access createAccess(Access access) throws Exception;
	
	public Access getAccessById(long idResource, long idRole) throws Exception;

}
