package com.system.demo.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.system.demo.persistence.entity.UsesRestriction;
import com.system.demo.persistence.entity.UsesRestrictionPK;

@Repository
public interface UsesRestrictionRepository extends JpaRepository<UsesRestriction,UsesRestrictionPK> {
	
	Iterable<UsesRestriction> findByUsesId(Long usesId);

}
