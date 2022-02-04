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
public class RoleContextPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "role_id", nullable = false)
    private long roleId;
    @Basic(optional = false)
    @Column(name = "context_id", nullable = false)
    private long contextId;

    public RoleContextPK() {
    }

    public RoleContextPK(long roleId, long contextId) {
        this.roleId = roleId;
        this.contextId = contextId;
    }

    public long getRoleId() {
        return roleId;
    }

    public void setRoleId(long roleId) {
        this.roleId = roleId;
    }

    public long getContextId() {
        return contextId;
    }

    public void setContextId(long contextId) {
        this.contextId = contextId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) roleId;
        hash += (int) contextId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RoleContextPK)) {
            return false;
        }
        RoleContextPK other = (RoleContextPK) object;
        if (this.roleId != other.roleId) {
            return false;
        }
        if (this.contextId != other.contextId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.system.demo.persistence.entity.RoleContextPK[ roleId=" + roleId + ", contextId=" + contextId + " ]";
    }
    
}
