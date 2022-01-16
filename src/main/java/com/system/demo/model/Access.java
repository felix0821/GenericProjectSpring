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
import javax.persistence.FetchType;
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
@Table(name = "access")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Access.findAll", query = "SELECT a FROM Access a"),
    @NamedQuery(name = "Access.findByIdRole", query = "SELECT a FROM Access a WHERE a.accessPK.idRole = :idRole"),
    @NamedQuery(name = "Access.findByIdResource", query = "SELECT a FROM Access a WHERE a.accessPK.idResource = :idResource"),
    @NamedQuery(name = "Access.findByState", query = "SELECT a FROM Access a WHERE a.state = :state")})
public class Access implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AccessPK accessPK;
    @Basic(optional = false)
    @Column(name = "state")
    private Character state;
    @JoinColumn(name = "id_resource", referencedColumnName = "id_resource", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Resource resource;
    @JoinColumn(name = "id_role", referencedColumnName = "id_role", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Role role;

    public Access() {
    }

    public Access(AccessPK accessPK) {
        this.accessPK = accessPK;
    }

    public Access(AccessPK accessPK, Character state) {
        this.accessPK = accessPK;
        this.state = state;
    }

    public Access(long idRole, long idResource) {
        this.accessPK = new AccessPK(idRole, idResource);
    }

    public AccessPK getAccessPK() {
        return accessPK;
    }

    public void setAccessPK(AccessPK accessPK) {
        this.accessPK = accessPK;
    }

    public Character getState() {
        return state;
    }

    public void setState(Character state) {
        this.state = state;
    }

    public Resource getResource() {
        return resource;
    }

    public void setResource(Resource resource) {
        this.resource = resource;
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
        hash += (accessPK != null ? accessPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Access)) {
            return false;
        }
        Access other = (Access) object;
        if ((this.accessPK == null && other.accessPK != null) || (this.accessPK != null && !this.accessPK.equals(other.accessPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "system.Access[ accessPK=" + accessPK + " ]";
    }
    
}
