/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.system.demo.persistence.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Felix
 */
@Entity
@Table(name = "financial_movement_detail")
@NamedQueries({
    @NamedQuery(name = "FinancialMovementDetail.findAll", query = "SELECT f FROM FinancialMovementDetail f"),
    @NamedQuery(name = "FinancialMovementDetail.findByFinancialMovementDetailId", query = "SELECT f FROM FinancialMovementDetail f WHERE f.financialMovementDetailId = :financialMovementDetailId"),
    @NamedQuery(name = "FinancialMovementDetail.findByFinancialMovementDetailAmount", query = "SELECT f FROM FinancialMovementDetail f WHERE f.financialMovementDetailAmount = :financialMovementDetailAmount"),
    @NamedQuery(name = "FinancialMovementDetail.findByFinancialMovementDetailDate", query = "SELECT f FROM FinancialMovementDetail f WHERE f.financialMovementDetailDate = :financialMovementDetailDate"),
    @NamedQuery(name = "FinancialMovementDetail.findByFinancialMovementDetailRegisterType", query = "SELECT f FROM FinancialMovementDetail f WHERE f.financialMovementDetailRegisterType = :financialMovementDetailRegisterType"),
    @NamedQuery(name = "FinancialMovementDetail.findByFinancialMovementDetailState", query = "SELECT f FROM FinancialMovementDetail f WHERE f.financialMovementDetailState = :financialMovementDetailState")})
public class FinancialMovementDetail implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "financial_movement_detail_id", nullable = false)
    private Long financialMovementDetailId;
    @Basic(optional = false)
    @Column(name = "financial_movement_detail_amount", nullable = false)
    private double financialMovementDetailAmount;
    @Basic(optional = false)
    @Column(name = "financial_movement_detail_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date financialMovementDetailDate;
    @Basic(optional = false)
    @Column(name = "financial_movement_detail_register_type", nullable = false)
    private Character financialMovementDetailRegisterType;
    @Basic(optional = false)
    @Column(name = "financial_movement_detail_state", nullable = false)
    private Character financialMovementDetailState;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "financialMovementDetail")
    private Collection<FinancialMovementRequisition> financialMovementRequisitionCollection;
    @JoinColumn(name = "financial_movement_id", referencedColumnName = "financial_movement_id", nullable = false)
    @ManyToOne(optional = false)
    private FinancialMovement financialMovementId;
    @JoinColumn(name = "person_registering_id", referencedColumnName = "person_registering_id", nullable = false)
    @ManyToOne(optional = false)
    private PersonRegistering personRegisteringId;

    public FinancialMovementDetail() {
    }

    public FinancialMovementDetail(Long financialMovementDetailId) {
        this.financialMovementDetailId = financialMovementDetailId;
    }

    public FinancialMovementDetail(Long financialMovementDetailId, double financialMovementDetailAmount, Date financialMovementDetailDate, Character financialMovementDetailRegisterType, Character financialMovementDetailState) {
        this.financialMovementDetailId = financialMovementDetailId;
        this.financialMovementDetailAmount = financialMovementDetailAmount;
        this.financialMovementDetailDate = financialMovementDetailDate;
        this.financialMovementDetailRegisterType = financialMovementDetailRegisterType;
        this.financialMovementDetailState = financialMovementDetailState;
    }

    public Long getFinancialMovementDetailId() {
        return financialMovementDetailId;
    }

    public void setFinancialMovementDetailId(Long financialMovementDetailId) {
        this.financialMovementDetailId = financialMovementDetailId;
    }

    public double getFinancialMovementDetailAmount() {
        return financialMovementDetailAmount;
    }

    public void setFinancialMovementDetailAmount(double financialMovementDetailAmount) {
        this.financialMovementDetailAmount = financialMovementDetailAmount;
    }

    public Date getFinancialMovementDetailDate() {
        return financialMovementDetailDate;
    }

    public void setFinancialMovementDetailDate(Date financialMovementDetailDate) {
        this.financialMovementDetailDate = financialMovementDetailDate;
    }

    public Character getFinancialMovementDetailRegisterType() {
        return financialMovementDetailRegisterType;
    }

    public void setFinancialMovementDetailRegisterType(Character financialMovementDetailRegisterType) {
        this.financialMovementDetailRegisterType = financialMovementDetailRegisterType;
    }

    public Character getFinancialMovementDetailState() {
        return financialMovementDetailState;
    }

    public void setFinancialMovementDetailState(Character financialMovementDetailState) {
        this.financialMovementDetailState = financialMovementDetailState;
    }

    public Collection<FinancialMovementRequisition> getFinancialMovementRequisitionCollection() {
        return financialMovementRequisitionCollection;
    }

    public void setFinancialMovementRequisitionCollection(Collection<FinancialMovementRequisition> financialMovementRequisitionCollection) {
        this.financialMovementRequisitionCollection = financialMovementRequisitionCollection;
    }

    public FinancialMovement getFinancialMovementId() {
        return financialMovementId;
    }

    public void setFinancialMovementId(FinancialMovement financialMovementId) {
        this.financialMovementId = financialMovementId;
    }

    public PersonRegistering getPersonRegisteringId() {
        return personRegisteringId;
    }

    public void setPersonRegisteringId(PersonRegistering personRegisteringId) {
        this.personRegisteringId = personRegisteringId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (financialMovementDetailId != null ? financialMovementDetailId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FinancialMovementDetail)) {
            return false;
        }
        FinancialMovementDetail other = (FinancialMovementDetail) object;
        if ((this.financialMovementDetailId == null && other.financialMovementDetailId != null) || (this.financialMovementDetailId != null && !this.financialMovementDetailId.equals(other.financialMovementDetailId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.system.demo.persistence.entity.FinancialMovementDetail[ financialMovementDetailId=" + financialMovementDetailId + " ]";
    }
    
}
