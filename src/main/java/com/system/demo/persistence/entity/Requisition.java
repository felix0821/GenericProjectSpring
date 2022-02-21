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
import javax.persistence.UniqueConstraint;

/**
 *
 * @author Felix
 */
@Entity
@Table(name = "requisition", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"requisition_name"})})
@NamedQueries({
    @NamedQuery(name = "Requisition.findAll", query = "SELECT r FROM Requisition r"),
    @NamedQuery(name = "Requisition.findByRequisitionId", query = "SELECT r FROM Requisition r WHERE r.requisitionId = :requisitionId"),
    @NamedQuery(name = "Requisition.findByRequisitionName", query = "SELECT r FROM Requisition r WHERE r.requisitionName = :requisitionName"),
    @NamedQuery(name = "Requisition.findByRequisitionDescription", query = "SELECT r FROM Requisition r WHERE r.requisitionDescription = :requisitionDescription"),
    @NamedQuery(name = "Requisition.findByRequisitionType", query = "SELECT r FROM Requisition r WHERE r.requisitionType = :requisitionType"),
    @NamedQuery(name = "Requisition.findByRequisitionState", query = "SELECT r FROM Requisition r WHERE r.requisitionState = :requisitionState")})
public class Requisition implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "requisition_id", nullable = false)
    private Long requisitionId;
    @Basic(optional = false)
    @Column(name = "requisition_name", nullable = false, length = 64)
    private String requisitionName;
    @Column(name = "requisition_description", length = 128)
    private String requisitionDescription;
    @Basic(optional = false)
    @Column(name = "requisition_type", nullable = false)
    private Character requisitionType;
    @Basic(optional = false)
    @Column(name = "requisition_state", nullable = false)
    private Character requisitionState;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "requisitionId")
    private Collection<RequisitionDetail> requisitionDetailCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "requisition")
    private Collection<RequisitionAccessRole> requisitionAccessRoleCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "requisition")
    private Collection<RequisitionData> requisitionDataCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "requisition")
    private Collection<RequisitionNotificationRole> requisitionNotificationRoleCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "requisition")
    private Collection<RequisitionUses> requisitionUsesCollection;

    public Requisition() {
    }

    public Requisition(Long requisitionId) {
        this.requisitionId = requisitionId;
    }

    public Requisition(Long requisitionId, String requisitionName, Character requisitionType, Character requisitionState) {
        this.requisitionId = requisitionId;
        this.requisitionName = requisitionName;
        this.requisitionType = requisitionType;
        this.requisitionState = requisitionState;
    }

    public Long getRequisitionId() {
        return requisitionId;
    }

    public void setRequisitionId(Long requisitionId) {
        this.requisitionId = requisitionId;
    }

    public String getRequisitionName() {
        return requisitionName;
    }

    public void setRequisitionName(String requisitionName) {
        this.requisitionName = requisitionName;
    }

    public String getRequisitionDescription() {
        return requisitionDescription;
    }

    public void setRequisitionDescription(String requisitionDescription) {
        this.requisitionDescription = requisitionDescription;
    }

    public Character getRequisitionType() {
        return requisitionType;
    }

    public void setRequisitionType(Character requisitionType) {
        this.requisitionType = requisitionType;
    }

    public Character getRequisitionState() {
        return requisitionState;
    }

    public void setRequisitionState(Character requisitionState) {
        this.requisitionState = requisitionState;
    }

    public Collection<RequisitionDetail> getRequisitionDetailCollection() {
        return requisitionDetailCollection;
    }

    public void setRequisitionDetailCollection(Collection<RequisitionDetail> requisitionDetailCollection) {
        this.requisitionDetailCollection = requisitionDetailCollection;
    }

    public Collection<RequisitionAccessRole> getRequisitionAccessRoleCollection() {
        return requisitionAccessRoleCollection;
    }

    public void setRequisitionAccessRoleCollection(Collection<RequisitionAccessRole> requisitionAccessRoleCollection) {
        this.requisitionAccessRoleCollection = requisitionAccessRoleCollection;
    }

    public Collection<RequisitionData> getRequisitionDataCollection() {
        return requisitionDataCollection;
    }

    public void setRequisitionDataCollection(Collection<RequisitionData> requisitionDataCollection) {
        this.requisitionDataCollection = requisitionDataCollection;
    }

    public Collection<RequisitionNotificationRole> getRequisitionNotificationRoleCollection() {
        return requisitionNotificationRoleCollection;
    }

    public void setRequisitionNotificationRoleCollection(Collection<RequisitionNotificationRole> requisitionNotificationRoleCollection) {
        this.requisitionNotificationRoleCollection = requisitionNotificationRoleCollection;
    }

    public Collection<RequisitionUses> getRequisitionUsesCollection() {
        return requisitionUsesCollection;
    }

    public void setRequisitionUsesCollection(Collection<RequisitionUses> requisitionUsesCollection) {
        this.requisitionUsesCollection = requisitionUsesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (requisitionId != null ? requisitionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Requisition)) {
            return false;
        }
        Requisition other = (Requisition) object;
        if ((this.requisitionId == null && other.requisitionId != null) || (this.requisitionId != null && !this.requisitionId.equals(other.requisitionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.system.demo.persistence.entity.Requisition[ requisitionId=" + requisitionId + " ]";
    }
    
}
