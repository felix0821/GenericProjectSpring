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
@Table(name = "financial_movement_requisition")
@NamedQueries({
    @NamedQuery(name = "FinancialMovementRequisition.findAll", query = "SELECT f FROM FinancialMovementRequisition f"),
    @NamedQuery(name = "FinancialMovementRequisition.findByFinancialMovementDetailId", query = "SELECT f FROM FinancialMovementRequisition f WHERE f.financialMovementRequisitionPK.financialMovementDetailId = :financialMovementDetailId"),
    @NamedQuery(name = "FinancialMovementRequisition.findByRequisitionDetailId", query = "SELECT f FROM FinancialMovementRequisition f WHERE f.financialMovementRequisitionPK.requisitionDetailId = :requisitionDetailId"),
    @NamedQuery(name = "FinancialMovementRequisition.findByFinancialMovementRequisitionState", query = "SELECT f FROM FinancialMovementRequisition f WHERE f.financialMovementRequisitionState = :financialMovementRequisitionState")})
public class FinancialMovementRequisition implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected FinancialMovementRequisitionPK financialMovementRequisitionPK;
    @Basic(optional = false)
    @Column(name = "financial_movement_requisition_state", nullable = false)
    private Character financialMovementRequisitionState;
    @JoinColumn(name = "financial_movement_detail_id", referencedColumnName = "financial_movement_detail_id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private FinancialMovementDetail financialMovementDetail;
    @JoinColumn(name = "requisition_detail_id", referencedColumnName = "requisition_detail_id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private RequisitionDetail requisitionDetail;

    public FinancialMovementRequisition() {
    }

    public FinancialMovementRequisition(FinancialMovementRequisitionPK financialMovementRequisitionPK) {
        this.financialMovementRequisitionPK = financialMovementRequisitionPK;
    }

    public FinancialMovementRequisition(FinancialMovementRequisitionPK financialMovementRequisitionPK, Character financialMovementRequisitionState) {
        this.financialMovementRequisitionPK = financialMovementRequisitionPK;
        this.financialMovementRequisitionState = financialMovementRequisitionState;
    }

    public FinancialMovementRequisition(long financialMovementDetailId, long requisitionDetailId) {
        this.financialMovementRequisitionPK = new FinancialMovementRequisitionPK(financialMovementDetailId, requisitionDetailId);
    }

    public FinancialMovementRequisitionPK getFinancialMovementRequisitionPK() {
        return financialMovementRequisitionPK;
    }

    public void setFinancialMovementRequisitionPK(FinancialMovementRequisitionPK financialMovementRequisitionPK) {
        this.financialMovementRequisitionPK = financialMovementRequisitionPK;
    }

    public Character getFinancialMovementRequisitionState() {
        return financialMovementRequisitionState;
    }

    public void setFinancialMovementRequisitionState(Character financialMovementRequisitionState) {
        this.financialMovementRequisitionState = financialMovementRequisitionState;
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
        hash += (financialMovementRequisitionPK != null ? financialMovementRequisitionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FinancialMovementRequisition)) {
            return false;
        }
        FinancialMovementRequisition other = (FinancialMovementRequisition) object;
        if ((this.financialMovementRequisitionPK == null && other.financialMovementRequisitionPK != null) || (this.financialMovementRequisitionPK != null && !this.financialMovementRequisitionPK.equals(other.financialMovementRequisitionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.system.demo.persistence.entity.FinancialMovementRequisition[ financialMovementRequisitionPK=" + financialMovementRequisitionPK + " ]";
    }
    
}
