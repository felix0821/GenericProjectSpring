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
@Table(name = "financial_movement_data")
@NamedQueries({
    @NamedQuery(name = "FinancialMovementData.findAll", query = "SELECT f FROM FinancialMovementData f"),
    @NamedQuery(name = "FinancialMovementData.findByFinancialMovementId", query = "SELECT f FROM FinancialMovementData f WHERE f.financialMovementDataPK.financialMovementId = :financialMovementId"),
    @NamedQuery(name = "FinancialMovementData.findByDataId", query = "SELECT f FROM FinancialMovementData f WHERE f.financialMovementDataPK.dataId = :dataId"),
    @NamedQuery(name = "FinancialMovementData.findByFinancialMovementDataState", query = "SELECT f FROM FinancialMovementData f WHERE f.financialMovementDataState = :financialMovementDataState")})
public class FinancialMovementData implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected FinancialMovementDataPK financialMovementDataPK;
    @Basic(optional = false)
    @Column(name = "financial_movement_data_state", nullable = false)
    private Character financialMovementDataState;
    @JoinColumn(name = "data_id", referencedColumnName = "data_id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Data data;
    @JoinColumn(name = "financial_movement_id", referencedColumnName = "financial_movement_id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private FinancialMovement financialMovement;

    public FinancialMovementData() {
    }

    public FinancialMovementData(FinancialMovementDataPK financialMovementDataPK) {
        this.financialMovementDataPK = financialMovementDataPK;
    }

    public FinancialMovementData(FinancialMovementDataPK financialMovementDataPK, Character financialMovementDataState) {
        this.financialMovementDataPK = financialMovementDataPK;
        this.financialMovementDataState = financialMovementDataState;
    }

    public FinancialMovementData(long financialMovementId, long dataId) {
        this.financialMovementDataPK = new FinancialMovementDataPK(financialMovementId, dataId);
    }

    public FinancialMovementDataPK getFinancialMovementDataPK() {
        return financialMovementDataPK;
    }

    public void setFinancialMovementDataPK(FinancialMovementDataPK financialMovementDataPK) {
        this.financialMovementDataPK = financialMovementDataPK;
    }

    public Character getFinancialMovementDataState() {
        return financialMovementDataState;
    }

    public void setFinancialMovementDataState(Character financialMovementDataState) {
        this.financialMovementDataState = financialMovementDataState;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public FinancialMovement getFinancialMovement() {
        return financialMovement;
    }

    public void setFinancialMovement(FinancialMovement financialMovement) {
        this.financialMovement = financialMovement;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (financialMovementDataPK != null ? financialMovementDataPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FinancialMovementData)) {
            return false;
        }
        FinancialMovementData other = (FinancialMovementData) object;
        if ((this.financialMovementDataPK == null && other.financialMovementDataPK != null) || (this.financialMovementDataPK != null && !this.financialMovementDataPK.equals(other.financialMovementDataPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.system.demo.persistence.entity.FinancialMovementData[ financialMovementDataPK=" + financialMovementDataPK + " ]";
    }
    
}
