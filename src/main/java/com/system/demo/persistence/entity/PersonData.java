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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Felix
 */
@Entity
@Table(name = "person_data")
@NamedQueries({
    @NamedQuery(name = "PersonData.findAll", query = "SELECT p FROM PersonData p"),
    @NamedQuery(name = "PersonData.findByDataId", query = "SELECT p FROM PersonData p WHERE p.personDataPK.dataId = :dataId"),
    @NamedQuery(name = "PersonData.findByRoleId", query = "SELECT p FROM PersonData p WHERE p.personDataPK.roleId = :roleId"),
    @NamedQuery(name = "PersonData.findByPersonDataIndex", query = "SELECT p FROM PersonData p WHERE p.personDataIndex = :personDataIndex"),
    @NamedQuery(name = "PersonData.findByPersonDataState", query = "SELECT p FROM PersonData p WHERE p.personDataState = :personDataState")})
public class PersonData implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PersonDataPK personDataPK;
    @Basic(optional = false)
    @Column(name = "person_data_index", nullable = false)
    private int personDataIndex;
    @Basic(optional = false)
    @Column(name = "person_data_state", nullable = false)
    private Character personDataState;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "personData")
    private Collection<PersonDataDetail> personDataDetailCollection;
    @JoinColumn(name = "data_id", referencedColumnName = "data_id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Data data;
    @JoinColumn(name = "role_id", referencedColumnName = "role_id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Role role;

    public PersonData() {
    }

    public PersonData(PersonDataPK personDataPK) {
        this.personDataPK = personDataPK;
    }

    public PersonData(PersonDataPK personDataPK, int personDataIndex, Character personDataState) {
        this.personDataPK = personDataPK;
        this.personDataIndex = personDataIndex;
        this.personDataState = personDataState;
    }

    public PersonData(long dataId, long roleId) {
        this.personDataPK = new PersonDataPK(dataId, roleId);
    }

    public PersonDataPK getPersonDataPK() {
        return personDataPK;
    }

    public void setPersonDataPK(PersonDataPK personDataPK) {
        this.personDataPK = personDataPK;
    }

    public int getPersonDataIndex() {
        return personDataIndex;
    }

    public void setPersonDataIndex(int personDataIndex) {
        this.personDataIndex = personDataIndex;
    }

    public Character getPersonDataState() {
        return personDataState;
    }

    public void setPersonDataState(Character personDataState) {
        this.personDataState = personDataState;
    }

    public Collection<PersonDataDetail> getPersonDataDetailCollection() {
        return personDataDetailCollection;
    }

    public void setPersonDataDetailCollection(Collection<PersonDataDetail> personDataDetailCollection) {
        this.personDataDetailCollection = personDataDetailCollection;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (personDataPK != null ? personDataPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PersonData)) {
            return false;
        }
        PersonData other = (PersonData) object;
        if ((this.personDataPK == null && other.personDataPK != null) || (this.personDataPK != null && !this.personDataPK.equals(other.personDataPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.system.demo.persistence.entity.PersonData[ personDataPK=" + personDataPK + " ]";
    }
    
}
