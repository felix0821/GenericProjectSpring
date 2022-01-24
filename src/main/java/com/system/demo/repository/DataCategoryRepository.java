package com.system.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.system.demo.model.DataCategory;

@Repository
public interface DataCategoryRepository extends JpaRepository<DataCategory,Long> {

}
