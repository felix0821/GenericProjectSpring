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
@Table(name = "requisition_access_role")
@NamedQueries({
    @NamedQuery(name = "RequisitionAccessRole.findAll", query = "SELECT r FROM RequisitionAccessRole r"),
    @NamedQuery(name = "RequisitionAccessRole.findByRequisitionId", query = "SELECT r FROM RequisitionAccessRole r WHERE r.requisitionAccessRolePK.requisitionId = :requisitionId"),
    @NamedQuery(name = "RequisitionAccessRole.findByRoleId", query = "SELECT r FROM RequisitionAccessRole r WHERE r.requisitionAccessRolePK.roleId = :roleId"),
    @NamedQuery(name = "RequisitionAccessRole.findByRequisitionAccessRoleState", query = "SELECT r FROM RequisitionAccessRole r WHERE r.requisitionAccessRoleState = :requisitionAccessRoleState")})
public class RequisitionAccessRole implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected RequisitionAccessRolePK requisitionAccessRolePK;
    @Basic(optional = false)
    @Column(name = "requisition_access_role_state", nullable = false)
    private Character requisitionAccessRoleState;
    @JoinColumn(name = "requisition_id", referencedColumnName = "requisition_id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Requisition requisition;
    @JoinColumn(name = "role_id", referencedColumnName = "role_id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Role role;

    public RequisitionAccessRole() {
    }

    public RequisitionAccessRole(RequisitionAccessRolePK requisitionAccessRolePK) {
        this.requisitionAccessRolePK = requisitionAccessRolePK;
    }

    public RequisitionAccessRole(RequisitionAccessRolePK requisitionAccessRolePK, Character requisitionAccessRoleState) {
        this.requisitionAccessRolePK = requisitionAccessRolePK;
        this.requisitionAccessRoleState = requisitionAccessRoleState;
    }

    public RequisitionAccessRole(long requisitionId, long roleId) {
        this.requisitionAccessRolePK = new RequisitionAccessRolePK(requisitionId, roleId);
    }

    public RequisitionAccessRolePK getRequisitionAccessRolePK() {
        return requisitionAccessRolePK;
    }

    public void setRequisitionAccessRolePK(RequisitionAccessRolePK requisitionAccessRolePK) {
        this.requisitionAccessRolePK = requisitionAccessRolePK;
    }

    public Character getRequisitionAccessRoleState() {
        return requisitionAccessRoleState;
    }

    public void setRequisitionAccessRoleState(Character requisitionAccessRoleState) {
        this.requisitionAccessRoleState = requisitionAccessRoleState;
    }

    public Requisition getRequisition() {
        return requisition;
    }

    public void setRequisition(Requisition requisition) {
        this.requisition = requisition;
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
        hash += (requisitionAccessRolePK != null ? requisitionAccessRolePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RequisitionAccessRole)) {
            return false;
        }
        RequisitionAccessRole other = (RequisitionAccessRole) object;
        if ((this.requisitionAccessRolePK == null && other.requisitionAccessRolePK != null) || (this.requisitionAccessRolePK != null && !this.requisitionAccessRolePK.equals(other.requisitionAccessRolePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.system.demo.persistence.entity.RequisitionAccessRole[ requisitionAccessRolePK=" + requisitionAccessRolePK + " ]";
    }
    
}
