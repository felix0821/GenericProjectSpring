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

/**
 *
 * @author Felix
 */
@Entity
@Table(name = "role_context")
@NamedQueries({
    @NamedQuery(name = "RoleContext.findAll", query = "SELECT r FROM RoleContext r"),
    @NamedQuery(name = "RoleContext.findByRoleId", query = "SELECT r FROM RoleContext r WHERE r.roleContextPK.roleId = :roleId"),
    @NamedQuery(name = "RoleContext.findByContextId", query = "SELECT r FROM RoleContext r WHERE r.roleContextPK.contextId = :contextId"),
    @NamedQuery(name = "RoleContext.findByRoleContextState", query = "SELECT r FROM RoleContext r WHERE r.roleContextState = :roleContextState")})
public class RoleContext implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected RoleContextPK roleContextPK;
    @Basic(optional = false)
    @Column(name = "role_context_state", nullable = false)
    private Character roleContextState;
    @JoinColumn(name = "context_id", referencedColumnName = "context_id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Context context;
    @JoinColumn(name = "role_id", referencedColumnName = "role_id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Role role;

    public RoleContext() {
    }

    public RoleContext(RoleContextPK roleContextPK) {
        this.roleContextPK = roleContextPK;
    }

    public RoleContext(RoleContextPK roleContextPK, Character roleContextState) {
        this.roleContextPK = roleContextPK;
        this.roleContextState = roleContextState;
    }

    public RoleContext(long roleId, long contextId) {
        this.roleContextPK = new RoleContextPK(roleId, contextId);
    }

    public RoleContextPK getRoleContextPK() {
        return roleContextPK;
    }

    public void setRoleContextPK(RoleContextPK roleContextPK) {
        this.roleContextPK = roleContextPK;
    }

    public Character getRoleContextState() {
        return roleContextState;
    }

    public void setRoleContextState(Character roleContextState) {
        this.roleContextState = roleContextState;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
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
        hash += (roleContextPK != null ? roleContextPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RoleContext)) {
            return false;
        }
        RoleContext other = (RoleContext) object;
        if ((this.roleContextPK == null && other.roleContextPK != null) || (this.roleContextPK != null && !this.roleContextPK.equals(other.roleContextPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.system.demo.model.RoleContext[ roleContextPK=" + roleContextPK + " ]";
    }
    
}
