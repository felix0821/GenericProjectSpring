/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.system.demo.persistence.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Felix
 */
@Entity
@Table(name = "requisition_detail", catalog = "ucps_system", schema = "public")
@NamedQueries({
    @NamedQuery(name = "RequisitionDetail.findAll", query = "SELECT r FROM RequisitionDetail r"),
    @NamedQuery(name = "RequisitionDetail.findByRequisitionDetailId", query = "SELECT r FROM RequisitionDetail r WHERE r.requisitionDetailId = :requisitionDetailId"),
    @NamedQuery(name = "RequisitionDetail.findByRequisitionDetailChecking", query = "SELECT r FROM RequisitionDetail r WHERE r.requisitionDetailChecking = :requisitionDetailChecking"),
    @NamedQuery(name = "RequisitionDetail.findByRequisitionDetailDate", query = "SELECT r FROM RequisitionDetail r WHERE r.requisitionDetailDate = :requisitionDetailDate")})
public class RequisitionDetail implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "requisition_detail_id")
    private Long requisitionDetailId;
    @Basic(optional = false)
    @Column(name = "requisition_detail_checking")
    private boolean requisitionDetailChecking;
    @Basic(optional = false)
    @Column(name = "requisition_detail_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date requisitionDetailDate;
    @JoinColumn(name = "person_id", referencedColumnName = "person_id")
    @ManyToOne(optional = false)
    private Person personId;
    @JoinColumn(name = "requisition_id", referencedColumnName = "requisition_id")
    @ManyToOne(optional = false)
    private Requisition requisitionId;
    @OneToMany(mappedBy = "requisitionDetailReferenceId")
    private Collection<RequisitionDetail> requisitionDetailCollection;
    @JoinColumn(name = "requisition_detail_reference_id", referencedColumnName = "requisition_detail_id")
    @ManyToOne
    private RequisitionDetail requisitionDetailReferenceId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "requisitionDetailId")
    private Collection<RequisitionRemark> requisitionRemarkCollection;
    @OneToMany(mappedBy = "requisitionDetailId")
    private Collection<EnrollmentProgram> enrollmentProgramCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "requisitionDetail")
    private Collection<RequisitionDataDetail> requisitionDataDetailCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "requisitionDetail")
    private Collection<FinancialRequisition> financialRequisitionCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "requisitionDetail")
    private Collection<RequisitionStatusDetail> requisitionStatusDetailCollection;

    public RequisitionDetail() {
    }

    public RequisitionDetail(Long requisitionDetailId) {
        this.requisitionDetailId = requisitionDetailId;
    }

    public RequisitionDetail(Long requisitionDetailId, boolean requisitionDetailChecking, Date requisitionDetailDate) {
        this.requisitionDetailId = requisitionDetailId;
        this.requisitionDetailChecking = requisitionDetailChecking;
        this.requisitionDetailDate = requisitionDetailDate;
    }

    public Long getRequisitionDetailId() {
        return requisitionDetailId;
    }

    public void setRequisitionDetailId(Long requisitionDetailId) {
        this.requisitionDetailId = requisitionDetailId;
    }

    public boolean getRequisitionDetailChecking() {
        return requisitionDetailChecking;
    }

    public void setRequisitionDetailChecking(boolean requisitionDetailChecking) {
        this.requisitionDetailChecking = requisitionDetailChecking;
    }

    public Date getRequisitionDetailDate() {
        return requisitionDetailDate;
    }

    public void setRequisitionDetailDate(Date requisitionDetailDate) {
        this.requisitionDetailDate = requisitionDetailDate;
    }

    public Person getPersonId() {
        return personId;
    }

    public void setPersonId(Person personId) {
        this.personId = personId;
    }

    public Requisition getRequisitionId() {
        return requisitionId;
    }

    public void setRequisitionId(Requisition requisitionId) {
        this.requisitionId = requisitionId;
    }

    public Collection<RequisitionDetail> getRequisitionDetailCollection() {
        return requisitionDetailCollection;
    }

    public void setRequisitionDetailCollection(Collection<RequisitionDetail> requisitionDetailCollection) {
        this.requisitionDetailCollection = requisitionDetailCollection;
    }

    public RequisitionDetail getRequisitionDetailReferenceId() {
        return requisitionDetailReferenceId;
    }

    public void setRequisitionDetailReferenceId(RequisitionDetail requisitionDetailReferenceId) {
        this.requisitionDetailReferenceId = requisitionDetailReferenceId;
    }

    public Collection<RequisitionRemark> getRequisitionRemarkCollection() {
        return requisitionRemarkCollection;
    }

    public void setRequisitionRemarkCollection(Collection<RequisitionRemark> requisitionRemarkCollection) {
        this.requisitionRemarkCollection = requisitionRemarkCollection;
    }

    public Collection<EnrollmentProgram> getEnrollmentProgramCollection() {
        return enrollmentProgramCollection;
    }

    public void setEnrollmentProgramCollection(Collection<EnrollmentProgram> enrollmentProgramCollection) {
        this.enrollmentProgramCollection = enrollmentProgramCollection;
    }

    public Collection<RequisitionDataDetail> getRequisitionDataDetailCollection() {
        return requisitionDataDetailCollection;
    }

    public void setRequisitionDataDetailCollection(Collection<RequisitionDataDetail> requisitionDataDetailCollection) {
        this.requisitionDataDetailCollection = requisitionDataDetailCollection;
    }

    public Collection<FinancialRequisition> getFinancialRequisitionCollection() {
        return financialRequisitionCollection;
    }

    public void setFinancialRequisitionCollection(Collection<FinancialRequisition> financialRequisitionCollection) {
        this.financialRequisitionCollection = financialRequisitionCollection;
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
        hash += (requisitionDetailId != null ? requisitionDetailId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RequisitionDetail)) {
            return false;
        }
        RequisitionDetail other = (RequisitionDetail) object;
        if ((this.requisitionDetailId == null && other.requisitionDetailId != null) || (this.requisitionDetailId != null && !this.requisitionDetailId.equals(other.requisitionDetailId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.system.demo.persistence.entity.RequisitionDetail[ requisitionDetailId=" + requisitionDetailId + " ]";
    }
    
}
