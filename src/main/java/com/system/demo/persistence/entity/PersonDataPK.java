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
public class PersonDataPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "data_id", nullable = false)
    private long dataId;
    @Basic(optional = false)
    @Column(name = "role_id", nullable = false)
    private long roleId;

    public PersonDataPK() {
    }

    public PersonDataPK(long dataId, long roleId) {
        this.dataId = dataId;
        this.roleId = roleId;
    }

    public long getDataId() {
        return dataId;
    }

    public void setDataId(long dataId) {
        this.dataId = dataId;
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
        hash += (int) dataId;
        hash += (int) roleId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PersonDataPK)) {
            return false;
        }
        PersonDataPK other = (PersonDataPK) object;
        if (this.dataId != other.dataId) {
            return false;
        }
        if (this.roleId != other.roleId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.system.demo.model.PersonDataPK[ dataId=" + dataId + ", roleId=" + roleId + " ]";
    }
    
}
