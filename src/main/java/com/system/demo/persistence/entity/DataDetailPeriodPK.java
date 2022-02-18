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
public class DataDetailPeriodPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "data_detail_id", nullable = false)
    private long dataDetailId;
    @Basic(optional = false)
    @Column(name = "period_id", nullable = false)
    private long periodId;

    public DataDetailPeriodPK() {
    }

    public DataDetailPeriodPK(long dataDetailId, long periodId) {
        this.dataDetailId = dataDetailId;
        this.periodId = periodId;
    }

    public long getDataDetailId() {
        return dataDetailId;
    }

    public void setDataDetailId(long dataDetailId) {
        this.dataDetailId = dataDetailId;
    }

    public long getPeriodId() {
        return periodId;
    }

    public void setPeriodId(long periodId) {
        this.periodId = periodId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) dataDetailId;
        hash += (int) periodId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DataDetailPeriodPK)) {
            return false;
        }
        DataDetailPeriodPK other = (DataDetailPeriodPK) object;
        if (this.dataDetailId != other.dataDetailId) {
            return false;
        }
        if (this.periodId != other.periodId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.system.demo.persistence.entity.DataDetailPeriodPK[ dataDetailId=" + dataDetailId + ", periodId=" + periodId + " ]";
    }
    
}
