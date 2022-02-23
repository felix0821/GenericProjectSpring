package com.system.demo.persistence.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.system.demo.persistence.entity.FinancialMovementDetail;

@Repository
public interface FinancialMovementDetailRepository extends JpaRepository<FinancialMovementDetail,Long>{
	
	@Query(value = "SELECT f FROM FinancialMovementDetail f WHERE f.financialMovementDetailDate BETWEEN :startDate AND :endDate ORDER BY f.financialMovementDetailDate DESC")
	public Iterable<FinancialMovementDetail> findByFinancialMovementDetailDateRange(@Param("startDate")Date startDate, @Param("endDate")Date endDate);
	
	@Query(value = "SELECT SUM(f.financialMovementDetailAmount) FROM FinancialMovementDetail f "
			+ "INNER JOIN (SELECT fm.financialMovementId, fm.financialMovementType FROM FinancialMovement fm WHERE fm.financialMovementType = :financialMovementType) fmt ON f.financialMovementId.financialMovementId = fmt.financialMovementId "
			+ "WHERE f.financialMovementDetailDate BETWEEN :startDate AND :endDate", nativeQuery = true)
	public Double sumAmountTypeByFinancialMovementDetailDateRange(@Param("startDate")Date startDate, @Param("endDate")Date endDate, @Param("financialMovementType")Character financialMovementType);

}
