package com.system.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.system.demo.model.RequisitionStatusDetail;

@Repository
public interface RequisitionStatusDetailRepository extends JpaRepository<RequisitionStatusDetail,Long> {

}