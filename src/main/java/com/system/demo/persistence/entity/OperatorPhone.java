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
@Table(name = "operator_phone", catalog = "ucps_system", schema = "public")
@NamedQueries({
    @NamedQuery(name = "OperatorPhone.findAll", query = "SELECT o FROM OperatorPhone o"),
    @NamedQuery(name = "OperatorPhone.findByPhoneOperatorId", query = "SELECT o FROM OperatorPhone o WHERE o.phoneOperatorId = :phoneOperatorId"),
    @NamedQuery(name = "OperatorPhone.findByOperatorPhoneName", query = "SELECT o FROM OperatorPhone o WHERE o.operatorPhoneName = :operatorPhoneName"),
    @NamedQuery(name = "OperatorPhone.findByOperatorPhoneLogo", query = "SELECT o FROM OperatorPhone o WHERE o.operatorPhoneLogo = :operatorPhoneLogo"),
    @NamedQuery(name = "OperatorPhone.findByOperatorPhoneState", query = "SELECT o FROM OperatorPhone o WHERE o.operatorPhoneState = :operatorPhoneState")})
public class OperatorPhone implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "phone_operator_id")
    private String phoneOperatorId;
    @Basic(optional = false)
    @Column(name = "operator_phone_name")
    private String operatorPhoneName;
    @Column(name = "operator_phone_logo")
    private String operatorPhoneLogo;
    @Basic(optional = false)
    @Column(name = "operator_phone_state")
    private Character operatorPhoneState;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "phoneOperatorId")
    private Collection<PersonPhone> personPhoneCollection;

    public OperatorPhone() {
    }

    public OperatorPhone(String phoneOperatorId) {
        this.phoneOperatorId = phoneOperatorId;
    }

    public OperatorPhone(String phoneOperatorId, String operatorPhoneName, Character operatorPhoneState) {
        this.phoneOperatorId = phoneOperatorId;
        this.operatorPhoneName = operatorPhoneName;
        this.operatorPhoneState = operatorPhoneState;
    }

    public String getPhoneOperatorId() {
        return phoneOperatorId;
    }

    public void setPhoneOperatorId(String phoneOperatorId) {
        this.phoneOperatorId = phoneOperatorId;
    }

    public String getOperatorPhoneName() {
        return operatorPhoneName;
    }

    public void setOperatorPhoneName(String operatorPhoneName) {
        this.operatorPhoneName = operatorPhoneName;
    }

    public String getOperatorPhoneLogo() {
        return operatorPhoneLogo;
    }

    public void setOperatorPhoneLogo(String operatorPhoneLogo) {
        this.operatorPhoneLogo = operatorPhoneLogo;
    }

    public Character getOperatorPhoneState() {
        return operatorPhoneState;
    }

    public void setOperatorPhoneState(Character operatorPhoneState) {
        this.operatorPhoneState = operatorPhoneState;
    }

    public Collection<PersonPhone> getPersonPhoneCollection() {
        return personPhoneCollection;
    }

    public void setPersonPhoneCollection(Collection<PersonPhone> personPhoneCollection) {
        this.personPhoneCollection = personPhoneCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (phoneOperatorId != null ? phoneOperatorId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OperatorPhone)) {
            return false;
        }
        OperatorPhone other = (OperatorPhone) object;
        if ((this.phoneOperatorId == null && other.phoneOperatorId != null) || (this.phoneOperatorId != null && !this.phoneOperatorId.equals(other.phoneOperatorId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.system.demo.persistence.entity.OperatorPhone[ phoneOperatorId=" + phoneOperatorId + " ]";
    }
    
}
