package com.system.demo.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.system.demo.persistence.entity.Program;

@Repository
public interface ProgramRepository extends JpaRepository<Program,Long> {
	
	public List<Program> findByProgramState(Character programState);

}
