/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.system.demo.persistence.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Felix
 */
@Entity
@Table(name = "person_data_detail", catalog = "ucps_system", schema = "public")
@NamedQueries({
    @NamedQuery(name = "PersonDataDetail.findAll", query = "SELECT p FROM PersonDataDetail p"),
    @NamedQuery(name = "PersonDataDetail.findByDataId", query = "SELECT p FROM PersonDataDetail p WHERE p.personDataDetailPK.dataId = :dataId"),
    @NamedQuery(name = "PersonDataDetail.findByRoleId", query = "SELECT p FROM PersonDataDetail p WHERE p.personDataDetailPK.roleId = :roleId"),
    @NamedQuery(name = "PersonDataDetail.findByPersonId", query = "SELECT p FROM PersonDataDetail p WHERE p.personDataDetailPK.personId = :personId"),
    @NamedQuery(name = "PersonDataDetail.findByUserDataDetailValue", query = "SELECT p FROM PersonDataDetail p WHERE p.userDataDetailValue = :userDataDetailValue")})
public class PersonDataDetail implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PersonDataDetailPK personDataDetailPK;
    @Column(name = "user_data_detail_value")
    private String userDataDetailValue;
    @JoinColumn(name = "person_id", referencedColumnName = "person_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Person person;
    @JoinColumns({
        @JoinColumn(name = "data_id", referencedColumnName = "data_id", insertable = false, updatable = false),
        @JoinColumn(name = "role_id", referencedColumnName = "role_id", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private PersonData personData;

    public PersonDataDetail() {
    }

    public PersonDataDetail(PersonDataDetailPK personDataDetailPK) {
        this.personDataDetailPK = personDataDetailPK;
    }

    public PersonDataDetail(long dataId, long roleId, long personId) {
        this.personDataDetailPK = new PersonDataDetailPK(dataId, roleId, personId);
    }

    public PersonDataDetailPK getPersonDataDetailPK() {
        return personDataDetailPK;
    }

    public void setPersonDataDetailPK(PersonDataDetailPK personDataDetailPK) {
        this.personDataDetailPK = personDataDetailPK;
    }

    public String getUserDataDetailValue() {
        return userDataDetailValue;
    }

    public void setUserDataDetailValue(String userDataDetailValue) {
        this.userDataDetailValue = userDataDetailValue;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public PersonData getPersonData() {
        return personData;
    }

    public void setPersonData(PersonData personData) {
        this.personData = personData;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (personDataDetailPK != null ? personDataDetailPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PersonDataDetail)) {
            return false;
        }
        PersonDataDetail other = (PersonDataDetail) object;
        if ((this.personDataDetailPK == null && other.personDataDetailPK != null) || (this.personDataDetailPK != null && !this.personDataDetailPK.equals(other.personDataDetailPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.system.demo.persistence.entity.PersonDataDetail[ personDataDetailPK=" + personDataDetailPK + " ]";
    }
    
}
