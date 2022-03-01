package com.system.demo.persistence.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.system.demo.persistence.entity.FinancialRequisition;
import com.system.demo.persistence.entity.FinancialRequisitionPK;

@Repository
public interface FinancialRequisitionRepository extends JpaRepository<FinancialRequisition,FinancialRequisitionPK> {

	public Iterable<FinancialRequisition> findByFinancialMovementDetailId(@Param("financialMovementDetailId")long financialMovementDetailId);
}
