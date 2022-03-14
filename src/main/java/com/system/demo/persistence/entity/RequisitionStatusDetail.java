/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.system.demo.persistence.entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "requisition_status_detail", catalog = "ucps_system", schema = "public")
@NamedQueries({
    @NamedQuery(name = "RequisitionStatusDetail.findAll", query = "SELECT r FROM RequisitionStatusDetail r"),
    @NamedQuery(name = "RequisitionStatusDetail.findByRequisitionDetailId", query = "SELECT r FROM RequisitionStatusDetail r WHERE r.requisitionStatusDetailPK.requisitionDetailId = :requisitionDetailId"),
    @NamedQuery(name = "RequisitionStatusDetail.findByRequisitionStatusId", query = "SELECT r FROM RequisitionStatusDetail r WHERE r.requisitionStatusDetailPK.requisitionStatusId = :requisitionStatusId"),
    @NamedQuery(name = "RequisitionStatusDetail.findByRequisitionStatusDetailIndex", query = "SELECT r FROM RequisitionStatusDetail r WHERE r.requisitionStatusDetailIndex = :requisitionStatusDetailIndex"),
    @NamedQuery(name = "RequisitionStatusDetail.findByRequisitionStatusDetailDate", query = "SELECT r FROM RequisitionStatusDetail r WHERE r.requisitionStatusDetailDate = :requisitionStatusDetailDate")})
public class RequisitionStatusDetail implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected RequisitionStatusDetailPK requisitionStatusDetailPK;
    @Column(name = "requisition_status_detail_index")
    private BigInteger requisitionStatusDetailIndex;
    @Basic(optional = false)
    @Column(name = "requisition_status_detail_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date requisitionStatusDetailDate;
    @JoinColumn(name = "person_id", referencedColumnName = "person_id")
    @ManyToOne(optional = false)
    private Person personId;
    @JoinColumn(name = "requisition_detail_id", referencedColumnName = "requisition_detail_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private RequisitionDetail requisitionDetail;
    @JoinColumn(name = "requisition_status_id", referencedColumnName = "requisition_status_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private RequisitionStatus requisitionStatus;

    public RequisitionStatusDetail() {
    }

    public RequisitionStatusDetail(RequisitionStatusDetailPK requisitionStatusDetailPK) {
        this.requisitionStatusDetailPK = requisitionStatusDetailPK;
    }

    public RequisitionStatusDetail(RequisitionStatusDetailPK requisitionStatusDetailPK, Date requisitionStatusDetailDate) {
        this.requisitionStatusDetailPK = requisitionStatusDetailPK;
        this.requisitionStatusDetailDate = requisitionStatusDetailDate;
    }

    public RequisitionStatusDetail(long requisitionDetailId, long requisitionStatusId) {
        this.requisitionStatusDetailPK = new RequisitionStatusDetailPK(requisitionDetailId, requisitionStatusId);
    }

    public RequisitionStatusDetailPK getRequisitionStatusDetailPK() {
        return requisitionStatusDetailPK;
    }

    public void setRequisitionStatusDetailPK(RequisitionStatusDetailPK requisitionStatusDetailPK) {
        this.requisitionStatusDetailPK = requisitionStatusDetailPK;
    }

    public BigInteger getRequisitionStatusDetailIndex() {
        return requisitionStatusDetailIndex;
    }

    public void setRequisitionStatusDetailIndex(BigInteger requisitionStatusDetailIndex) {
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

    public RequisitionDetail getRequisitionDetail() {
        return requisitionDetail;
    }

    public void setRequisitionDetail(RequisitionDetail requisitionDetail) {
        this.requisitionDetail = requisitionDetail;
    }

    public RequisitionStatus getRequisitionStatus() {
        return requisitionStatus;
    }

    public void setRequisitionStatus(RequisitionStatus requisitionStatus) {
        this.requisitionStatus = requisitionStatus;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (requisitionStatusDetailPK != null ? requisitionStatusDetailPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RequisitionStatusDetail)) {
            return false;
        }
        RequisitionStatusDetail other = (RequisitionStatusDetail) object;
        if ((this.requisitionStatusDetailPK == null && other.requisitionStatusDetailPK != null) || (this.requisitionStatusDetailPK != null && !this.requisitionStatusDetailPK.equals(other.requisitionStatusDetailPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.system.demo.persistence.entity.RequisitionStatusDetail[ requisitionStatusDetailPK=" + requisitionStatusDetailPK + " ]";
    }
    
}
