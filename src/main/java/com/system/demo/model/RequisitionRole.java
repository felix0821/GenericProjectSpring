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
@Table(name = "requisition_role")
@NamedQueries({
    @NamedQuery(name = "RequisitionRole.findAll", query = "SELECT r FROM RequisitionRole r"),
    @NamedQuery(name = "RequisitionRole.findByRequisitionId", query = "SELECT r FROM RequisitionRole r WHERE r.requisitionRolePK.requisitionId = :requisitionId"),
    @NamedQuery(name = "RequisitionRole.findByRoleId", query = "SELECT r FROM RequisitionRole r WHERE r.requisitionRolePK.roleId = :roleId"),
    @NamedQuery(name = "RequisitionRole.findByRequisitionRoleState", query = "SELECT r FROM RequisitionRole r WHERE r.requisitionRoleState = :requisitionRoleState")})
public class RequisitionRole implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected RequisitionRolePK requisitionRolePK;
    @Basic(optional = false)
    @Column(name = "requisition_role_state", nullable = false)
    private Character requisitionRoleState;
    @JoinColumn(name = "requisition_id", referencedColumnName = "requisition_id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Requisition requisition;
    @JoinColumn(name = "role_id", referencedColumnName = "role_id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Role role;

    public RequisitionRole() {
    }

    public RequisitionRole(RequisitionRolePK requisitionRolePK) {
        this.requisitionRolePK = requisitionRolePK;
    }

    public RequisitionRole(RequisitionRolePK requisitionRolePK, Character requisitionRoleState) {
        this.requisitionRolePK = requisitionRolePK;
        this.requisitionRoleState = requisitionRoleState;
    }

    public RequisitionRole(long requisitionId, long roleId) {
        this.requisitionRolePK = new RequisitionRolePK(requisitionId, roleId);
    }

    public RequisitionRolePK getRequisitionRolePK() {
        return requisitionRolePK;
    }

    public void setRequisitionRolePK(RequisitionRolePK requisitionRolePK) {
        this.requisitionRolePK = requisitionRolePK;
    }

    public Character getRequisitionRoleState() {
        return requisitionRoleState;
    }

    public void setRequisitionRoleState(Character requisitionRoleState) {
        this.requisitionRoleState = requisitionRoleState;
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
        hash += (requisitionRolePK != null ? requisitionRolePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RequisitionRole)) {
            return false;
        }
        RequisitionRole other = (RequisitionRole) object;
        if ((this.requisitionRolePK == null && other.requisitionRolePK != null) || (this.requisitionRolePK != null && !this.requisitionRolePK.equals(other.requisitionRolePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.system.demo.model.RequisitionRole[ requisitionRolePK=" + requisitionRolePK + " ]";
    }
    
}
