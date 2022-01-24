package com.system.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.system.demo.model.FinancialMovementDetail;

@Repository
public interface FinancialMovementDetailRepository extends JpaRepository<FinancialMovementDetail,Long>{

}
