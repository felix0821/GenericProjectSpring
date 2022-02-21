/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.system.demo.persistence.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Felix
 */
@Entity
@Table(name = "period_data")
@NamedQueries({
    @NamedQuery(name = "PeriodData.findAll", query = "SELECT p FROM PeriodData p"),
    @NamedQuery(name = "PeriodData.findByPeriodId", query = "SELECT p FROM PeriodData p WHERE p.periodDataPK.periodId = :periodId"),
    @NamedQuery(name = "PeriodData.findByDataId", query = "SELECT p FROM PeriodData p WHERE p.periodDataPK.dataId = :dataId"),
    @NamedQuery(name = "PeriodData.findByPeriodDataState", query = "SELECT p FROM PeriodData p WHERE p.periodDataState = :periodDataState")})
public class PeriodData implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PeriodDataPK periodDataPK;
    @Basic(optional = false)
    @Column(name = "period_data_state", nullable = false)
    private Character periodDataState;
    @JoinColumn(name = "data_id", referencedColumnName = "data_id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Data data;
    @JoinColumn(name = "period_id", referencedColumnName = "period_id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Period period;

    public PeriodData() {
    }

    public PeriodData(PeriodDataPK periodDataPK) {
        this.periodDataPK = periodDataPK;
    }

    public PeriodData(PeriodDataPK periodDataPK, Character periodDataState) {
        this.periodDataPK = periodDataPK;
        this.periodDataState = periodDataState;
    }

    public PeriodData(long periodId, long dataId) {
        this.periodDataPK = new PeriodDataPK(periodId, dataId);
    }

    public PeriodDataPK getPeriodDataPK() {
        return periodDataPK;
    }

    public void setPeriodDataPK(PeriodDataPK periodDataPK) {
        this.periodDataPK = periodDataPK;
    }

    public Character getPeriodDataState() {
        return periodDataState;
    }

    public void setPeriodDataState(Character periodDataState) {
        this.periodDataState = periodDataState;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public Period getPeriod() {
        return period;
    }

    public void setPeriod(Period period) {
        this.period = period;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (periodDataPK != null ? periodDataPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PeriodData)) {
            return false;
        }
        PeriodData other = (PeriodData) object;
        if ((this.periodDataPK == null && other.periodDataPK != null) || (this.periodDataPK != null && !this.periodDataPK.equals(other.periodDataPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.system.demo.persistence.entity.PeriodData[ periodDataPK=" + periodDataPK + " ]";
    }
    
}
