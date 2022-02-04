/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.system.demo.persistence.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Felix
 */
@Embeddable
public class RequisitionNotificationRolePK implements Serializable {

    @Basic(optional = false)
    @Column(name = "requisition_id", nullable = false)
    private long requisitionId;
    @Basic(optional = false)
    @Column(name = "role_id", nullable = false)
    private long roleId;

    public RequisitionNotificationRolePK() {
    }

    public RequisitionNotificationRolePK(long requisitionId, long roleId) {
        this.requisitionId = requisitionId;
        this.roleId = roleId;
    }

    public long getRequisitionId() {
        return requisitionId;
    }

    public void setRequisitionId(long requisitionId) {
        this.requisitionId = requisitionId;
    }

    public long getRoleId() {
        return roleId;
    }

    public void setRoleId(long roleId) {
        this.roleId = roleId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) requisitionId;
        hash += (int) roleId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RequisitionNotificationRolePK)) {
            return false;
        }
        RequisitionNotificationRolePK other = (RequisitionNotificationRolePK) object;
        if (this.requisitionId != other.requisitionId) {
            return false;
        }
        if (this.roleId != other.roleId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.system.demo.persistence.entity.RequisitionNotificationRolePK[ requisitionId=" + requisitionId + ", roleId=" + roleId + " ]";
    }
    
}
