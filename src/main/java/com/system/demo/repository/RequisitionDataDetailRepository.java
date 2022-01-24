package com.system.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.system.demo.model.RequisitionDataDetail;
import com.system.demo.model.RequisitionDataDetailPK;

@Repository
public interface RequisitionDataDetailRepository extends JpaRepository<RequisitionDataDetail,RequisitionDataDetailPK> {

}
