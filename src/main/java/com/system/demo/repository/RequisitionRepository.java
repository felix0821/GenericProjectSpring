package com.system.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.system.demo.model.Requisition;

@Repository
public interface RequisitionRepository extends JpaRepository<Requisition,Long>{

}
