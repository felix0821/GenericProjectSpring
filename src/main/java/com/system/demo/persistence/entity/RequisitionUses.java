/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.system.demo.persistence.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "requisition_uses")
@NamedQueries({
    @NamedQuery(name = "RequisitionUses.findAll", query = "SELECT r FROM RequisitionUses r"),
    @NamedQuery(name = "RequisitionUses.findByRequisitionUsesId", query = "SELECT r FROM RequisitionUses r WHERE r.requisitionUsesId = :requisitionUsesId"),
    @NamedQuery(name = "RequisitionUses.findByRequisitionUsesTable", query = "SELECT r FROM RequisitionUses r WHERE r.requisitionUsesTable = :requisitionUsesTable")})
public class RequisitionUses implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "requisition_uses_id", nullable = false)
    private Long requisitionUsesId;
    @Basic(optional = false)
    @Column(name = "requisition_uses_table", nullable = false, length = 32)
    private String requisitionUsesTable;
    @JoinColumn(name = "requisition_id", referencedColumnName = "requisition_id", nullable = false)
    @ManyToOne(optional = false)
    private Requisition requisitionId;

    public RequisitionUses() {
    }

    public RequisitionUses(Long requisitionUsesId) {
        this.requisitionUsesId = requisitionUsesId;
    }

    public RequisitionUses(Long requisitionUsesId, String requisitionUsesTable) {
        this.requisitionUsesId = requisitionUsesId;
        this.requisitionUsesTable = requisitionUsesTable;
    }

    public Long getRequisitionUsesId() {
        return requisitionUsesId;
    }

    public void setRequisitionUsesId(Long requisitionUsesId) {
        this.requisitionUsesId = requisitionUsesId;
    }

    public String getRequisitionUsesTable() {
        return requisitionUsesTable;
    }

    public void setRequisitionUsesTable(String requisitionUsesTable) {
        this.requisitionUsesTable = requisitionUsesTable;
    }

    public Requisition getRequisitionId() {
        return requisitionId;
    }

    public void setRequisitionId(Requisition requisitionId) {
        this.requisitionId = requisitionId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (requisitionUsesId != null ? requisitionUsesId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RequisitionUses)) {
            return false;
        }
        RequisitionUses other = (RequisitionUses) object;
        if ((this.requisitionUsesId == null && other.requisitionUsesId != null) || (this.requisitionUsesId != null && !this.requisitionUsesId.equals(other.requisitionUsesId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.system.demo.model.RequisitionUses[ requisitionUsesId=" + requisitionUsesId + " ]";
    }
    
}
