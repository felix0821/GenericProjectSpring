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
@Table(name = "data_detail_period")
@NamedQueries({
    @NamedQuery(name = "DataDetailPeriod.findAll", query = "SELECT d FROM DataDetailPeriod d"),
    @NamedQuery(name = "DataDetailPeriod.findByDataDetailId", query = "SELECT d FROM DataDetailPeriod d WHERE d.dataDetailPeriodPK.dataDetailId = :dataDetailId"),
    @NamedQuery(name = "DataDetailPeriod.findByPeriodId", query = "SELECT d FROM DataDetailPeriod d WHERE d.dataDetailPeriodPK.periodId = :periodId"),
    @NamedQuery(name = "DataDetailPeriod.findByDataDetailPeriodState", query = "SELECT d FROM DataDetailPeriod d WHERE d.dataDetailPeriodState = :dataDetailPeriodState")})
public class DataDetailPeriod implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DataDetailPeriodPK dataDetailPeriodPK;
    @Basic(optional = false)
    @Column(name = "data_detail_period_state", nullable = false)
    private Character dataDetailPeriodState;
    @JoinColumn(name = "data_detail_id", referencedColumnName = "data_detail_id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private DataDetail dataDetail;
    @JoinColumn(name = "period_id", referencedColumnName = "period_id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Period period;

    public DataDetailPeriod() {
    }

    public DataDetailPeriod(DataDetailPeriodPK dataDetailPeriodPK) {
        this.dataDetailPeriodPK = dataDetailPeriodPK;
    }

    public DataDetailPeriod(DataDetailPeriodPK dataDetailPeriodPK, Character dataDetailPeriodState) {
        this.dataDetailPeriodPK = dataDetailPeriodPK;
        this.dataDetailPeriodState = dataDetailPeriodState;
    }

    public DataDetailPeriod(long dataDetailId, long periodId) {
        this.dataDetailPeriodPK = new DataDetailPeriodPK(dataDetailId, periodId);
    }

    public DataDetailPeriodPK getDataDetailPeriodPK() {
        return dataDetailPeriodPK;
    }

    public void setDataDetailPeriodPK(DataDetailPeriodPK dataDetailPeriodPK) {
        this.dataDetailPeriodPK = dataDetailPeriodPK;
    }

    public Character getDataDetailPeriodState() {
        return dataDetailPeriodState;
    }

    public void setDataDetailPeriodState(Character dataDetailPeriodState) {
        this.dataDetailPeriodState = dataDetailPeriodState;
    }

    public DataDetail getDataDetail() {
        return dataDetail;
    }

    public void setDataDetail(DataDetail dataDetail) {
        this.dataDetail = dataDetail;
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
        hash += (dataDetailPeriodPK != null ? dataDetailPeriodPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DataDetailPeriod)) {
            return false;
        }
        DataDetailPeriod other = (DataDetailPeriod) object;
        if ((this.dataDetailPeriodPK == null && other.dataDetailPeriodPK != null) || (this.dataDetailPeriodPK != null && !this.dataDetailPeriodPK.equals(other.dataDetailPeriodPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.system.demo.persistence.entity.DataDetailPeriod[ dataDetailPeriodPK=" + dataDetailPeriodPK + " ]";
    }
    
}
