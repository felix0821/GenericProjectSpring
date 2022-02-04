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
public class RequisitionDataDetailPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "requisition_id", nullable = false)
    private long requisitionId;
    @Basic(optional = false)
    @Column(name = "data_id", nullable = false)
    private long dataId;
    @Basic(optional = false)
    @Column(name = "requisition_detail_id", nullable = false)
    private long requisitionDetailId;

    public RequisitionDataDetailPK() {
    }

    public RequisitionDataDetailPK(long requisitionId, long dataId, long requisitionDetailId) {
        this.requisitionId = requisitionId;
        this.dataId = dataId;
        this.requisitionDetailId = requisitionDetailId;
    }

    public long getRequisitionId() {
        return requisitionId;
    }

    public void setRequisitionId(long requisitionId) {
        this.requisitionId = requisitionId;
    }

    public long getDataId() {
        return dataId;
    }

    public void setDataId(long dataId) {
        this.dataId = dataId;
    }

    public long getRequisitionDetailId() {
        return requisitionDetailId;
    }

    public void setRequisitionDetailId(long requisitionDetailId) {
        this.requisitionDetailId = requisitionDetailId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) requisitionId;
        hash += (int) dataId;
        hash += (int) requisitionDetailId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RequisitionDataDetailPK)) {
            return false;
        }
        RequisitionDataDetailPK other = (RequisitionDataDetailPK) object;
        if (this.requisitionId != other.requisitionId) {
            return false;
        }
        if (this.dataId != other.dataId) {
            return false;
        }
        if (this.requisitionDetailId != other.requisitionDetailId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.system.demo.persistence.entity.RequisitionDataDetailPK[ requisitionId=" + requisitionId + ", dataId=" + dataId + ", requisitionDetailId=" + requisitionDetailId + " ]";
    }
    
}
