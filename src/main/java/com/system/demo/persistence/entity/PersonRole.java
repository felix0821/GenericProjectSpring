/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.system.demo.persistence.entity;

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
@Table(name = "person_role")
@NamedQueries({
    @NamedQuery(name = "PersonRole.findAll", query = "SELECT p FROM PersonRole p"),
    @NamedQuery(name = "PersonRole.findByPersonId", query = "SELECT p FROM PersonRole p WHERE p.personRolePK.personId = :personId"),
    @NamedQuery(name = "PersonRole.findByRoleId", query = "SELECT p FROM PersonRole p WHERE p.personRolePK.roleId = :roleId"),
    @NamedQuery(name = "PersonRole.findByPersonRoleState", query = "SELECT p FROM PersonRole p WHERE p.personRoleState = :personRoleState")})
public class PersonRole implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PersonRolePK personRolePK;
    @Basic(optional = false)
    @Column(name = "person_role_state", nullable = false)
    private Character personRoleState;
    @JoinColumn(name = "person_id", referencedColumnName = "person_id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Person person;
    @JoinColumn(name = "role_id", referencedColumnName = "role_id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Role role;

    public PersonRole() {
    }

    public PersonRole(PersonRolePK personRolePK) {
        this.personRolePK = personRolePK;
    }

    public PersonRole(PersonRolePK personRolePK, Character personRoleState) {
        this.personRolePK = personRolePK;
        this.personRoleState = personRoleState;
    }

    public PersonRole(long personId, long roleId) {
        this.personRolePK = new PersonRolePK(personId, roleId);
    }

    public PersonRolePK getPersonRolePK() {
        return personRolePK;
    }

    public void setPersonRolePK(PersonRolePK personRolePK) {
        this.personRolePK = personRolePK;
    }

    public Character getPersonRoleState() {
        return personRoleState;
    }

    public void setPersonRoleState(Character personRoleState) {
        this.personRoleState = personRoleState;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
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
        hash += (personRolePK != null ? personRolePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PersonRole)) {
            return false;
        }
        PersonRole other = (PersonRole) object;
        if ((this.personRolePK == null && other.personRolePK != null) || (this.personRolePK != null && !this.personRolePK.equals(other.personRolePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.system.demo.persistence.entity.PersonRole[ personRolePK=" + personRolePK + " ]";
    }
    
}
