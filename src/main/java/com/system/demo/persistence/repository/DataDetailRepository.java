package com.system.demo.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.system.demo.persistence.entity.DataDetail;

@Repository
public interface DataDetailRepository extends JpaRepository<DataDetail,Long> {
	
	@Query(value="SELECT d FROM DataDetail d WHERE d.dataId.dataId = :dataId")
	public Iterable<DataDetail> findByDataId(@Param(value="dataId")Long dataId);

}
