package com.system.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.system.demo.model.DataDetail;

@Repository
public interface DataDetailRepository extends JpaRepository<DataDetail,Long> {

}
