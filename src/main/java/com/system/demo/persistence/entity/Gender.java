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
@Table(name = "gender")
@NamedQueries({
    @NamedQuery(name = "Gender.findAll", query = "SELECT g FROM Gender g"),
    @NamedQuery(name = "Gender.findByGenderId", query = "SELECT g FROM Gender g WHERE g.genderId = :genderId"),
    @NamedQuery(name = "Gender.findByGenderName", query = "SELECT g FROM Gender g WHERE g.genderName = :genderName"),
    @NamedQuery(name = "Gender.findByGenderState", query = "SELECT g FROM Gender g WHERE g.genderState = :genderState")})
public class Gender implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "gender_id", nullable = false, length = 1)
    private String genderId;
    @Basic(optional = false)
    @Column(name = "gender_name", nullable = false, length = 64)
    private String genderName;
    @Basic(optional = false)
    @Column(name = "gender_state", nullable = false)
    private Character genderState;
    @OneToMany(mappedBy = "genderId")
    private Collection<Person> personCollection;

    public Gender() {
    }

    public Gender(String genderId) {
        this.genderId = genderId;
    }

    public Gender(String genderId, String genderName, Character genderState) {
        this.genderId = genderId;
        this.genderName = genderName;
        this.genderState = genderState;
    }

    public String getGenderId() {
        return genderId;
    }

    public void setGenderId(String genderId) {
        this.genderId = genderId;
    }

    public String getGenderName() {
        return genderName;
    }

    public void setGenderName(String genderName) {
        this.genderName = genderName;
    }

    public Character getGenderState() {
        return genderState;
    }

    public void setGenderState(Character genderState) {
        this.genderState = genderState;
    }

    public Collection<Person> getPersonCollection() {
        return personCollection;
    }

    public void setPersonCollection(Collection<Person> personCollection) {
        this.personCollection = personCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (genderId != null ? genderId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Gender)) {
            return false;
        }
        Gender other = (Gender) object;
        if ((this.genderId == null && other.genderId != null) || (this.genderId != null && !this.genderId.equals(other.genderId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.system.demo.persistence.entity.Gender[ genderId=" + genderId + " ]";
    }
    
}
