package com.system.demo.persistence.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.system.demo.persistence.entity.Period;

@Repository
public interface PeriodRepository extends JpaRepository<Period,Long> {
	
	public Optional<Period> findByPedagogicalPeriodIdentifier(String pedagogicalPeriodIdentifier);
	
}
