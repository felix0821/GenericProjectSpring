package com.system.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.system.demo.model.DataEntry;

@Repository
public interface DataEntryRepository extends JpaRepository<DataEntry,Long> {

}
