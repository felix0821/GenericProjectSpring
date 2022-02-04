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
@Table(name = "resource_context")
@NamedQueries({
    @NamedQuery(name = "ResourceContext.findAll", query = "SELECT r FROM ResourceContext r"),
    @NamedQuery(name = "ResourceContext.findByContextId", query = "SELECT r FROM ResourceContext r WHERE r.resourceContextPK.contextId = :contextId"),
    @NamedQuery(name = "ResourceContext.findByResourceId", query = "SELECT r FROM ResourceContext r WHERE r.resourceContextPK.resourceId = :resourceId"),
    @NamedQuery(name = "ResourceContext.findByResourceContextState", query = "SELECT r FROM ResourceContext r WHERE r.resourceContextState = :resourceContextState")})
public class ResourceContext implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ResourceContextPK resourceContextPK;
    @Basic(optional = false)
    @Column(name = "resource_context_state", nullable = false)
    private Character resourceContextState;
    @JoinColumn(name = "context_id", referencedColumnName = "context_id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Context context;
    @JoinColumn(name = "resource_id", referencedColumnName = "resource_id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Resource resource;

    public ResourceContext() {
    }

    public ResourceContext(ResourceContextPK resourceContextPK) {
        this.resourceContextPK = resourceContextPK;
    }

    public ResourceContext(ResourceContextPK resourceContextPK, Character resourceContextState) {
        this.resourceContextPK = resourceContextPK;
        this.resourceContextState = resourceContextState;
    }

    public ResourceContext(long contextId, long resourceId) {
        this.resourceContextPK = new ResourceContextPK(contextId, resourceId);
    }

    public ResourceContextPK getResourceContextPK() {
        return resourceContextPK;
    }

    public void setResourceContextPK(ResourceContextPK resourceContextPK) {
        this.resourceContextPK = resourceContextPK;
    }

    public Character getResourceContextState() {
        return resourceContextState;
    }

    public void setResourceContextState(Character resourceContextState) {
        this.resourceContextState = resourceContextState;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public Resource getResource() {
        return resource;
    }

    public void setResource(Resource resource) {
        this.resource = resource;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (resourceContextPK != null ? resourceContextPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ResourceContext)) {
            return false;
        }
        ResourceContext other = (ResourceContext) object;
        if ((this.resourceContextPK == null && other.resourceContextPK != null) || (this.resourceContextPK != null && !this.resourceContextPK.equals(other.resourceContextPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.system.demo.persistence.entity.ResourceContext[ resourceContextPK=" + resourceContextPK + " ]";
    }
    
}
