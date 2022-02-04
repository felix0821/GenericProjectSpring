/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.system.demo.persistence.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Felix
 */
@Entity
@Table(name = "requisition_status_detail")
@NamedQueries({
    @NamedQuery(name = "RequisitionStatusDetail.findAll", query = "SELECT r FROM RequisitionStatusDetail r"),
    @NamedQuery(name = "RequisitionStatusDetail.findByRequisitionStatusDetailId", query = "SELECT r FROM RequisitionStatusDetail r WHERE r.requisitionStatusDetailId = :requisitionStatusDetailId"),
    @NamedQuery(name = "RequisitionStatusDetail.findByRequisitionStatusDetailIndex", query = "SELECT r FROM RequisitionStatusDetail r WHERE r.requisitionStatusDetailIndex = :requisitionStatusDetailIndex"),
    @NamedQuery(name = "RequisitionStatusDetail.findByRequisitionStatusDetailDate", query = "SELECT r FROM RequisitionStatusDetail r WHERE r.requisitionStatusDetailDate = :requisitionStatusDetailDate")})
public class RequisitionStatusDetail implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "requisition_status_detail_id", nullable = false)
    private Long requisitionStatusDetailId;
    @Basic(optional = false)
    @Column(name = "requisition_status_detail_index", nullable = false)
    private int requisitionStatusDetailIndex;
    @Basic(optional = false)
    @Column(name = "requisition_status_detail_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date requisitionStatusDetailDate;
    @JoinColumn(name = "person_id", referencedColumnName = "person_id", nullable = false)
    @ManyToOne(optional = false)
    private Person personId;
    @JoinColumn(name = "requisition_detail_id", referencedColumnName = "requisition_detail_id", nullable = false)
    @ManyToOne(optional = false)
    private RequisitionDetail requisitionDetailId;
    @JoinColumn(name = "requisition_status_id", referencedColumnName = "requisition_status_id", nullable = false)
    @ManyToOne(optional = false)
    private RequisitionStatus requisitionStatusId;

    public RequisitionStatusDetail() {
    }

    public RequisitionStatusDetail(Long requisitionStatusDetailId) {
        this.requisitionStatusDetailId = requisitionStatusDetailId;
    }

    public RequisitionStatusDetail(Long requisitionStatusDetailId, int requisitionStatusDetailIndex, Date requisitionStatusDetailDate) {
        this.requisitionStatusDetailId = requisitionStatusDetailId;
        this.requisitionStatusDetailIndex = requisitionStatusDetailIndex;
        this.requisitionStatusDetailDate = requisitionStatusDetailDate;
    }

    public Long getRequisitionStatusDetailId() {
        return requisitionStatusDetailId;
    }

    public void setRequisitionStatusDetailId(Long requisitionStatusDetailId) {
        this.requisitionStatusDetailId = requisitionStatusDetailId;
    }

    public int getRequisitionStatusDetailIndex() {
        return requisitionStatusDetailIndex;
    }

    public void setRequisitionStatusDetailIndex(int requisitionStatusDetailIndex) {
        this.requisitionStatusDetailIndex = requisitionStatusDetailIndex;
    }

    public Date getRequisitionStatusDetailDate() {
        return requisitionStatusDetailDate;
    }

    public void setRequisitionStatusDetailDate(Date requisitionStatusDetailDate) {
        this.requisitionStatusDetailDate = requisitionStatusDetailDate;
    }

    public Person getPersonId() {
        return personId;
    }

    public void setPersonId(Person personId) {
        this.personId = personId;
    }

    public RequisitionDetail getRequisitionDetailId() {
        return requisitionDetailId;
    }

    public void setRequisitionDetailId(RequisitionDetail requisitionDetailId) {
        this.requisitionDetailId = requisitionDetailId;
    }

    public RequisitionStatus getRequisitionStatusId() {
        return requisitionStatusId;
    }

    public void setRequisitionStatusId(RequisitionStatus requisitionStatusId) {
        this.requisitionStatusId = requisitionStatusId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (requisitionStatusDetailId != null ? requisitionStatusDetailId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RequisitionStatusDetail)) {
            return false;
        }
        RequisitionStatusDetail other = (RequisitionStatusDetail) object;
        if ((this.requisitionStatusDetailId == null && other.requisitionStatusDetailId != null) || (this.requisitionStatusDetailId != null && !this.requisitionStatusDetailId.equals(other.requisitionStatusDetailId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.system.demo.persistence.entity.RequisitionStatusDetail[ requisitionStatusDetailId=" + requisitionStatusDetailId + " ]";
    }
    
}
