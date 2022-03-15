package com.system.demo.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.system.demo.persistence.entity.Uses;

@Repository
public interface UsesRepository extends JpaRepository<Uses,Long> {

	@Query(value="SELECT u FROM Uses u INNER JOIN RequisitionUses ru ON ru.requisitionUsesPK.usesId = u.usesId INNER JOIN Requisition r ON r.requisitionId = ru.requisitionUsesPK.requisitionId INNER JOIN RequisitionDetail rd ON rd.requisitionId.requisitionId = r.requisitionId WHERE rd.requisitionDetailId = :requisitionDetailId")
	public Iterable<Uses> findByRequisitionDetailId(@Param(value="requisitionDetailId")Long requisitionDetailId);
}
