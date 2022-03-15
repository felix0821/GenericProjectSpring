package com.system.demo.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.system.demo.persistence.entity.RequisitionUses;
import com.system.demo.persistence.entity.RequisitionUsesPK;

@Repository
public interface RequisitionUsesRepository extends JpaRepository<RequisitionUses,RequisitionUsesPK> {
	
}
