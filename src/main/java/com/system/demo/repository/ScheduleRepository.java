package com.system.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.system.demo.model.Schedule;
import com.system.demo.model.SchedulePK;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule,SchedulePK> {

}
