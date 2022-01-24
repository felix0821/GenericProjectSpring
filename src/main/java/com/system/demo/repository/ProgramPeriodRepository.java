package com.system.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.system.demo.model.ProgramPeriod;

@Repository
public interface ProgramPeriodRepository extends JpaRepository<ProgramPeriod,Long> {

}
