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
public class RequisitionReferencePK implements Serializable {

    @Basic(optional = false)
    @Column(name = "requisition_parent_id")
    private long requisitionParentId;
    @Basic(optional = false)
    @Column(name = "requisition_child_id")
    private long requisitionChildId;

    public RequisitionReferencePK() {
    }

    public RequisitionReferencePK(long requisitionParentId, long requisitionChildId) {
        this.requisitionParentId = requisitionParentId;
        this.requisitionChildId = requisitionChildId;
    }

    public long getRequisitionParentId() {
        return requisitionParentId;
    }

    public void setRequisitionParentId(long requisitionParentId) {
        this.requisitionParentId = requisitionParentId;
    }

    public long getRequisitionChildId() {
        return requisitionChildId;
    }

    public void setRequisitionChildId(long requisitionChildId) {
        this.requisitionChildId = requisitionChildId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) requisitionParentId;
        hash += (int) requisitionChildId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RequisitionReferencePK)) {
            return false;
        }
        RequisitionReferencePK other = (RequisitionReferencePK) object;
        if (this.requisitionParentId != other.requisitionParentId) {
            return false;
        }
        if (this.requisitionChildId != other.requisitionChildId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.system.demo.persistence.entity.RequisitionReferencePK[ requisitionParentId=" + requisitionParentId + ", requisitionChildId=" + requisitionChildId + " ]";
    }
    
}
