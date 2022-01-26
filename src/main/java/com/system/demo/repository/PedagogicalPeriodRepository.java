package com.system.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.system.demo.model.PedagogicalPeriod;

@Repository
public interface PedagogicalPeriodRepository extends JpaRepository<PedagogicalPeriod,Long> {

}
