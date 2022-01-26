/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.system.demo.model;

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
@Table(name = "requisition_detail_person")
@NamedQueries({
    @NamedQuery(name = "RequisitionDetailPerson.findAll", query = "SELECT r FROM RequisitionDetailPerson r"),
    @NamedQuery(name = "RequisitionDetailPerson.findByRequisitionDetailId", query = "SELECT r FROM RequisitionDetailPerson r WHERE r.requisitionDetailPersonPK.requisitionDetailId = :requisitionDetailId"),
    @NamedQuery(name = "RequisitionDetailPerson.findByPersonId", query = "SELECT r FROM RequisitionDetailPerson r WHERE r.requisitionDetailPersonPK.personId = :personId"),
    @NamedQuery(name = "RequisitionDetailPerson.findByRequisitionDetailPersonState", query = "SELECT r FROM RequisitionDetailPerson r WHERE r.requisitionDetailPersonState = :requisitionDetailPersonState")})
public class RequisitionDetailPerson implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected RequisitionDetailPersonPK requisitionDetailPersonPK;
    @Basic(optional = false)
    @Column(name = "requisition_detail_person_state", nullable = false)
    private Character requisitionDetailPersonState;
    @JoinColumn(name = "person_id", referencedColumnName = "person_id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Person person;
    @JoinColumn(name = "requisition_detail_id", referencedColumnName = "requisition_detail_id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private RequisitionDetail requisitionDetail;

    public RequisitionDetailPerson() {
    }

    public RequisitionDetailPerson(RequisitionDetailPersonPK requisitionDetailPersonPK) {
        this.requisitionDetailPersonPK = requisitionDetailPersonPK;
    }

    public RequisitionDetailPerson(RequisitionDetailPersonPK requisitionDetailPersonPK, Character requisitionDetailPersonState) {
        this.requisitionDetailPersonPK = requisitionDetailPersonPK;
        this.requisitionDetailPersonState = requisitionDetailPersonState;
    }

    public RequisitionDetailPerson(long requisitionDetailId, long personId) {
        this.requisitionDetailPersonPK = new RequisitionDetailPersonPK(requisitionDetailId, personId);
    }

    public RequisitionDetailPersonPK getRequisitionDetailPersonPK() {
        return requisitionDetailPersonPK;
    }

    public void setRequisitionDetailPersonPK(RequisitionDetailPersonPK requisitionDetailPersonPK) {
        this.requisitionDetailPersonPK = requisitionDetailPersonPK;
    }

    public Character getRequisitionDetailPersonState() {
        return requisitionDetailPersonState;
    }

    public void setRequisitionDetailPersonState(Character requisitionDetailPersonState) {
        this.requisitionDetailPersonState = requisitionDetailPersonState;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public RequisitionDetail getRequisitionDetail() {
        return requisitionDetail;
    }

    public void setRequisitionDetail(RequisitionDetail requisitionDetail) {
        this.requisitionDetail = requisitionDetail;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (requisitionDetailPersonPK != null ? requisitionDetailPersonPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RequisitionDetailPerson)) {
            return false;
        }
        RequisitionDetailPerson other = (RequisitionDetailPerson) object;
        if ((this.requisitionDetailPersonPK == null && other.requisitionDetailPersonPK != null) || (this.requisitionDetailPersonPK != null && !this.requisitionDetailPersonPK.equals(other.requisitionDetailPersonPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.system.demo.model.RequisitionDetailPerson[ requisitionDetailPersonPK=" + requisitionDetailPersonPK + " ]";
    }
    
}
