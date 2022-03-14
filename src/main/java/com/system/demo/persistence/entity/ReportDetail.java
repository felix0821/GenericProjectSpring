/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.system.demo.persistence.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Felix
 */
@Entity
@Table(name = "report_detail", catalog = "ucps_system", schema = "public")
@NamedQueries({
    @NamedQuery(name = "ReportDetail.findAll", query = "SELECT r FROM ReportDetail r"),
    @NamedQuery(name = "ReportDetail.findByReportDetailId", query = "SELECT r FROM ReportDetail r WHERE r.reportDetailId = :reportDetailId"),
    @NamedQuery(name = "ReportDetail.findByReportDetailState", query = "SELECT r FROM ReportDetail r WHERE r.reportDetailState = :reportDetailState"),
    @NamedQuery(name = "ReportDetail.findByReportDetailDate", query = "SELECT r FROM ReportDetail r WHERE r.reportDetailDate = :reportDetailDate")})
public class ReportDetail implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "report_detail_id")
    private Long reportDetailId;
    @Basic(optional = false)
    @Column(name = "report_detail_state")
    private Character reportDetailState;
    @Basic(optional = false)
    @Column(name = "report_detail_date")
    @Temporal(TemporalType.DATE)
    private Date reportDetailDate;
    @JoinColumn(name = "report_id", referencedColumnName = "report_id")
    @ManyToOne
    private Report reportId;

    public ReportDetail() {
    }

    public ReportDetail(Long reportDetailId) {
        this.reportDetailId = reportDetailId;
    }

    public ReportDetail(Long reportDetailId, Character reportDetailState, Date reportDetailDate) {
        this.reportDetailId = reportDetailId;
        this.reportDetailState = reportDetailState;
        this.reportDetailDate = reportDetailDate;
    }

    public Long getReportDetailId() {
        return reportDetailId;
    }

    public void setReportDetailId(Long reportDetailId) {
        this.reportDetailId = reportDetailId;
    }

    public Character getReportDetailState() {
        return reportDetailState;
    }

    public void setReportDetailState(Character reportDetailState) {
        this.reportDetailState = reportDetailState;
    }

    public Date getReportDetailDate() {
        return reportDetailDate;
    }

    public void setReportDetailDate(Date reportDetailDate) {
        this.reportDetailDate = reportDetailDate;
    }

    public Report getReportId() {
        return reportId;
    }

    public void setReportId(Report reportId) {
        this.reportId = reportId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (reportDetailId != null ? reportDetailId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ReportDetail)) {
            return false;
        }
        ReportDetail other = (ReportDetail) object;
        if ((this.reportDetailId == null && other.reportDetailId != null) || (this.reportDetailId != null && !this.reportDetailId.equals(other.reportDetailId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.system.demo.persistence.entity.ReportDetail[ reportDetailId=" + reportDetailId + " ]";
    }
    
}
