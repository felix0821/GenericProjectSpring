package com.system.demo.service;

import java.util.Optional;

import com.system.demo.persistence.entity.Resource;

public interface ResourceService {
	
	public Iterable<Resource> getAllResources();
	
	public Resource createResource(Resource resource) throws Exception;
	
	public Resource getResourceById(Long id) throws Exception;
	
	public Optional<Resource> getResourceByName(String name);

}
