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
public class PeriodDataPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "period_id", nullable = false)
    private long periodId;
    @Basic(optional = false)
    @Column(name = "data_id", nullable = false)
    private long dataId;

    public PeriodDataPK() {
    }

    public PeriodDataPK(long periodId, long dataId) {
        this.periodId = periodId;
        this.dataId = dataId;
    }

    public long getPeriodId() {
        return periodId;
    }

    public void setPeriodId(long periodId) {
        this.periodId = periodId;
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
        hash += (int) periodId;
        hash += (int) dataId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PeriodDataPK)) {
            return false;
        }
        PeriodDataPK other = (PeriodDataPK) object;
        if (this.periodId != other.periodId) {
            return false;
        }
        if (this.dataId != other.dataId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.system.demo.persistence.entity.PeriodDataPK[ periodId=" + periodId + ", dataId=" + dataId + " ]";
    }
    
}
