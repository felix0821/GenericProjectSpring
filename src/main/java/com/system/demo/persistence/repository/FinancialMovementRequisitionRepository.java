package com.system.demo.persistence.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.system.demo.persistence.entity.FinancialMovementRequisition;
import com.system.demo.persistence.entity.FinancialMovementRequisitionPK;

@Repository
public interface FinancialMovementRequisitionRepository extends JpaRepository<FinancialMovementRequisition,FinancialMovementRequisitionPK> {

	public Iterable<FinancialMovementRequisition> findByFinancialMovementDetailId(@Param("financialMovementDetailId")long financialMovementDetailId);
}
