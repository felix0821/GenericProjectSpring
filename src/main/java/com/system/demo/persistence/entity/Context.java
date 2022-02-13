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
@Table(name = "context")
@NamedQueries({
    @NamedQuery(name = "Context.findAll", query = "SELECT c FROM Context c"),
    @NamedQuery(name = "Context.findByContextId", query = "SELECT c FROM Context c WHERE c.contextId = :contextId"),
    @NamedQuery(name = "Context.findByContextName", query = "SELECT c FROM Context c WHERE c.contextName = :contextName"),
    @NamedQuery(name = "Context.findByContextState", query = "SELECT c FROM Context c WHERE c.contextState = :contextState"),
    @NamedQuery(name = "Context.findByContextType", query = "SELECT c FROM Context c WHERE c.contextType = :contextType")})
public class Context implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "context_id", nullable = false)
    private Long contextId;
    @Basic(optional = false)
    @Column(name = "context_name", nullable = false, length = 64)
    private String contextName;
    @Basic(optional = false)
    @Column(name = "context_state", nullable = false)
    private Character contextState;
    @Basic(optional = false)
    @Column(name = "context_type", nullable = false)
    private Character contextType;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "context")
    private Collection<ResourceContext> resourceContextCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "context")
    private Collection<RoleContext> roleContextCollection;

    public Context() {
    }

    public Context(Long contextId) {
        this.contextId = contextId;
    }

    public Context(Long contextId, String contextName, Character contextState, Character contextType) {
        this.contextId = contextId;
        this.contextName = contextName;
        this.contextState = contextState;
        this.contextType = contextType;
    }

    public Long getContextId() {
        return contextId;
    }

    public void setContextId(Long contextId) {
        this.contextId = contextId;
    }

    public String getContextName() {
        return contextName;
    }

    public void setContextName(String contextName) {
        this.contextName = contextName;
    }

    public Character getContextState() {
        return contextState;
    }

    public void setContextState(Character contextState) {
        this.contextState = contextState;
    }

    public Character getContextType() {
        return contextType;
    }

    public void setContextType(Character contextType) {
        this.contextType = contextType;
    }

    public Collection<ResourceContext> getResourceContextCollection() {
        return resourceContextCollection;
    }

    public void setResourceContextCollection(Collection<ResourceContext> resourceContextCollection) {
        this.resourceContextCollection = resourceContextCollection;
    }

    public Collection<RoleContext> getRoleContextCollection() {
        return roleContextCollection;
    }

    public void setRoleContextCollection(Collection<RoleContext> roleContextCollection) {
        this.roleContextCollection = roleContextCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (contextId != null ? contextId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Context)) {
            return false;
        }
        Context other = (Context) object;
        if ((this.contextId == null && other.contextId != null) || (this.contextId != null && !this.contextId.equals(other.contextId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.system.demo.persistence.entity.Context[ contextId=" + contextId + " ]";
    }
    
}
