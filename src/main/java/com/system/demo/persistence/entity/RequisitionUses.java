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
@Table(name = "requisition_uses", catalog = "ucps_system", schema = "public")
@NamedQueries({
    @NamedQuery(name = "RequisitionUses.findAll", query = "SELECT r FROM RequisitionUses r"),
    @NamedQuery(name = "RequisitionUses.findByRequisitionId", query = "SELECT r FROM RequisitionUses r WHERE r.requisitionUsesPK.requisitionId = :requisitionId"),
    @NamedQuery(name = "RequisitionUses.findByUsesId", query = "SELECT r FROM RequisitionUses r WHERE r.requisitionUsesPK.usesId = :usesId"),
    @NamedQuery(name = "RequisitionUses.findByRequisitionUsesState", query = "SELECT r FROM RequisitionUses r WHERE r.requisitionUsesState = :requisitionUsesState")})
public class RequisitionUses implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected RequisitionUsesPK requisitionUsesPK;
    @Basic(optional = false)
    @Column(name = "requisition_uses_state")
    private Character requisitionUsesState;
    @JoinColumn(name = "requisition_id", referencedColumnName = "requisition_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Requisition requisition;
    @JoinColumn(name = "uses_id", referencedColumnName = "uses_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Uses uses;

    public RequisitionUses() {
    }

    public RequisitionUses(RequisitionUsesPK requisitionUsesPK) {
        this.requisitionUsesPK = requisitionUsesPK;
    }

    public RequisitionUses(RequisitionUsesPK requisitionUsesPK, Character requisitionUsesState) {
        this.requisitionUsesPK = requisitionUsesPK;
        this.requisitionUsesState = requisitionUsesState;
    }

    public RequisitionUses(long requisitionId, long usesId) {
        this.requisitionUsesPK = new RequisitionUsesPK(requisitionId, usesId);
    }

    public RequisitionUsesPK getRequisitionUsesPK() {
        return requisitionUsesPK;
    }

    public void setRequisitionUsesPK(RequisitionUsesPK requisitionUsesPK) {
        this.requisitionUsesPK = requisitionUsesPK;
    }

    public Character getRequisitionUsesState() {
        return requisitionUsesState;
    }

    public void setRequisitionUsesState(Character requisitionUsesState) {
        this.requisitionUsesState = requisitionUsesState;
    }

    public Requisition getRequisition() {
        return requisition;
    }

    public void setRequisition(Requisition requisition) {
        this.requisition = requisition;
    }

    public Uses getUses() {
        return uses;
    }

    public void setUses(Uses uses) {
        this.uses = uses;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (requisitionUsesPK != null ? requisitionUsesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RequisitionUses)) {
            return false;
        }
        RequisitionUses other = (RequisitionUses) object;
        if ((this.requisitionUsesPK == null && other.requisitionUsesPK != null) || (this.requisitionUsesPK != null && !this.requisitionUsesPK.equals(other.requisitionUsesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.system.demo.persistence.entity.RequisitionUses[ requisitionUsesPK=" + requisitionUsesPK + " ]";
    }
    
}
