package com.system.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.system.demo.model.FinancialMovementDetail;
import com.system.demo.model.FinancialMovementDetailPK;

@Repository
public interface FinancialMovementDetailRepository extends JpaRepository<FinancialMovementDetail,FinancialMovementDetailPK>{

}
