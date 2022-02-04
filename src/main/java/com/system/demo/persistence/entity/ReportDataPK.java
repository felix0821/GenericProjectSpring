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
public class ReportDataPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "data_id", nullable = false)
    private long dataId;
    @Basic(optional = false)
    @Column(name = "report_id", nullable = false)
    private long reportId;

    public ReportDataPK() {
    }

    public ReportDataPK(long dataId, long reportId) {
        this.dataId = dataId;
        this.reportId = reportId;
    }

    public long getDataId() {
        return dataId;
    }

    public void setDataId(long dataId) {
        this.dataId = dataId;
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
        hash += (int) dataId;
        hash += (int) reportId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ReportDataPK)) {
            return false;
        }
        ReportDataPK other = (ReportDataPK) object;
        if (this.dataId != other.dataId) {
            return false;
        }
        if (this.reportId != other.reportId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.system.demo.persistence.entity.ReportDataPK[ dataId=" + dataId + ", reportId=" + reportId + " ]";
    }
    
}
