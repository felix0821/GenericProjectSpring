/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.system.demo.persistence.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Felix
 */
@Embeddable
public class ReportRolePK implements Serializable {

    @Basic(optional = false)
    @Column(name = "role_id", nullable = false)
    private long roleId;
    @Basic(optional = false)
    @Column(name = "report_id", nullable = false)
    private long reportId;

    public ReportRolePK() {
    }

    public ReportRolePK(long roleId, long reportId) {
        this.roleId = roleId;
        this.reportId = reportId;
    }

    public long getRoleId() {
        return roleId;
    }

    public void setRoleId(long roleId) {
        this.roleId = roleId;
    }

    public long getReportId() {
        return reportId;
    }

    public void setReportId(long reportId) {
        this.reportId = reportId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) roleId;
        hash += (int) reportId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ReportRolePK)) {
            return false;
        }
        ReportRolePK other = (ReportRolePK) object;
        if (this.roleId != other.roleId) {
            return false;
        }
        if (this.reportId != other.reportId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.system.demo.persistence.entity.ReportRolePK[ roleId=" + roleId + ", reportId=" + reportId + " ]";
    }
    
}
