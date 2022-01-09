/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.system.demo.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Felix
 */
@Embeddable
public class PersonRolPK implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = -6082938809894718774L;
	@Basic(optional = false)
    @Column(name = "id_person")
    private long idPerson;
    @Basic(optional = false)
    @Column(name = "id_role")
    private long idRole;

    public PersonRolPK() {
    }

    public PersonRolPK(long idUser, long idRole) {
        this.idPerson = idUser;
        this.idRole = idRole;
    }

    public long getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(long idUser) {
        this.idPerson = idUser;
    }

    public long getIdRole() {
        return idRole;
    }

    public void setIdRole(long idRole) {
        this.idRole = idRole;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idPerson;
        hash += (int) idRole;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PersonRolPK)) {
            return false;
        }
        PersonRolPK other = (PersonRolPK) object;
        if (this.idPerson != other.idPerson) {
            return false;
        }
        if (this.idRole != other.idRole) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "system.UserRolPK[ idPerson=" + idPerson + ", idRole=" + idRole + " ]";
    }
    
}
