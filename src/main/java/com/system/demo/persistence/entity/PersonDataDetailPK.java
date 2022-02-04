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
public class PersonDataDetailPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "data_id", nullable = false)
    private long dataId;
    @Basic(optional = false)
    @Column(name = "role_id", nullable = false)
    private long roleId;
    @Basic(optional = false)
    @Column(name = "person_id", nullable = false)
    private long personId;

    public PersonDataDetailPK() {
    }

    public PersonDataDetailPK(long dataId, long roleId, long personId) {
        this.dataId = dataId;
        this.roleId = roleId;
        this.personId = personId;
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

    public long getPersonId() {
        return personId;
    }

    public void setPersonId(long personId) {
        this.personId = personId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) dataId;
        hash += (int) roleId;
        hash += (int) personId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PersonDataDetailPK)) {
            return false;
        }
        PersonDataDetailPK other = (PersonDataDetailPK) object;
        if (this.dataId != other.dataId) {
            return false;
        }
        if (this.roleId != other.roleId) {
            return false;
        }
        if (this.personId != other.personId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.system.demo.persistence.entity.PersonDataDetailPK[ dataId=" + dataId + ", roleId=" + roleId + ", personId=" + personId + " ]";
    }
    
}
