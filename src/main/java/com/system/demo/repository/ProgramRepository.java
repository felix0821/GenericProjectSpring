package com.system.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.system.demo.model.Program;

@Repository
public interface ProgramRepository extends JpaRepository<Program,Long> {

}
