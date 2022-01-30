package com.system.demo.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.system.demo.persistence.entity.RequisitionStatusDetail;

@Repository
public interface RequisitionStatusDetailRepository extends JpaRepository<RequisitionStatusDetail,Long> {

}
