package com.system.demo.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.system.demo.model.Resource;
import com.system.demo.repository.ResourceRepository;

@Service
@Transactional
public class ResourceServiceImplements implements ResourceService{
	
	@Autowired
	ResourceRepository resourceRepository;

	@Override
	public Iterable<Resource> getAllResources() {
		return resourceRepository.findAll();
	}

	@Override
	public Resource createResource(Resource resource) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Resource getResourceById(Long id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Resource> getResourceByName(String urlName) {
		return resourceRepository.findByUrlName(urlName);
	}

}
