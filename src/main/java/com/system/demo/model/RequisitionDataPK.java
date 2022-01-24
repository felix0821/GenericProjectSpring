/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.system.demo.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Felix
 */
@Embeddable
public class RequisitionDataPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "requisition_id", nullable = false)
    private long requisitionId;
    @Basic(optional = false)
    @Column(name = "data_id", nullable = false)
    private long dataId;

    public RequisitionDataPK() {
    }

    public RequisitionDataPK(long requisitionId, long dataId) {
        this.requisitionId = requisitionId;
        this.dataId = dataId;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) requisitionId;
        hash += (int) dataId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RequisitionDataPK)) {
            return false;
        }
        RequisitionDataPK other = (RequisitionDataPK) object;
        if (this.requisitionId != other.requisitionId) {
            return false;
        }
        if (this.dataId != other.dataId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.system.demo.model.RequisitionDataPK[ requisitionId=" + requisitionId + ", dataId=" + dataId + " ]";
    }
    
}
