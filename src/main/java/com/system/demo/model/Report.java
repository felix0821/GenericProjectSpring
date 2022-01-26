/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.system.demo.model;

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
@Table(name = "report")
@NamedQueries({
    @NamedQuery(name = "Report.findAll", query = "SELECT r FROM Report r"),
    @NamedQuery(name = "Report.findByReportId", query = "SELECT r FROM Report r WHERE r.reportId = :reportId"),
    @NamedQuery(name = "Report.findByReportName", query = "SELECT r FROM Report r WHERE r.reportName = :reportName"),
    @NamedQuery(name = "Report.findByReportState", query = "SELECT r FROM Report r WHERE r.reportState = :reportState")})
public class Report implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "report_id", nullable = false)
    private Long reportId;
    @Basic(optional = false)
    @Column(name = "report_name", nullable = false, length = 64)
    private String reportName;
    @Basic(optional = false)
    @Column(name = "report_state", nullable = false)
    private Character reportState;
    @OneToMany(mappedBy = "reportId")
    private Collection<ReportDetail> reportDetailCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "report")
    private Collection<ReportData> reportDataCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "report")
    private Collection<ReportRole> reportRoleCollection;

    public Report() {
    }

    public Report(Long reportId) {
        this.reportId = reportId;
    }

    public Report(Long reportId, String reportName, Character reportState) {
        this.reportId = reportId;
        this.reportName = reportName;
        this.reportState = reportState;
    }

    public Long getReportId() {
        return reportId;
    }

    public void setReportId(Long reportId) {
        this.reportId = reportId;
    }

    public String getReportName() {
        return reportName;
    }

    public void setReportName(String reportName) {
        this.reportName = reportName;
    }

    public Character getReportState() {
        return reportState;
    }

    public void setReportState(Character reportState) {
        this.reportState = reportState;
    }

    public Collection<ReportDetail> getReportDetailCollection() {
        return reportDetailCollection;
    }

    public void setReportDetailCollection(Collection<ReportDetail> reportDetailCollection) {
        this.reportDetailCollection = reportDetailCollection;
    }

    public Collection<ReportData> getReportDataCollection() {
        return reportDataCollection;
    }

    public void setReportDataCollection(Collection<ReportData> reportDataCollection) {
        this.reportDataCollection = reportDataCollection;
    }

    public Collection<ReportRole> getReportRoleCollection() {
        return reportRoleCollection;
    }

    public void setReportRoleCollection(Collection<ReportRole> reportRoleCollection) {
        this.reportRoleCollection = reportRoleCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (reportId != null ? reportId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Report)) {
            return false;
        }
        Report other = (Report) object;
        if ((this.reportId == null && other.reportId != null) || (this.reportId != null && !this.reportId.equals(other.reportId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.system.demo.model.Report[ reportId=" + reportId + " ]";
    }
    
}
