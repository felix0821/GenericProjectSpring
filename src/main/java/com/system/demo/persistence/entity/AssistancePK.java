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
public class AssistancePK implements Serializable {

    @Basic(optional = false)
    @Column(name = "person_id", nullable = false)
    private long personId;
    @Basic(optional = false)
    @Column(name = "horary_detail_id", nullable = false)
    private long horaryDetailId;

    public AssistancePK() {
    }

    public AssistancePK(long personId, long horaryDetailId) {
        this.personId = personId;
        this.horaryDetailId = horaryDetailId;
    }

    public long getPersonId() {
        return personId;
    }

    public void setPersonId(long personId) {
        this.personId = personId;
    }

    public long getHoraryDetailId() {
        return horaryDetailId;
    }

    public void setHoraryDetailId(long horaryDetailId) {
        this.horaryDetailId = horaryDetailId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) personId;
        hash += (int) horaryDetailId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AssistancePK)) {
            return false;
        }
        AssistancePK other = (AssistancePK) object;
        if (this.personId != other.personId) {
            return false;
        }
        if (this.horaryDetailId != other.horaryDetailId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.system.demo.persistence.entity.AssistancePK[ personId=" + personId + ", horaryDetailId=" + horaryDetailId + " ]";
    }
    
}
