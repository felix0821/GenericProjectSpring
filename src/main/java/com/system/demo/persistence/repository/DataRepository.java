package com.system.demo.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.system.demo.persistence.entity.Data;

@Repository
public interface DataRepository extends JpaRepository<Data,Long> {
	
	@Query(value="SELECT d FROM Data d INNER JOIN RequisitionData r ON d.dataId = r.requisitionDataPK.dataId WHERE r.requisitionDataPK.requisitionId = :requisitionId ORDER BY r.requisitionDataIndex")
	public Iterable<Data> findByRequisitionId(@Param("requisitionId")Long requisitionId);

}
