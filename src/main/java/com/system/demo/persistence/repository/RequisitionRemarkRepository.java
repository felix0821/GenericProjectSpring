package com.system.demo.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.system.demo.persistence.entity.RequisitionRemark;

@Repository
public interface RequisitionRemarkRepository extends JpaRepository<RequisitionRemark,Long> {
	
	@Query(value="SELECT r FROM RequisitionRemark r WHERE r.requisitionDetailId.requisitionDetailId = :requisitionDetailId")
	public Iterable<RequisitionRemark> findByRequisitionDetailId(@Param(value="requisitionDetailId")Long requisitionDetailId);

}
