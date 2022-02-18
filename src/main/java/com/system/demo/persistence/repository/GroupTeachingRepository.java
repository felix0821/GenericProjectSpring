package com.system.demo.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.system.demo.persistence.entity.GroupTeaching;

@Repository
public interface GroupTeachingRepository extends JpaRepository<GroupTeaching,Long>{
	
	@Query(value="SELECT g FROM GroupTeaching g WHERE g.groupId NOT IN (SELECT p.programGroupPK.groupId FROM ProgramGroup p WHERE p.programGroupPK.programId = :programId)")
	public Iterable<GroupTeaching> findByGroupTeachingNotProgramId(@Param(value="programId")Long programId);

}
