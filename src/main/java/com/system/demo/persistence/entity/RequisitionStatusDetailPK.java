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
public class RequisitionStatusDetailPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "requisition_detail_id")
    private long requisitionDetailId;
    @Basic(optional = false)
    @Column(name = "requisition_status_id")
    private long requisitionStatusId;

    public RequisitionStatusDetailPK() {
    }

    public RequisitionStatusDetailPK(long requisitionDetailId, long requisitionStatusId) {
        this.requisitionDetailId = requisitionDetailId;
        this.requisitionStatusId = requisitionStatusId;
    }

    public long getRequisitionDetailId() {
        return requisitionDetailId;
    }

    public void setRequisitionDetailId(long requisitionDetailId) {
        this.requisitionDetailId = requisitionDetailId;
    }

    public long getRequisitionStatusId() {
        return requisitionStatusId;
    }

    public void setRequisitionStatusId(long requisitionStatusId) {
        this.requisitionStatusId = requisitionStatusId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) requisitionDetailId;
        hash += (int) requisitionStatusId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RequisitionStatusDetailPK)) {
            return false;
        }
        RequisitionStatusDetailPK other = (RequisitionStatusDetailPK) object;
        if (this.requisitionDetailId != other.requisitionDetailId) {
            return false;
        }
        if (this.requisitionStatusId != other.requisitionStatusId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.system.demo.persistence.entity.RequisitionStatusDetailPK[ requisitionDetailId=" + requisitionDetailId + ", requisitionStatusId=" + requisitionStatusId + " ]";
    }
    
}
