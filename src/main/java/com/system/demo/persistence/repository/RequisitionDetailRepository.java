package com.system.demo.persistence.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.system.demo.persistence.entity.RequisitionDetail;

public interface RequisitionDetailRepository extends JpaRepository<RequisitionDetail,Long>{
	
	@Query(value="SELECT r FROM RequisitionDetail r WHERE r.personId.personId = :personId")
	public Iterable<RequisitionDetail> findByPersonId(@Param(value="personId")Long personId);
	
	@Query(value="SELECT DISTINCT rd FROM RequisitionDetail rd INNER JOIN Requisition r ON r.requisitionId = rd.requisitionId.requisitionId INNER JOIN RequisitionNotificationRole rn ON rn.requisitionNotificationRolePK.requisitionId = r.requisitionId INNER JOIN PersonRole p ON p.personRolePK.roleId = rn.requisitionNotificationRolePK.roleId WHERE p.personRolePK.personId = :personId AND rd.requisitionDetailChecking = false")
	public Iterable<RequisitionDetail> findByPersonIdAndNotChecking(@Param(value="personId")Long personId);
	
	@Query(value="SELECT r FROM RequisitionDetail r WHERE r.requisitionDetailDate BETWEEN :startDate AND :endDate ORDER BY r.requisitionDetailDate ASC")
	public Iterable<RequisitionDetail> findByRequisitionDetailDateRange(@Param("startDate")Date startDate, @Param("endDate")Date endDate);
	
	@Modifying
	@Query(value="UPDATE RequisitionDetail r SET r.requisitionDetailChecking = true WHERE r.requisitionDetailId = :requisitionDetailId")
	public void checkingByRequisitionDetailId(@Param(value="requisitionDetailId")Long requisitionDetailId);
	
}
