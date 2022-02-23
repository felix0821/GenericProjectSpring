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
	//, nativeQuery = true
	@Query(value = "SELECT SUM(f.financial_Movement_Detail_Amount) FROM Financial_Movement_Detail f "
			+ "INNER JOIN (SELECT m.financial_MovementId, m.financial_Movement_Type FROM Financial_Movement m WHERE m.financialMovementType = :financialMovementType) fm ON f.financial_Movement_Id = fm.financial_Movement_Id "
			+ "WHERE f.financial_Movement_Detail_Date BETWEEN :startDate AND :endDate", nativeQuery = true)
	public Double sumAmountTypeByFinancialMovementDetailDateRange(@Param("startDate")Date startDate, @Param("endDate")Date endDate, @Param("financialMovementType")Character financialMovementType);

}
