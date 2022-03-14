/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.system.demo.persistence.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "person_phone", catalog = "ucps_system", schema = "public")
@NamedQueries({
    @NamedQuery(name = "PersonPhone.findAll", query = "SELECT p FROM PersonPhone p"),
    @NamedQuery(name = "PersonPhone.findByPersonPhoneId", query = "SELECT p FROM PersonPhone p WHERE p.personPhoneId = :personPhoneId"),
    @NamedQuery(name = "PersonPhone.findByPersonPhoneNumber", query = "SELECT p FROM PersonPhone p WHERE p.personPhoneNumber = :personPhoneNumber"),
    @NamedQuery(name = "PersonPhone.findByPersonPhoneCode", query = "SELECT p FROM PersonPhone p WHERE p.personPhoneCode = :personPhoneCode")})
public class PersonPhone implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "person_phone_id")
    private Long personPhoneId;
    @Basic(optional = false)
    @Column(name = "person_phone_number")
    private int personPhoneNumber;
    @Column(name = "person_phone_code")
    private String personPhoneCode;
    @JoinColumn(name = "phone_operator_id", referencedColumnName = "phone_operator_id")
    @ManyToOne(optional = false)
    private OperatorPhone phoneOperatorId;
    @JoinColumn(name = "person_id", referencedColumnName = "person_id")
    @ManyToOne(optional = false)
    private Person personId;

    public PersonPhone() {
    }

    public PersonPhone(Long personPhoneId) {
        this.personPhoneId = personPhoneId;
    }

    public PersonPhone(Long personPhoneId, int personPhoneNumber) {
        this.personPhoneId = personPhoneId;
        this.personPhoneNumber = personPhoneNumber;
    }

    public Long getPersonPhoneId() {
        return personPhoneId;
    }

    public void setPersonPhoneId(Long personPhoneId) {
        this.personPhoneId = personPhoneId;
    }

    public int getPersonPhoneNumber() {
        return personPhoneNumber;
    }

    public void setPersonPhoneNumber(int personPhoneNumber) {
        this.personPhoneNumber = personPhoneNumber;
    }

    public String getPersonPhoneCode() {
        return personPhoneCode;
    }

    public void setPersonPhoneCode(String personPhoneCode) {
        this.personPhoneCode = personPhoneCode;
    }

    public OperatorPhone getPhoneOperatorId() {
        return phoneOperatorId;
    }

    public void setPhoneOperatorId(OperatorPhone phoneOperatorId) {
        this.phoneOperatorId = phoneOperatorId;
    }

    public Person getPersonId() {
        return personId;
    }

    public void setPersonId(Person personId) {
        this.personId = personId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (personPhoneId != null ? personPhoneId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PersonPhone)) {
            return false;
        }
        PersonPhone other = (PersonPhone) object;
        if ((this.personPhoneId == null && other.personPhoneId != null) || (this.personPhoneId != null && !this.personPhoneId.equals(other.personPhoneId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.system.demo.persistence.entity.PersonPhone[ personPhoneId=" + personPhoneId + " ]";
    }
    
}
