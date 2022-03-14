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
public class FinancialMovementDataPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "financial_movement_id")
    private long financialMovementId;
    @Basic(optional = false)
    @Column(name = "data_id")
    private long dataId;

    public FinancialMovementDataPK() {
    }

    public FinancialMovementDataPK(long financialMovementId, long dataId) {
        this.financialMovementId = financialMovementId;
        this.dataId = dataId;
    }

    public long getFinancialMovementId() {
        return financialMovementId;
    }

    public void setFinancialMovementId(long financialMovementId) {
        this.financialMovementId = financialMovementId;
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
        hash += (int) financialMovementId;
        hash += (int) dataId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FinancialMovementDataPK)) {
            return false;
        }
        FinancialMovementDataPK other = (FinancialMovementDataPK) object;
        if (this.financialMovementId != other.financialMovementId) {
            return false;
        }
        if (this.dataId != other.dataId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.system.demo.persistence.entity.FinancialMovementDataPK[ financialMovementId=" + financialMovementId + ", dataId=" + dataId + " ]";
    }
    
}
