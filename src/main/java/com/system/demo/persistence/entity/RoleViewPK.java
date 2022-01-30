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
public class RoleViewPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "interface_view_id", nullable = false)
    private long interfaceViewId;
    @Basic(optional = false)
    @Column(name = "role_id", nullable = false)
    private long roleId;

    public RoleViewPK() {
    }

    public RoleViewPK(long interfaceViewId, long roleId) {
        this.interfaceViewId = interfaceViewId;
        this.roleId = roleId;
    }

    public long getInterfaceViewId() {
        return interfaceViewId;
    }

    public void setInterfaceViewId(long interfaceViewId) {
        this.interfaceViewId = interfaceViewId;
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
        hash += (int) interfaceViewId;
        hash += (int) roleId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RoleViewPK)) {
            return false;
        }
        RoleViewPK other = (RoleViewPK) object;
        if (this.interfaceViewId != other.interfaceViewId) {
            return false;
        }
        if (this.roleId != other.roleId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.system.demo.model.RoleViewPK[ interfaceViewId=" + interfaceViewId + ", roleId=" + roleId + " ]";
    }
    
}
