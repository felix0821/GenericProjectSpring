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
public class RequisitionDetailPersonPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "requisition_detail_id", nullable = false)
    private long requisitionDetailId;
    @Basic(optional = false)
    @Column(name = "person_id", nullable = false)
    private long personId;

    public RequisitionDetailPersonPK() {
    }

    public RequisitionDetailPersonPK(long requisitionDetailId, long personId) {
        this.requisitionDetailId = requisitionDetailId;
        this.personId = personId;
    }

    public long getRequisitionDetailId() {
        return requisitionDetailId;
    }

    public void setRequisitionDetailId(long requisitionDetailId) {
        this.requisitionDetailId = requisitionDetailId;
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
        hash += (int) requisitionDetailId;
        hash += (int) personId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RequisitionDetailPersonPK)) {
            return false;
        }
        RequisitionDetailPersonPK other = (RequisitionDetailPersonPK) object;
        if (this.requisitionDetailId != other.requisitionDetailId) {
            return false;
        }
        if (this.personId != other.personId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.system.demo.model.RequisitionDetailPersonPK[ requisitionDetailId=" + requisitionDetailId + ", personId=" + personId + " ]";
    }
    
}