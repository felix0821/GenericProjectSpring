package com.system.demo.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.system.demo.persistence.entity.ProgramData;
import com.system.demo.persistence.entity.ProgramDataPK;

@Repository
public interface ProgramDataRepository extends JpaRepository<ProgramData,ProgramDataPK> {

}
