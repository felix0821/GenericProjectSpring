package com.system.demo.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.system.demo.persistence.entity.RequisitionData;
import com.system.demo.persistence.entity.RequisitionDataPK;

@Repository
public interface RequisitionDataRepository extends JpaRepository<RequisitionData,RequisitionDataPK> {

}
