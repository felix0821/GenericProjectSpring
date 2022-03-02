package com.system.demo.persistence.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.system.demo.persistence.entity.Data;

@Repository
public interface DataRepository extends JpaRepository<Data,Long> {
	
	@Query(value="SELECT d FROM Data d INNER JOIN RequisitionData r ON d.dataId = r.requisitionDataPK.dataId WHERE r.requisitionDataPK.requisitionId = :requisitionId ORDER BY r.requisitionDataIndex")
	public Iterable<Data> findByRequisitionId(@Param("requisitionId")Long requisitionId);
	
	@Query(value="SELECT d FROM Data d INNER JOIN ProgramData p ON d.dataId = p.programDataPK.dataId WHERE p.programDataPK.programId = :programId AND d.dataReferenceId.dataReferenceId = :dataReferenceId")
	public Optional<Data> findByProgramIdAndReferenceId(@Param("programId")Long programId, @Param("dataReferenceId")Long dataReferenceId);
	
	@Query(value="SELECT d FROM Data d INNER JOIN PeriodData p ON d.dataId = p.periodDataPK.dataId WHERE p.periodDataPK.periodId = :periodId AND d.dataReferenceId.dataReferenceId = :dataReferenceId")
	public Optional<Data> findByPeriodIdAndReferenceId(@Param("periodId")Long periodId, @Param("dataReferenceId")Long dataReferenceId);
	
	@Query(value="SELECT d FROM Data d WHERE d.dataReferenceId.dataReferenceId = :dataReferenceId")
	public Optional<Data> findByReferenceId(@Param("dataReferenceId")Long dataReferenceId);

}
