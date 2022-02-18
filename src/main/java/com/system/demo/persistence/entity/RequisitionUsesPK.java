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
public class RequisitionUsesPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "requisition_id", nullable = false)
    private long requisitionId;
    @Basic(optional = false)
    @Column(name = "uses_id", nullable = false)
    private long usesId;

    public RequisitionUsesPK() {
    }

    public RequisitionUsesPK(long requisitionId, long usesId) {
        this.requisitionId = requisitionId;
        this.usesId = usesId;
    }

    public long getRequisitionId() {
        return requisitionId;
    }

    public void setRequisitionId(long requisitionId) {
        this.requisitionId = requisitionId;
    }

    public long getUsesId() {
        return usesId;
    }

    public void setUsesId(long usesId) {
        this.usesId = usesId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) requisitionId;
        hash += (int) usesId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RequisitionUsesPK)) {
            return false;
        }
        RequisitionUsesPK other = (RequisitionUsesPK) object;
        if (this.requisitionId != other.requisitionId) {
            return false;
        }
        if (this.usesId != other.usesId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.system.demo.persistence.entity.RequisitionUsesPK[ requisitionId=" + requisitionId + ", usesId=" + usesId + " ]";
    }
    
}
