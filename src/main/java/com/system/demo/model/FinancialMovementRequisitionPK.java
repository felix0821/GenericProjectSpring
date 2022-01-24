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
public class FinancialMovementRequisitionPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "financial_movement_detail_id", nullable = false)
    private long financialMovementDetailId;
    @Basic(optional = false)
    @Column(name = "requisition_detail_id", nullable = false)
    private long requisitionDetailId;

    public FinancialMovementRequisitionPK() {
    }

    public FinancialMovementRequisitionPK(long financialMovementDetailId, long requisitionDetailId) {
        this.financialMovementDetailId = financialMovementDetailId;
        this.requisitionDetailId = requisitionDetailId;
    }

    public long getFinancialMovementDetailId() {
        return financialMovementDetailId;
    }

    public void setFinancialMovementDetailId(long financialMovementDetailId) {
        this.financialMovementDetailId = financialMovementDetailId;
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
        hash += (int) financialMovementDetailId;
        hash += (int) requisitionDetailId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FinancialMovementRequisitionPK)) {
            return false;
        }
        FinancialMovementRequisitionPK other = (FinancialMovementRequisitionPK) object;
        if (this.financialMovementDetailId != other.financialMovementDetailId) {
            return false;
        }
        if (this.requisitionDetailId != other.requisitionDetailId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.system.demo.model.FinancialMovementRequisitionPK[ financialMovementDetailId=" + financialMovementDetailId + ", requisitionDetailId=" + requisitionDetailId + " ]";
    }
    
}
