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
@Table(name = "role_view")
@NamedQueries({
    @NamedQuery(name = "RoleView.findAll", query = "SELECT r FROM RoleView r"),
    @NamedQuery(name = "RoleView.findByInterfaceViewId", query = "SELECT r FROM RoleView r WHERE r.roleViewPK.interfaceViewId = :interfaceViewId"),
    @NamedQuery(name = "RoleView.findByRoleId", query = "SELECT r FROM RoleView r WHERE r.roleViewPK.roleId = :roleId"),
    @NamedQuery(name = "RoleView.findByRoleViewIndex", query = "SELECT r FROM RoleView r WHERE r.roleViewIndex = :roleViewIndex"),
    @NamedQuery(name = "RoleView.findByRoleViewState", query = "SELECT r FROM RoleView r WHERE r.roleViewState = :roleViewState")})
public class RoleView implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected RoleViewPK roleViewPK;
    @Basic(optional = false)
    @Column(name = "role_view_index", nullable = false)
    private int roleViewIndex;
    @Basic(optional = false)
    @Column(name = "role_view_state", nullable = false)
    private Character roleViewState;
    @JoinColumn(name = "interface_view_id", referencedColumnName = "interface_view_id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private InterfaceView interfaceView;
    @JoinColumn(name = "role_id", referencedColumnName = "role_id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Role role;

    public RoleView() {
    }

    public RoleView(RoleViewPK roleViewPK) {
        this.roleViewPK = roleViewPK;
    }

    public RoleView(RoleViewPK roleViewPK, int roleViewIndex, Character roleViewState) {
        this.roleViewPK = roleViewPK;
        this.roleViewIndex = roleViewIndex;
        this.roleViewState = roleViewState;
    }

    public RoleView(long interfaceViewId, long roleId) {
        this.roleViewPK = new RoleViewPK(interfaceViewId, roleId);
    }

    public RoleViewPK getRoleViewPK() {
        return roleViewPK;
    }

    public void setRoleViewPK(RoleViewPK roleViewPK) {
        this.roleViewPK = roleViewPK;
    }

    public int getRoleViewIndex() {
        return roleViewIndex;
    }

    public void setRoleViewIndex(int roleViewIndex) {
        this.roleViewIndex = roleViewIndex;
    }

    public Character getRoleViewState() {
        return roleViewState;
    }

    public void setRoleViewState(Character roleViewState) {
        this.roleViewState = roleViewState;
    }

    public InterfaceView getInterfaceView() {
        return interfaceView;
    }

    public void setInterfaceView(InterfaceView interfaceView) {
        this.interfaceView = interfaceView;
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
        hash += (roleViewPK != null ? roleViewPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RoleView)) {
            return false;
        }
        RoleView other = (RoleView) object;
        if ((this.roleViewPK == null && other.roleViewPK != null) || (this.roleViewPK != null && !this.roleViewPK.equals(other.roleViewPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.system.demo.persistence.entity.RoleView[ roleViewPK=" + roleViewPK + " ]";
    }
    
}
