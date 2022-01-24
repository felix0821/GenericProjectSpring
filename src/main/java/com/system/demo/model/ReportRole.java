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
@Table(name = "report_role")
@NamedQueries({
    @NamedQuery(name = "ReportRole.findAll", query = "SELECT r FROM ReportRole r"),
    @NamedQuery(name = "ReportRole.findByRoleId", query = "SELECT r FROM ReportRole r WHERE r.reportRolePK.roleId = :roleId"),
    @NamedQuery(name = "ReportRole.findByReportId", query = "SELECT r FROM ReportRole r WHERE r.reportRolePK.reportId = :reportId"),
    @NamedQuery(name = "ReportRole.findByReportRoleState", query = "SELECT r FROM ReportRole r WHERE r.reportRoleState = :reportRoleState")})
public class ReportRole implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ReportRolePK reportRolePK;
    @Basic(optional = false)
    @Column(name = "report_role_state", nullable = false)
    private Character reportRoleState;
    @JoinColumn(name = "report_id", referencedColumnName = "report_id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Report report;
    @JoinColumn(name = "role_id", referencedColumnName = "role_id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Role role;

    public ReportRole() {
    }

    public ReportRole(ReportRolePK reportRolePK) {
        this.reportRolePK = reportRolePK;
    }

    public ReportRole(ReportRolePK reportRolePK, Character reportRoleState) {
        this.reportRolePK = reportRolePK;
        this.reportRoleState = reportRoleState;
    }

    public ReportRole(long roleId, long reportId) {
        this.reportRolePK = new ReportRolePK(roleId, reportId);
    }

    public ReportRolePK getReportRolePK() {
        return reportRolePK;
    }

    public void setReportRolePK(ReportRolePK reportRolePK) {
        this.reportRolePK = reportRolePK;
    }

    public Character getReportRoleState() {
        return reportRoleState;
    }

    public void setReportRoleState(Character reportRoleState) {
        this.reportRoleState = reportRoleState;
    }

    public Report getReport() {
        return report;
    }

    public void setReport(Report report) {
        this.report = report;
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
        hash += (reportRolePK != null ? reportRolePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ReportRole)) {
            return false;
        }
        ReportRole other = (ReportRole) object;
        if ((this.reportRolePK == null && other.reportRolePK != null) || (this.reportRolePK != null && !this.reportRolePK.equals(other.reportRolePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.system.demo.model.ReportRole[ reportRolePK=" + reportRolePK + " ]";
    }
    
}
