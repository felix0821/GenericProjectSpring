package com.system.demo.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.system.demo.model.Access;
import com.system.demo.model.AccessPK;
import com.system.demo.repository.AccessRepository;
import com.system.demo.service.AccessService;

@Service
@Transactional
public class AccessServiceImplements implements AccessService{
	
	@Autowired
	AccessRepository accessRepository;

	@Override
	public Iterable<Access> getAllAccess() {
		return accessRepository.findAll();
	}

	@Override
	public Access createAccess(Access access) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Access getAccessById(long idRole, long idResource) throws Exception {
		AccessPK accessPK = new AccessPK(idRole, idResource);
		return accessRepository.getById(accessPK);
	}

}
