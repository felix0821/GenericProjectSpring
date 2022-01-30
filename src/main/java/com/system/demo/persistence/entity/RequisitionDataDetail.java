/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.system.demo.persistence.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Felix
 */
@Entity
@Table(name = "requisition_data_detail")
@NamedQueries({
    @NamedQuery(name = "RequisitionDataDetail.findAll", query = "SELECT r FROM RequisitionDataDetail r"),
    @NamedQuery(name = "RequisitionDataDetail.findByRequisitionId", query = "SELECT r FROM RequisitionDataDetail r WHERE r.requisitionDataDetailPK.requisitionId = :requisitionId"),
    @NamedQuery(name = "RequisitionDataDetail.findByDataId", query = "SELECT r FROM RequisitionDataDetail r WHERE r.requisitionDataDetailPK.dataId = :dataId"),
    @NamedQuery(name = "RequisitionDataDetail.findByRequisitionDetailId", query = "SELECT r FROM RequisitionDataDetail r WHERE r.requisitionDataDetailPK.requisitionDetailId = :requisitionDetailId"),
    @NamedQuery(name = "RequisitionDataDetail.findByRequisitionDataDetailValue", query = "SELECT r FROM RequisitionDataDetail r WHERE r.requisitionDataDetailValue = :requisitionDataDetailValue")})
public class RequisitionDataDetail implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected RequisitionDataDetailPK requisitionDataDetailPK;
    @Column(name = "requisition_data_detail_value", length = 256)
    private String requisitionDataDetailValue;
    @JoinColumns({
        @JoinColumn(name = "requisition_id", referencedColumnName = "requisition_id", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "data_id", referencedColumnName = "data_id", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private RequisitionData requisitionData;
    @JoinColumn(name = "requisition_detail_id", referencedColumnName = "requisition_detail_id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private RequisitionDetail requisitionDetail;

    public RequisitionDataDetail() {
    }

    public RequisitionDataDetail(RequisitionDataDetailPK requisitionDataDetailPK) {
        this.requisitionDataDetailPK = requisitionDataDetailPK;
    }

    public RequisitionDataDetail(long requisitionId, long dataId, long requisitionDetailId) {
        this.requisitionDataDetailPK = new RequisitionDataDetailPK(requisitionId, dataId, requisitionDetailId);
    }

    public RequisitionDataDetailPK getRequisitionDataDetailPK() {
        return requisitionDataDetailPK;
    }

    public void setRequisitionDataDetailPK(RequisitionDataDetailPK requisitionDataDetailPK) {
        this.requisitionDataDetailPK = requisitionDataDetailPK;
    }

    public String getRequisitionDataDetailValue() {
        return requisitionDataDetailValue;
    }

    public void setRequisitionDataDetailValue(String requisitionDataDetailValue) {
        this.requisitionDataDetailValue = requisitionDataDetailValue;
    }

    public RequisitionData getRequisitionData() {
        return requisitionData;
    }

    public void setRequisitionData(RequisitionData requisitionData) {
        this.requisitionData = requisitionData;
    }

    public RequisitionDetail getRequisitionDetail() {
        return requisitionDetail;
    }

    public void setRequisitionDetail(RequisitionDetail requisitionDetail) {
        this.requisitionDetail = requisitionDetail;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (requisitionDataDetailPK != null ? requisitionDataDetailPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RequisitionDataDetail)) {
            return false;
        }
        RequisitionDataDetail other = (RequisitionDataDetail) object;
        if ((this.requisitionDataDetailPK == null && other.requisitionDataDetailPK != null) || (this.requisitionDataDetailPK != null && !this.requisitionDataDetailPK.equals(other.requisitionDataDetailPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.system.demo.model.RequisitionDataDetail[ requisitionDataDetailPK=" + requisitionDataDetailPK + " ]";
    }
    
}
