package com.system.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.system.demo.model.ModulusSchedule;
import com.system.demo.model.ModulusSchedulePK;

@Repository
public interface ModulusScheduleRepository extends JpaRepository<ModulusSchedule,ModulusSchedulePK> {

}
