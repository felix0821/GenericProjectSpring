package com.system.demo.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.system.demo.persistence.entity.ModulusDetail;
import com.system.demo.persistence.entity.ModulusDetailPK;

@Repository
public interface ModulusDetailRepository extends JpaRepository<ModulusDetail,ModulusDetailPK> {

}
