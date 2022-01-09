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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Felix
 */
@Entity
@Table(name = "person_rol")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PersonRol.findAll", query = "SELECT u FROM PersonRol u"),
    @NamedQuery(name = "PersonRol.findByIdPerson", query = "SELECT u FROM PersonRol u WHERE u.personRolPK.idPerson = :idPerson"),
    @NamedQuery(name = "PersonRol.findByIdRole", query = "SELECT u FROM PersonRol u WHERE u.personRolPK.idRole = :idRole"),
    @NamedQuery(name = "PersonRol.findByState", query = "SELECT u FROM PersonRol u WHERE u.state = :state")})
public class PersonRol implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PersonRolPK personRolPK;
    @Basic(optional = false)
    @Column(name = "state")
    private Character state;
    @JoinColumn(name = "id_role", referencedColumnName = "id_role", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Role role;
    @JoinColumn(name = "id_person", referencedColumnName = "id_person", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Person person;

    public PersonRol() {
    }

    public PersonRol(PersonRolPK personRolPK) {
        this.personRolPK = personRolPK;
    }

    public PersonRol(PersonRolPK personRolPK, Character state) {
        this.personRolPK = personRolPK;
        this.state = state;
    }

    public PersonRol(long idUser, long idRole) {
        this.personRolPK = new PersonRolPK(idUser, idRole);
    }

    public PersonRolPK getPersonRolPK() {
        return personRolPK;
    }

    public void setPersonRolPK(PersonRolPK personRolPK) {
        this.personRolPK = personRolPK;
    }

    public Character getState() {
        return state;
    }

    public void setState(Character state) {
        this.state = state;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Person getUser() {
        return person;
    }

    public void setUser(Person person) {
        this.person = person;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (personRolPK != null ? personRolPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PersonRol)) {
            return false;
        }
        PersonRol other = (PersonRol) object;
        if ((this.personRolPK == null && other.personRolPK != null) || (this.personRolPK != null && !this.personRolPK.equals(other.personRolPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "vacancies_application_system.UserRol[ userRolPK=" + personRolPK + " ]";
    }
    
}
