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
@Table(name = "requisition_status")
@NamedQueries({
    @NamedQuery(name = "RequisitionStatus.findAll", query = "SELECT r FROM RequisitionStatus r"),
    @NamedQuery(name = "RequisitionStatus.findByRequisitionStatusId", query = "SELECT r FROM RequisitionStatus r WHERE r.requisitionStatusId = :requisitionStatusId"),
    @NamedQuery(name = "RequisitionStatus.findByRequisitionStatusName", query = "SELECT r FROM RequisitionStatus r WHERE r.requisitionStatusName = :requisitionStatusName"),
    @NamedQuery(name = "RequisitionStatus.findByRequisitionStatusDescription", query = "SELECT r FROM RequisitionStatus r WHERE r.requisitionStatusDescription = :requisitionStatusDescription"),
    @NamedQuery(name = "RequisitionStatus.findByRequisitionStatusColor", query = "SELECT r FROM RequisitionStatus r WHERE r.requisitionStatusColor = :requisitionStatusColor"),
    @NamedQuery(name = "RequisitionStatus.findByRequisitionStatusState", query = "SELECT r FROM RequisitionStatus r WHERE r.requisitionStatusState = :requisitionStatusState")})
public class RequisitionStatus implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "requisition_status_id", nullable = false)
    private Long requisitionStatusId;
    @Basic(optional = false)
    @Column(name = "requisition_status_name", nullable = false, length = 64)
    private String requisitionStatusName;
    @Basic(optional = false)
    @Column(name = "requisition_status_description", nullable = false, length = 128)
    private String requisitionStatusDescription;
    @Basic(optional = false)
    @Column(name = "requisition_status_color", nullable = false, length = 32)
    private String requisitionStatusColor;
    @Basic(optional = false)
    @Column(name = "requisition_status_state", nullable = false)
    private Character requisitionStatusState;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "requisitionStatus")
    private Collection<RequisitionStatusDetail> requisitionStatusDetailCollection;

    public RequisitionStatus() {
    }

    public RequisitionStatus(Long requisitionStatusId) {
        this.requisitionStatusId = requisitionStatusId;
    }

    public RequisitionStatus(Long requisitionStatusId, String requisitionStatusName, String requisitionStatusDescription, String requisitionStatusColor, Character requisitionStatusState) {
        this.requisitionStatusId = requisitionStatusId;
        this.requisitionStatusName = requisitionStatusName;
        this.requisitionStatusDescription = requisitionStatusDescription;
        this.requisitionStatusColor = requisitionStatusColor;
        this.requisitionStatusState = requisitionStatusState;
    }

    public Long getRequisitionStatusId() {
        return requisitionStatusId;
    }

    public void setRequisitionStatusId(Long requisitionStatusId) {
        this.requisitionStatusId = requisitionStatusId;
    }

    public String getRequisitionStatusName() {
        return requisitionStatusName;
    }

    public void setRequisitionStatusName(String requisitionStatusName) {
        this.requisitionStatusName = requisitionStatusName;
    }

    public String getRequisitionStatusDescription() {
        return requisitionStatusDescription;
    }

    public void setRequisitionStatusDescription(String requisitionStatusDescription) {
        this.requisitionStatusDescription = requisitionStatusDescription;
    }

    public String getRequisitionStatusColor() {
        return requisitionStatusColor;
    }

    public void setRequisitionStatusColor(String requisitionStatusColor) {
        this.requisitionStatusColor = requisitionStatusColor;
    }

    public Character getRequisitionStatusState() {
        return requisitionStatusState;
    }

    public void setRequisitionStatusState(Character requisitionStatusState) {
        this.requisitionStatusState = requisitionStatusState;
    }

    public Collection<RequisitionStatusDetail> getRequisitionStatusDetailCollection() {
        return requisitionStatusDetailCollection;
    }

    public void setRequisitionStatusDetailCollection(Collection<RequisitionStatusDetail> requisitionStatusDetailCollection) {
        this.requisitionStatusDetailCollection = requisitionStatusDetailCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (requisitionStatusId != null ? requisitionStatusId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RequisitionStatus)) {
            return false;
        }
        RequisitionStatus other = (RequisitionStatus) object;
        if ((this.requisitionStatusId == null && other.requisitionStatusId != null) || (this.requisitionStatusId != null && !this.requisitionStatusId.equals(other.requisitionStatusId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.system.demo.persistence.entity.RequisitionStatus[ requisitionStatusId=" + requisitionStatusId + " ]";
    }
    
}
