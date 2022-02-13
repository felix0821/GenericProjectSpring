/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.system.demo.persistence.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
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
@Table(name = "interest_arrears")
@NamedQueries({
    @NamedQuery(name = "InterestArrears.findAll", query = "SELECT i FROM InterestArrears i"),
    @NamedQuery(name = "InterestArrears.findByInterestArrearsId", query = "SELECT i FROM InterestArrears i WHERE i.interestArrearsId = :interestArrearsId"),
    @NamedQuery(name = "InterestArrears.findByInterestArrearsName", query = "SELECT i FROM InterestArrears i WHERE i.interestArrearsName = :interestArrearsName"),
    @NamedQuery(name = "InterestArrears.findByInterestArrearsValue", query = "SELECT i FROM InterestArrears i WHERE i.interestArrearsValue = :interestArrearsValue"),
    @NamedQuery(name = "InterestArrears.findByInterestArrearsState", query = "SELECT i FROM InterestArrears i WHERE i.interestArrearsState = :interestArrearsState")})
public class InterestArrears implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "interest_arrears_id", nullable = false)
    private Long interestArrearsId;
    @Basic(optional = false)
    @Column(name = "interest_arrears_name", nullable = false, length = 64)
    private String interestArrearsName;
    @Basic(optional = false)
    @Column(name = "interest_arrears_value", nullable = false)
    private double interestArrearsValue;
    @Basic(optional = false)
    @Column(name = "interest_arrears_state", nullable = false)
    private Character interestArrearsState;
    @OneToMany(mappedBy = "interestArrearsId")
    private Collection<PedagogicalSchedulePayment> pedagogicalSchedulePaymentCollection;
    @OneToMany(mappedBy = "interestArrearsId")
    private Collection<ModulusDetail> modulusDetailCollection;

    public InterestArrears() {
    }

    public InterestArrears(Long interestArrearsId) {
        this.interestArrearsId = interestArrearsId;
    }

    public InterestArrears(Long interestArrearsId, String interestArrearsName, double interestArrearsValue, Character interestArrearsState) {
        this.interestArrearsId = interestArrearsId;
        this.interestArrearsName = interestArrearsName;
        this.interestArrearsValue = interestArrearsValue;
        this.interestArrearsState = interestArrearsState;
    }

    public Long getInterestArrearsId() {
        return interestArrearsId;
    }

    public void setInterestArrearsId(Long interestArrearsId) {
        this.interestArrearsId = interestArrearsId;
    }

    public String getInterestArrearsName() {
        return interestArrearsName;
    }

    public void setInterestArrearsName(String interestArrearsName) {
        this.interestArrearsName = interestArrearsName;
    }

    public double getInterestArrearsValue() {
        return interestArrearsValue;
    }

    public void setInterestArrearsValue(double interestArrearsValue) {
        this.interestArrearsValue = interestArrearsValue;
    }

    public Character getInterestArrearsState() {
        return interestArrearsState;
    }

    public void setInterestArrearsState(Character interestArrearsState) {
        this.interestArrearsState = interestArrearsState;
    }

    public Collection<PedagogicalSchedulePayment> getPedagogicalSchedulePaymentCollection() {
        return pedagogicalSchedulePaymentCollection;
    }

    public void setPedagogicalSchedulePaymentCollection(Collection<PedagogicalSchedulePayment> pedagogicalSchedulePaymentCollection) {
        this.pedagogicalSchedulePaymentCollection = pedagogicalSchedulePaymentCollection;
    }

    public Collection<ModulusDetail> getModulusDetailCollection() {
        return modulusDetailCollection;
    }

    public void setModulusDetailCollection(Collection<ModulusDetail> modulusDetailCollection) {
        this.modulusDetailCollection = modulusDetailCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (interestArrearsId != null ? interestArrearsId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InterestArrears)) {
            return false;
        }
        InterestArrears other = (InterestArrears) object;
        if ((this.interestArrearsId == null && other.interestArrearsId != null) || (this.interestArrearsId != null && !this.interestArrearsId.equals(other.interestArrearsId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.system.demo.persistence.entity.InterestArrears[ interestArrearsId=" + interestArrearsId + " ]";
    }
    
}
