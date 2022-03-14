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
@Table(name = "access", catalog = "ucps_system", schema = "public")
@NamedQueries({
    @NamedQuery(name = "Access.findAll", query = "SELECT a FROM Access a"),
    @NamedQuery(name = "Access.findByRoleId", query = "SELECT a FROM Access a WHERE a.accessPK.roleId = :roleId"),
    @NamedQuery(name = "Access.findByResourceId", query = "SELECT a FROM Access a WHERE a.accessPK.resourceId = :resourceId"),
    @NamedQuery(name = "Access.findByAccessState", query = "SELECT a FROM Access a WHERE a.accessState = :accessState")})
public class Access implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AccessPK accessPK;
    @Basic(optional = false)
    @Column(name = "access_state")
    private Character accessState;
    @JoinColumn(name = "resource_id", referencedColumnName = "resource_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Resource resource;
    @JoinColumn(name = "role_id", referencedColumnName = "role_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Role role;

    public Access() {
    }

    public Access(AccessPK accessPK) {
        this.accessPK = accessPK;
    }

    public Access(AccessPK accessPK, Character accessState) {
        this.accessPK = accessPK;
        this.accessState = accessState;
    }

    public Access(long roleId, long resourceId) {
        this.accessPK = new AccessPK(roleId, resourceId);
    }

    public AccessPK getAccessPK() {
        return accessPK;
    }

    public void setAccessPK(AccessPK accessPK) {
        this.accessPK = accessPK;
    }

    public Character getAccessState() {
        return accessState;
    }

    public void setAccessState(Character accessState) {
        this.accessState = accessState;
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
        return "com.system.demo.persistence.entity.Access[ accessPK=" + accessPK + " ]";
    }
    
}
