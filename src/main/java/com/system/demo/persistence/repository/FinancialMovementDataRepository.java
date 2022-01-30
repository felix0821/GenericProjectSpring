package com.system.demo.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.system.demo.persistence.entity.FinancialMovementData;
import com.system.demo.persistence.entity.FinancialMovementDataPK;

@Repository
public interface FinancialMovementDataRepository extends JpaRepository<FinancialMovementData,FinancialMovementDataPK> {

}
