package com.system.demo.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.system.demo.persistence.entity.RequisitionDetail;

public interface RequisitionDetailRepository extends JpaRepository<RequisitionDetail,Long>{
	
	@Query(value="SELECT r FROM RequisitionDetail r WHERE r.requisitionId.requisitionId = :requisitionId AND r.requisitionDetailChecking = false")
	public Iterable<RequisitionDetail> findByRequisitionIdAndNotChecking(@Param(value="requisitionId")Long requisitionId);
	
	@Modifying
	@Query(value="UPDATE RequisitionDetail r SET r.requisitionDetailChecking = true WHERE r.requisitionDetailId = :requisitionDetailId")
	public void checkingByRequisitionDetailId(@Param(value="requisitionDetailId")Long requisitionDetailId);

}
