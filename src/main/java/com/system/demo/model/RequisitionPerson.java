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
@Table(name = "requisition_person")
@NamedQueries({
    @NamedQuery(name = "RequisitionPerson.findAll", query = "SELECT r FROM RequisitionPerson r"),
    @NamedQuery(name = "RequisitionPerson.findByRequisitionDetailId", query = "SELECT r FROM RequisitionPerson r WHERE r.requisitionPersonPK.requisitionDetailId = :requisitionDetailId"),
    @NamedQuery(name = "RequisitionPerson.findByPersonId", query = "SELECT r FROM RequisitionPerson r WHERE r.requisitionPersonPK.personId = :personId"),
    @NamedQuery(name = "RequisitionPerson.findByRequisitionPersonState", query = "SELECT r FROM RequisitionPerson r WHERE r.requisitionPersonState = :requisitionPersonState")})
public class RequisitionPerson implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected RequisitionPersonPK requisitionPersonPK;
    @Basic(optional = false)
    @Column(name = "requisition_person_state", nullable = false)
    private Character requisitionPersonState;
    @JoinColumn(name = "person_id", referencedColumnName = "person_id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Person person;
    @JoinColumn(name = "requisition_detail_id", referencedColumnName = "requisition_detail_id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private RequisitionDetail requisitionDetail;

    public RequisitionPerson() {
    }

    public RequisitionPerson(RequisitionPersonPK requisitionPersonPK) {
        this.requisitionPersonPK = requisitionPersonPK;
    }

    public RequisitionPerson(RequisitionPersonPK requisitionPersonPK, Character requisitionPersonState) {
        this.requisitionPersonPK = requisitionPersonPK;
        this.requisitionPersonState = requisitionPersonState;
    }

    public RequisitionPerson(long requisitionDetailId, long personId) {
        this.requisitionPersonPK = new RequisitionPersonPK(requisitionDetailId, personId);
    }

    public RequisitionPersonPK getRequisitionPersonPK() {
        return requisitionPersonPK;
    }

    public void setRequisitionPersonPK(RequisitionPersonPK requisitionPersonPK) {
        this.requisitionPersonPK = requisitionPersonPK;
    }

    public Character getRequisitionPersonState() {
        return requisitionPersonState;
    }

    public void setRequisitionPersonState(Character requisitionPersonState) {
        this.requisitionPersonState = requisitionPersonState;
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
        hash += (requisitionPersonPK != null ? requisitionPersonPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RequisitionPerson)) {
            return false;
        }
        RequisitionPerson other = (RequisitionPerson) object;
        if ((this.requisitionPersonPK == null && other.requisitionPersonPK != null) || (this.requisitionPersonPK != null && !this.requisitionPersonPK.equals(other.requisitionPersonPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.system.demo.model.RequisitionPerson[ requisitionPersonPK=" + requisitionPersonPK + " ]";
    }
    
}
