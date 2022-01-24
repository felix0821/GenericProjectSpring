package com.system.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.system.demo.model.RequisitionData;
import com.system.demo.model.RequisitionDataPK;

@Repository
public interface RequisitionDataRepository extends JpaRepository<RequisitionData,RequisitionDataPK> {

}
