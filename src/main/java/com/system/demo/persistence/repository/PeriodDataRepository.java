package com.system.demo.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.system.demo.persistence.entity.PeriodData;
import com.system.demo.persistence.entity.PeriodDataPK;

@Repository
public interface PeriodDataRepository extends JpaRepository<PeriodData,PeriodDataPK> {

}
