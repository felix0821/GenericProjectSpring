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
public class AccessPK implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = -2419963967840252135L;
	@Basic(optional = false)
    @Column(name = "id_role")
    private long idRole;
    @Basic(optional = false)
    @Column(name = "id_resource")
    private long idResource;

    public AccessPK() {
    }

    public AccessPK(long idRole, long idResource) {
        this.idRole = idRole;
        this.idResource = idResource;
    }

    public long getIdRole() {
        return idRole;
    }

    public void setIdRole(long idRole) {
        this.idRole = idRole;
    }

    public long getIdResource() {
        return idResource;
    }

    public void setIdResource(long idResource) {
        this.idResource = idResource;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idRole;
        hash += (int) idResource;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AccessPK)) {
            return false;
        }
        AccessPK other = (AccessPK) object;
        if (this.idRole != other.idRole) {
            return false;
        }
        if (this.idResource != other.idResource) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "system.AccessPK[ idRole=" + idRole + ", idResource=" + idResource + " ]";
    }
    
}
