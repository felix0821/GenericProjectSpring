package com.system.demo.persistence.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.system.demo.persistence.entity.Resource;

@Repository
public interface ResourceRepository extends JpaRepository<Resource,Long>{
	public Optional<Resource> findByResourceUrl(String urlName);

}
