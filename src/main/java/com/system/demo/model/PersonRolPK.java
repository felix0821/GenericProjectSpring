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
    @Column(name = "id_user")
    private long idUser;
    @Basic(optional = false)
    @Column(name = "id_role")
    private long idRole;

    public PersonRolPK() {
    }

    public PersonRolPK(long idUser, long idRole) {
        this.idUser = idUser;
        this.idRole = idRole;
    }

    public long getIdUser() {
        return idUser;
    }

    public void setIdUser(long idUser) {
        this.idUser = idUser;
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
        hash += (int) idUser;
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
        if (this.idUser != other.idUser) {
            return false;
        }
        if (this.idRole != other.idRole) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "vacancies_application_system.UserRolPK[ idUser=" + idUser + ", idRole=" + idRole + " ]";
    }
    
}
