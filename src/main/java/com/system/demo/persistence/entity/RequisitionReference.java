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
@Table(name = "requisition_reference", catalog = "ucps_system", schema = "public")
@NamedQueries({
    @NamedQuery(name = "RequisitionReference.findAll", query = "SELECT r FROM RequisitionReference r"),
    @NamedQuery(name = "RequisitionReference.findByRequisitionParentId", query = "SELECT r FROM RequisitionReference r WHERE r.requisitionReferencePK.requisitionParentId = :requisitionParentId"),
    @NamedQuery(name = "RequisitionReference.findByRequisitionChildId", query = "SELECT r FROM RequisitionReference r WHERE r.requisitionReferencePK.requisitionChildId = :requisitionChildId"),
    @NamedQuery(name = "RequisitionReference.findByRequisitionReferenceName", query = "SELECT r FROM RequisitionReference r WHERE r.requisitionReferenceName = :requisitionReferenceName"),
    @NamedQuery(name = "RequisitionReference.findByRequisitionReferenceState", query = "SELECT r FROM RequisitionReference r WHERE r.requisitionReferenceState = :requisitionReferenceState")})
public class RequisitionReference implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected RequisitionReferencePK requisitionReferencePK;
    @Basic(optional = false)
    @Column(name = "requisition_reference_name")
    private String requisitionReferenceName;
    @Basic(optional = false)
    @Column(name = "requisition_reference_state")
    private Character requisitionReferenceState;
    @JoinColumn(name = "requisition_parent_id", referencedColumnName = "requisition_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Requisition requisition;
    @JoinColumn(name = "requisition_child_id", referencedColumnName = "requisition_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Requisition requisition1;

    public RequisitionReference() {
    }

    public RequisitionReference(RequisitionReferencePK requisitionReferencePK) {
        this.requisitionReferencePK = requisitionReferencePK;
    }

    public RequisitionReference(RequisitionReferencePK requisitionReferencePK, String requisitionReferenceName, Character requisitionReferenceState) {
        this.requisitionReferencePK = requisitionReferencePK;
        this.requisitionReferenceName = requisitionReferenceName;
        this.requisitionReferenceState = requisitionReferenceState;
    }

    public RequisitionReference(long requisitionParentId, long requisitionChildId) {
        this.requisitionReferencePK = new RequisitionReferencePK(requisitionParentId, requisitionChildId);
    }

    public RequisitionReferencePK getRequisitionReferencePK() {
        return requisitionReferencePK;
    }

    public void setRequisitionReferencePK(RequisitionReferencePK requisitionReferencePK) {
        this.requisitionReferencePK = requisitionReferencePK;
    }

    public String getRequisitionReferenceName() {
        return requisitionReferenceName;
    }

    public void setRequisitionReferenceName(String requisitionReferenceName) {
        this.requisitionReferenceName = requisitionReferenceName;
    }

    public Character getRequisitionReferenceState() {
        return requisitionReferenceState;
    }

    public void setRequisitionReferenceState(Character requisitionReferenceState) {
        this.requisitionReferenceState = requisitionReferenceState;
    }

    public Requisition getRequisition() {
        return requisition;
    }

    public void setRequisition(Requisition requisition) {
        this.requisition = requisition;
    }

    public Requisition getRequisition1() {
        return requisition1;
    }

    public void setRequisition1(Requisition requisition1) {
        this.requisition1 = requisition1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (requisitionReferencePK != null ? requisitionReferencePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RequisitionReference)) {
            return false;
        }
        RequisitionReference other = (RequisitionReference) object;
        if ((this.requisitionReferencePK == null && other.requisitionReferencePK != null) || (this.requisitionReferencePK != null && !this.requisitionReferencePK.equals(other.requisitionReferencePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.system.demo.persistence.entity.RequisitionReference[ requisitionReferencePK=" + requisitionReferencePK + " ]";
    }
    
}
