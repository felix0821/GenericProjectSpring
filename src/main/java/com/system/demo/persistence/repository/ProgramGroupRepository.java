package com.system.demo.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.system.demo.persistence.entity.ProgramGroup;
import com.system.demo.persistence.entity.ProgramGroupPK;

@Repository
public interface ProgramGroupRepository extends JpaRepository<ProgramGroup,ProgramGroupPK> {

	Iterable<ProgramGroup> findByProgramId(@Param(value="programId")Long programId);
}
