/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.system.demo.persistence.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Felix
 */
@Entity
@Table(name = "financial_movement")
@NamedQueries({
    @NamedQuery(name = "FinancialMovement.findAll", query = "SELECT f FROM FinancialMovement f"),
    @NamedQuery(name = "FinancialMovement.findByFinancialMovementId", query = "SELECT f FROM FinancialMovement f WHERE f.financialMovementId = :financialMovementId"),
    @NamedQuery(name = "FinancialMovement.findByFinancialMovementName", query = "SELECT f FROM FinancialMovement f WHERE f.financialMovementName = :financialMovementName"),
    @NamedQuery(name = "FinancialMovement.findByFinancialMovementSymbol", query = "SELECT f FROM FinancialMovement f WHERE f.financialMovementSymbol = :financialMovementSymbol"),
    @NamedQuery(name = "FinancialMovement.findByFinancialMovementType", query = "SELECT f FROM FinancialMovement f WHERE f.financialMovementType = :financialMovementType"),
    @NamedQuery(name = "FinancialMovement.findByFinancialMovementState", query = "SELECT f FROM FinancialMovement f WHERE f.financialMovementState = :financialMovementState")})
public class FinancialMovement implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "financial_movement_id", nullable = false)
    private Long financialMovementId;
    @Basic(optional = false)
    @Column(name = "financial_movement_name", nullable = false, length = 64)
    private String financialMovementName;
    @Basic(optional = false)
    @Column(name = "financial_movement_symbol", nullable = false, length = 16)
    private String financialMovementSymbol;
    @Basic(optional = false)
    @Column(name = "financial_movement_type", nullable = false)
    private Character financialMovementType;
    @Basic(optional = false)
    @Column(name = "financial_movement_state", nullable = false)
    private Character financialMovementState;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "financialMovement")
    private Collection<FinancialMovementData> financialMovementDataCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "financialMovementId")
    private Collection<FinancialMovementDetail> financialMovementDetailCollection;

    public FinancialMovement() {
    }

    public FinancialMovement(Long financialMovementId) {
        this.financialMovementId = financialMovementId;
    }

    public FinancialMovement(Long financialMovementId, String financialMovementName, String financialMovementSymbol, Character financialMovementType, Character financialMovementState) {
        this.financialMovementId = financialMovementId;
        this.financialMovementName = financialMovementName;
        this.financialMovementSymbol = financialMovementSymbol;
        this.financialMovementType = financialMovementType;
        this.financialMovementState = financialMovementState;
    }

    public Long getFinancialMovementId() {
        return financialMovementId;
    }

    public void setFinancialMovementId(Long financialMovementId) {
        this.financialMovementId = financialMovementId;
    }

    public String getFinancialMovementName() {
        return financialMovementName;
    }

    public void setFinancialMovementName(String financialMovementName) {
        this.financialMovementName = financialMovementName;
    }

    public String getFinancialMovementSymbol() {
        return financialMovementSymbol;
    }

    public void setFinancialMovementSymbol(String financialMovementSymbol) {
        this.financialMovementSymbol = financialMovementSymbol;
    }

    public Character getFinancialMovementType() {
        return financialMovementType;
    }

    public void setFinancialMovementType(Character financialMovementType) {
        this.financialMovementType = financialMovementType;
    }

    public Character getFinancialMovementState() {
        return financialMovementState;
    }

    public void setFinancialMovementState(Character financialMovementState) {
        this.financialMovementState = financialMovementState;
    }

    public Collection<FinancialMovementData> getFinancialMovementDataCollection() {
        return financialMovementDataCollection;
    }

    public void setFinancialMovementDataCollection(Collection<FinancialMovementData> financialMovementDataCollection) {
        this.financialMovementDataCollection = financialMovementDataCollection;
    }

    public Collection<FinancialMovementDetail> getFinancialMovementDetailCollection() {
        return financialMovementDetailCollection;
    }

    public void setFinancialMovementDetailCollection(Collection<FinancialMovementDetail> financialMovementDetailCollection) {
        this.financialMovementDetailCollection = financialMovementDetailCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (financialMovementId != null ? financialMovementId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FinancialMovement)) {
            return false;
        }
        FinancialMovement other = (FinancialMovement) object;
        if ((this.financialMovementId == null && other.financialMovementId != null) || (this.financialMovementId != null && !this.financialMovementId.equals(other.financialMovementId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.system.demo.persistence.entity.FinancialMovement[ financialMovementId=" + financialMovementId + " ]";
    }
    
}
