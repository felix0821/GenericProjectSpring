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
@Table(name = "financial_requisition")
@NamedQueries({
    @NamedQuery(name = "FinancialRequisition.findAll", query = "SELECT f FROM FinancialRequisition f"),
    @NamedQuery(name = "FinancialRequisition.findByFinancialMovementDetailId", query = "SELECT f FROM FinancialRequisition f WHERE f.financialRequisitionPK.financialMovementDetailId = :financialMovementDetailId"),
    @NamedQuery(name = "FinancialRequisition.findByRequisitionDetailId", query = "SELECT f FROM FinancialRequisition f WHERE f.financialRequisitionPK.requisitionDetailId = :requisitionDetailId"),
    @NamedQuery(name = "FinancialRequisition.findByFinancialRequisitionState", query = "SELECT f FROM FinancialRequisition f WHERE f.financialRequisitionState = :financialRequisitionState")})
public class FinancialRequisition implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected FinancialRequisitionPK financialRequisitionPK;
    @Basic(optional = false)
    @Column(name = "financial_requisition_state", nullable = false)
    private Character financialRequisitionState;
    @JoinColumn(name = "financial_movement_detail_id", referencedColumnName = "financial_movement_detail_id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private FinancialMovementDetail financialMovementDetail;
    @JoinColumn(name = "requisition_detail_id", referencedColumnName = "requisition_detail_id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private RequisitionDetail requisitionDetail;

    public FinancialRequisition() {
    }

    public FinancialRequisition(FinancialRequisitionPK financialRequisitionPK) {
        this.financialRequisitionPK = financialRequisitionPK;
    }

    public FinancialRequisition(FinancialRequisitionPK financialRequisitionPK, Character financialRequisitionState) {
        this.financialRequisitionPK = financialRequisitionPK;
        this.financialRequisitionState = financialRequisitionState;
    }

    public FinancialRequisition(long financialMovementDetailId, long requisitionDetailId) {
        this.financialRequisitionPK = new FinancialRequisitionPK(financialMovementDetailId, requisitionDetailId);
    }

    public FinancialRequisitionPK getFinancialRequisitionPK() {
        return financialRequisitionPK;
    }

    public void setFinancialRequisitionPK(FinancialRequisitionPK financialRequisitionPK) {
        this.financialRequisitionPK = financialRequisitionPK;
    }

    public Character getFinancialRequisitionState() {
        return financialRequisitionState;
    }

    public void setFinancialRequisitionState(Character financialRequisitionState) {
        this.financialRequisitionState = financialRequisitionState;
    }

    public FinancialMovementDetail getFinancialMovementDetail() {
        return financialMovementDetail;
    }

    public void setFinancialMovementDetail(FinancialMovementDetail financialMovementDetail) {
        this.financialMovementDetail = financialMovementDetail;
    }

    public RequisitionDetail getRequisitionDetail() {
        return requisitionDetail;
    }

    public void setRequisitionDetail(RequisitionDetail requisitionDetail) {
        this.requisitionDetail = requisitionDetail;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (financialRequisitionPK != null ? financialRequisitionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FinancialRequisition)) {
            return false;
        }
        FinancialRequisition other = (FinancialRequisition) object;
        if ((this.financialRequisitionPK == null && other.financialRequisitionPK != null) || (this.financialRequisitionPK != null && !this.financialRequisitionPK.equals(other.financialRequisitionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.system.demo.persistence.entity.FinancialRequisition[ financialRequisitionPK=" + financialRequisitionPK + " ]";
    }
    
}
