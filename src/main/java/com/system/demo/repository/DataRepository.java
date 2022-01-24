package com.system.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.system.demo.model.Data;

@Repository
public interface DataRepository extends JpaRepository<Data,Long> {

}
