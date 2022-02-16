package com.system.demo.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.system.demo.persistence.entity.RequisitionNotificationRole;
import com.system.demo.persistence.entity.RequisitionNotificationRolePK;

@Repository
public interface RequisitionNotificationRoleRepository extends JpaRepository<RequisitionNotificationRole,RequisitionNotificationRolePK> {

}
