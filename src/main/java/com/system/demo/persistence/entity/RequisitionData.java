/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.system.demo.persistence.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Felix
 */
@Entity
@Table(name = "requisition_data")
@NamedQueries({
    @NamedQuery(name = "RequisitionData.findAll", query = "SELECT r FROM RequisitionData r"),
    @NamedQuery(name = "RequisitionData.findByRequisitionId", query = "SELECT r FROM RequisitionData r WHERE r.requisitionDataPK.requisitionId = :requisitionId"),
    @NamedQuery(name = "RequisitionData.findByDataId", query = "SELECT r FROM RequisitionData r WHERE r.requisitionDataPK.dataId = :dataId"),
    @NamedQuery(name = "RequisitionData.findByRequisitionDataIndex", query = "SELECT r FROM RequisitionData r WHERE r.requisitionDataIndex = :requisitionDataIndex"),
    @NamedQuery(name = "RequisitionData.findByRequisitionDataState", query = "SELECT r FROM RequisitionData r WHERE r.requisitionDataState = :requisitionDataState")})
public class RequisitionData implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected RequisitionDataPK requisitionDataPK;
    @Basic(optional = false)
    @Column(name = "requisition_data_index", nullable = false)
    private int requisitionDataIndex;
    @Basic(optional = false)
    @Column(name = "requisition_data_state", nullable = false)
    private Character requisitionDataState;
    @JoinColumn(name = "data_id", referencedColumnName = "data_id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Data data;
    @JoinColumn(name = "requisition_id", referencedColumnName = "requisition_id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Requisition requisition;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "requisitionData")
    private Collection<RequisitionDataDetail> requisitionDataDetailCollection;

    public RequisitionData() {
    }

    public RequisitionData(RequisitionDataPK requisitionDataPK) {
        this.requisitionDataPK = requisitionDataPK;
    }

    public RequisitionData(RequisitionDataPK requisitionDataPK, int requisitionDataIndex, Character requisitionDataState) {
        this.requisitionDataPK = requisitionDataPK;
        this.requisitionDataIndex = requisitionDataIndex;
        this.requisitionDataState = requisitionDataState;
    }

    public RequisitionData(long requisitionId, long dataId) {
        this.requisitionDataPK = new RequisitionDataPK(requisitionId, dataId);
    }

    public RequisitionDataPK getRequisitionDataPK() {
        return requisitionDataPK;
    }

    public void setRequisitionDataPK(RequisitionDataPK requisitionDataPK) {
        this.requisitionDataPK = requisitionDataPK;
    }

    public int getRequisitionDataIndex() {
        return requisitionDataIndex;
    }

    public void setRequisitionDataIndex(int requisitionDataIndex) {
        this.requisitionDataIndex = requisitionDataIndex;
    }

    public Character getRequisitionDataState() {
        return requisitionDataState;
    }

    public void setRequisitionDataState(Character requisitionDataState) {
        this.requisitionDataState = requisitionDataState;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public Requisition getRequisition() {
        return requisition;
    }

    public void setRequisition(Requisition requisition) {
        this.requisition = requisition;
    }

    public Collection<RequisitionDataDetail> getRequisitionDataDetailCollection() {
        return requisitionDataDetailCollection;
    }

    public void setRequisitionDataDetailCollection(Collection<RequisitionDataDetail> requisitionDataDetailCollection) {
        this.requisitionDataDetailCollection = requisitionDataDetailCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (requisitionDataPK != null ? requisitionDataPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RequisitionData)) {
            return false;
        }
        RequisitionData other = (RequisitionData) object;
        if ((this.requisitionDataPK == null && other.requisitionDataPK != null) || (this.requisitionDataPK != null && !this.requisitionDataPK.equals(other.requisitionDataPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.system.demo.model.RequisitionData[ requisitionDataPK=" + requisitionDataPK + " ]";
    }
    
}
