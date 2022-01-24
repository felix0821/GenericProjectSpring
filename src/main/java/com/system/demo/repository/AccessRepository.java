package com.system.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.system.demo.model.Access;
import com.system.demo.model.AccessPK;

@Repository
public interface AccessRepository extends JpaRepository<Access,AccessPK>{
	public List<Access> findByRoleId(long idRole);
	public List<Access> findByResourceId(long idResource);

}
