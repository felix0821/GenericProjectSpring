package com.system.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.system.demo.model.RequisitionStatus;

@Repository
public interface RequisitionStatusRepository extends JpaRepository<RequisitionStatus,Long>{

}
