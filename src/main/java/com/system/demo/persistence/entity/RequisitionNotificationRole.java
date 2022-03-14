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
@Table(name = "requisition_notification_role", catalog = "ucps_system", schema = "public")
@NamedQueries({
    @NamedQuery(name = "RequisitionNotificationRole.findAll", query = "SELECT r FROM RequisitionNotificationRole r"),
    @NamedQuery(name = "RequisitionNotificationRole.findByRequisitionId", query = "SELECT r FROM RequisitionNotificationRole r WHERE r.requisitionNotificationRolePK.requisitionId = :requisitionId"),
    @NamedQuery(name = "RequisitionNotificationRole.findByRoleId", query = "SELECT r FROM RequisitionNotificationRole r WHERE r.requisitionNotificationRolePK.roleId = :roleId"),
    @NamedQuery(name = "RequisitionNotificationRole.findByRequisitionNotificationRoleState", query = "SELECT r FROM RequisitionNotificationRole r WHERE r.requisitionNotificationRoleState = :requisitionNotificationRoleState")})
public class RequisitionNotificationRole implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected RequisitionNotificationRolePK requisitionNotificationRolePK;
    @Basic(optional = false)
    @Column(name = "requisition_notification_role_state")
    private Character requisitionNotificationRoleState;
    @JoinColumn(name = "requisition_id", referencedColumnName = "requisition_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Requisition requisition;
    @JoinColumn(name = "role_id", referencedColumnName = "role_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Role role;

    public RequisitionNotificationRole() {
    }

    public RequisitionNotificationRole(RequisitionNotificationRolePK requisitionNotificationRolePK) {
        this.requisitionNotificationRolePK = requisitionNotificationRolePK;
    }

    public RequisitionNotificationRole(RequisitionNotificationRolePK requisitionNotificationRolePK, Character requisitionNotificationRoleState) {
        this.requisitionNotificationRolePK = requisitionNotificationRolePK;
        this.requisitionNotificationRoleState = requisitionNotificationRoleState;
    }

    public RequisitionNotificationRole(long requisitionId, long roleId) {
        this.requisitionNotificationRolePK = new RequisitionNotificationRolePK(requisitionId, roleId);
    }

    public RequisitionNotificationRolePK getRequisitionNotificationRolePK() {
        return requisitionNotificationRolePK;
    }

    public void setRequisitionNotificationRolePK(RequisitionNotificationRolePK requisitionNotificationRolePK) {
        this.requisitionNotificationRolePK = requisitionNotificationRolePK;
    }

    public Character getRequisitionNotificationRoleState() {
        return requisitionNotificationRoleState;
    }

    public void setRequisitionNotificationRoleState(Character requisitionNotificationRoleState) {
        this.requisitionNotificationRoleState = requisitionNotificationRoleState;
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
        hash += (requisitionNotificationRolePK != null ? requisitionNotificationRolePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RequisitionNotificationRole)) {
            return false;
        }
        RequisitionNotificationRole other = (RequisitionNotificationRole) object;
        if ((this.requisitionNotificationRolePK == null && other.requisitionNotificationRolePK != null) || (this.requisitionNotificationRolePK != null && !this.requisitionNotificationRolePK.equals(other.requisitionNotificationRolePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.system.demo.persistence.entity.RequisitionNotificationRole[ requisitionNotificationRolePK=" + requisitionNotificationRolePK + " ]";
    }
    
}
