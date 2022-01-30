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
@Table(name = "report_data")
@NamedQueries({
    @NamedQuery(name = "ReportData.findAll", query = "SELECT r FROM ReportData r"),
    @NamedQuery(name = "ReportData.findByDataId", query = "SELECT r FROM ReportData r WHERE r.reportDataPK.dataId = :dataId"),
    @NamedQuery(name = "ReportData.findByReportId", query = "SELECT r FROM ReportData r WHERE r.reportDataPK.reportId = :reportId"),
    @NamedQuery(name = "ReportData.findByReportDataState", query = "SELECT r FROM ReportData r WHERE r.reportDataState = :reportDataState")})
public class ReportData implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ReportDataPK reportDataPK;
    @Basic(optional = false)
    @Column(name = "report_data_state", nullable = false)
    private Character reportDataState;
    @JoinColumn(name = "data_id", referencedColumnName = "data_id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Data data;
    @JoinColumn(name = "report_id", referencedColumnName = "report_id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Report report;

    public ReportData() {
    }

    public ReportData(ReportDataPK reportDataPK) {
        this.reportDataPK = reportDataPK;
    }

    public ReportData(ReportDataPK reportDataPK, Character reportDataState) {
        this.reportDataPK = reportDataPK;
        this.reportDataState = reportDataState;
    }

    public ReportData(long dataId, long reportId) {
        this.reportDataPK = new ReportDataPK(dataId, reportId);
    }

    public ReportDataPK getReportDataPK() {
        return reportDataPK;
    }

    public void setReportDataPK(ReportDataPK reportDataPK) {
        this.reportDataPK = reportDataPK;
    }

    public Character getReportDataState() {
        return reportDataState;
    }

    public void setReportDataState(Character reportDataState) {
        this.reportDataState = reportDataState;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public Report getReport() {
        return report;
    }

    public void setReport(Report report) {
        this.report = report;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (reportDataPK != null ? reportDataPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ReportData)) {
            return false;
        }
        ReportData other = (ReportData) object;
        if ((this.reportDataPK == null && other.reportDataPK != null) || (this.reportDataPK != null && !this.reportDataPK.equals(other.reportDataPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.system.demo.model.ReportData[ reportDataPK=" + reportDataPK + " ]";
    }
    
}
