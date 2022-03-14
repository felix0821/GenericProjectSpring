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
@Table(name = "requisition_remark", catalog = "ucps_system", schema = "public")
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
    @Column(name = "requisition_remark_id")
    private Long requisitionRemarkId;
    @Column(name = "requisition_remark_index")
    private Integer requisitionRemarkIndex;
    @Basic(optional = false)
    @Column(name = "requisition_remark_content")
    private String requisitionRemarkContent;
    @Basic(optional = false)
    @Column(name = "requisition_remark_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date requisitionRemarkDate;
    @JoinColumn(name = "person_id", referencedColumnName = "person_id")
    @ManyToOne(optional = false)
    private Person personId;
    @JoinColumn(name = "requisition_reference_id", referencedColumnName = "requisition_id")
    @ManyToOne
    private Requisition requisitionReferenceId;
    @JoinColumn(name = "requisition_detail_id", referencedColumnName = "requisition_detail_id")
    @ManyToOne(optional = false)
    private RequisitionDetail requisitionDetailId;

    public RequisitionRemark() {
    }

    public RequisitionRemark(Long requisitionRemarkId) {
        this.requisitionRemarkId = requisitionRemarkId;
    }

    public RequisitionRemark(Long requisitionRemarkId, String requisitionRemarkContent, Date requisitionRemarkDate) {
        this.requisitionRemarkId = requisitionRemarkId;
        this.requisitionRemarkContent = requisitionRemarkContent;
        this.requisitionRemarkDate = requisitionRemarkDate;
    }

    public Long getRequisitionRemarkId() {
        return requisitionRemarkId;
    }

    public void setRequisitionRemarkId(Long requisitionRemarkId) {
        this.requisitionRemarkId = requisitionRemarkId;
    }

    public Integer getRequisitionRemarkIndex() {
        return requisitionRemarkIndex;
    }

    public void setRequisitionRemarkIndex(Integer requisitionRemarkIndex) {
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

    public Requisition getRequisitionReferenceId() {
        return requisitionReferenceId;
    }

    public void setRequisitionReferenceId(Requisition requisitionReferenceId) {
        this.requisitionReferenceId = requisitionReferenceId;
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
        return "com.system.demo.persistence.entity.RequisitionRemark[ requisitionRemarkId=" + requisitionRemarkId + " ]";
    }
    
}
