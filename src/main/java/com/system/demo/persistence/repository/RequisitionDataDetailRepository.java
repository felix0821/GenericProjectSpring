package com.system.demo.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.system.demo.persistence.entity.RequisitionDataDetail;
import com.system.demo.persistence.entity.RequisitionDataDetailPK;

@Repository
public interface RequisitionDataDetailRepository extends JpaRepository<RequisitionDataDetail,RequisitionDataDetailPK> {
	
	public Iterable<RequisitionDataDetail> findByRequisitionDetailId(@Param(value="requisitionDetailId")Long requisitionDetailId);

}
