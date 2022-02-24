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
	
	@Query(nativeQuery = true, value = "SELECT SUM(f.financial_movement_detail_amount) FROM public.financial_movement_detail f "
			+ "INNER JOIN (SELECT n.financial_movement_id, n.financial_movement_type FROM public.financial_movement n WHERE n.financial_movement_type = :financialMovementType) fm "
			+ "ON f.financial_movement_id = fm.financial_movement_id "
			+ "WHERE f.financial_movement_detail_date BETWEEN :startDate AND :endDate")
	public Double sumAmountTypeByFinancialMovementDetailDateRange(@Param("startDate")Date startDate, @Param("endDate")Date endDate, @Param("financialMovementType")Character financialMovementType);

}
