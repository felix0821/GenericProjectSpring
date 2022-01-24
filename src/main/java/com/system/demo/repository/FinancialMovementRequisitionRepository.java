package com.system.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.system.demo.model.FinancialMovementRequisition;
import com.system.demo.model.FinancialMovementRequisitionPK;

@Repository
public interface FinancialMovementRequisitionRepository extends JpaRepository<FinancialMovementRequisition,FinancialMovementRequisitionPK> {

}
