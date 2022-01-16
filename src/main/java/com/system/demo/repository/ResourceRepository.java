package com.system.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.system.demo.model.Resource;

@Repository
public interface ResourceRepository extends JpaRepository<Resource,Long>{
	public Optional<Resource> findByUrlName(String urlName);

}
