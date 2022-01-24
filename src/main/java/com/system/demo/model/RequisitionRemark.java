/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.system.demo.model;

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
@Table(name = "requisition_remark")
@NamedQueries({
    @NamedQuery(name = "RequisitionRemark.findAll", query = "SELECT r FROM RequisitionRemark r"),
    @NamedQuery(name = "RequisitionRemark.findByRequisitionRemarkId", query = "SELECT r FROM RequisitionRemark r WHERE r.requisitionRemarkId = :requisitionRemarkId"),
    @NamedQuery(name = "RequisitionRemark.findByRequisitionRemarkIndex", query = "SELECT r FROM RequisitionRemark r WHERE r.requisitionRemarkIndex = :requisitionRemarkIndex"),
    @NamedQuery(name = "RequisitionRemark.findByRequisitionRemarkContent", query = "SELECT r FROM RequisitionRemark r WHERE r.requisitionRemarkContent = :requisitionRemarkContent"),
    @NamedQuery(name = "RequisitionRemark.findByRequisitionRemarkDate", query = "SELECT r FROM RequisitionRemark r WHERE r.requisitionRemarkDate = :requisitionRemarkDate")})
public class RequisitionRemark implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "requisition_remark_id", nullable = false)
    private Long requisitionRemarkId;
    @Basic(optional = false)
    @Column(name = "requisition_remark_index", nullable = false)
    private int requisitionRemarkIndex;
    @Basic(optional = false)
    @Column(name = "requisition_remark_content", nullable = false, length = 256)
    private String requisitionRemarkContent;
    @Basic(optional = false)
    @Column(name = "requisition_remark_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date requisitionRemarkDate;
    @JoinColumn(name = "person_id", referencedColumnName = "person_id", nullable = false)
    @ManyToOne(optional = false)
    private Person personId;
    @JoinColumn(name = "requisition_detail_id", referencedColumnName = "requisition_detail_id", nullable = false)
    @ManyToOne(optional = false)
    private RequisitionDetail requisitionDetailId;

    public RequisitionRemark() {
    }

    public RequisitionRemark(Long requisitionRemarkId) {
        this.requisitionRemarkId = requisitionRemarkId;
    }

    public RequisitionRemark(Long requisitionRemarkId, int requisitionRemarkIndex, String requisitionRemarkContent, Date requisitionRemarkDate) {
        this.requisitionRemarkId = requisitionRemarkId;
        this.requisitionRemarkIndex = requisitionRemarkIndex;
        this.requisitionRemarkContent = requisitionRemarkContent;
        this.requisitionRemarkDate = requisitionRemarkDate;
    }

    public Long getRequisitionRemarkId() {
        return requisitionRemarkId;
    }

    public void setRequisitionRemarkId(Long requisitionRemarkId) {
        this.requisitionRemarkId = requisitionRemarkId;
    }

    public int getRequisitionRemarkIndex() {
        return requisitionRemarkIndex;
    }

    public void setRequisitionRemarkIndex(int requisitionRemarkIndex) {
        this.requisitionRemarkIndex = requisitionRemarkIndex;
    }

    public String getRequisitionRemarkContent() {
        return requisitionRemarkContent;
    }

    public void setRequisitionRemarkContent(String requisitionRemarkContent) {
        this.requisitionRemarkContent = requisitionRemarkContent;
    }

    public Date getRequisitionRemarkDate() {
        return requisitionRemarkDate;
    }

    public void setRequisitionRemarkDate(Date requisitionRemarkDate) {
        this.requisitionRemarkDate = requisitionRemarkDate;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (requisitionRemarkId != null ? requisitionRemarkId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RequisitionRemark)) {
            return false;
        }
        RequisitionRemark other = (RequisitionRemark) object;
        if ((this.requisitionRemarkId == null && other.requisitionRemarkId != null) || (this.requisitionRemarkId != null && !this.requisitionRemarkId.equals(other.requisitionRemarkId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.system.demo.model.RequisitionRemark[ requisitionRemarkId=" + requisitionRemarkId + " ]";
    }
    
}
