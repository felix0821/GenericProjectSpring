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
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "data_detail")
@NamedQueries({
    @NamedQuery(name = "DataDetail.findAll", query = "SELECT d FROM DataDetail d"),
    @NamedQuery(name = "DataDetail.findByDataDetailId", query = "SELECT d FROM DataDetail d WHERE d.dataDetailId = :dataDetailId"),
    @NamedQuery(name = "DataDetail.findByDataDetailName", query = "SELECT d FROM DataDetail d WHERE d.dataDetailName = :dataDetailName"),
    @NamedQuery(name = "DataDetail.findByDataDetailValue", query = "SELECT d FROM DataDetail d WHERE d.dataDetailValue = :dataDetailValue"),
    @NamedQuery(name = "DataDetail.findByDataDetailState", query = "SELECT d FROM DataDetail d WHERE d.dataDetailState = :dataDetailState")})
public class DataDetail implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "data_detail_id", nullable = false)
    private Long dataDetailId;
    @Basic(optional = false)
    @Column(name = "data_detail_name", nullable = false, length = 64)
    private String dataDetailName;
    @Basic(optional = false)
    @Column(name = "data_detail_value", nullable = false, length = 64)
    private String dataDetailValue;
    @Basic(optional = false)
    @Column(name = "data_detail_state", nullable = false)
    private Character dataDetailState;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dataDetail")
    private Collection<DataDetailPeriod> dataDetailPeriodCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dataDetail")
    private Collection<DataDetailProgram> dataDetailProgramCollection;
    @JoinColumn(name = "data_id", referencedColumnName = "data_id", nullable = false)
    @ManyToOne(optional = false)
    private Data dataId;

    public DataDetail() {
    }

    public DataDetail(Long dataDetailId) {
        this.dataDetailId = dataDetailId;
    }

    public DataDetail(Long dataDetailId, String dataDetailName, String dataDetailValue, Character dataDetailState) {
        this.dataDetailId = dataDetailId;
        this.dataDetailName = dataDetailName;
        this.dataDetailValue = dataDetailValue;
        this.dataDetailState = dataDetailState;
    }

    public Long getDataDetailId() {
        return dataDetailId;
    }

    public void setDataDetailId(Long dataDetailId) {
        this.dataDetailId = dataDetailId;
    }

    public String getDataDetailName() {
        return dataDetailName;
    }

    public void setDataDetailName(String dataDetailName) {
        this.dataDetailName = dataDetailName;
    }

    public String getDataDetailValue() {
        return dataDetailValue;
    }

    public void setDataDetailValue(String dataDetailValue) {
        this.dataDetailValue = dataDetailValue;
    }

    public Character getDataDetailState() {
        return dataDetailState;
    }

    public void setDataDetailState(Character dataDetailState) {
        this.dataDetailState = dataDetailState;
    }

    public Collection<DataDetailPeriod> getDataDetailPeriodCollection() {
        return dataDetailPeriodCollection;
    }

    public void setDataDetailPeriodCollection(Collection<DataDetailPeriod> dataDetailPeriodCollection) {
        this.dataDetailPeriodCollection = dataDetailPeriodCollection;
    }

    public Collection<DataDetailProgram> getDataDetailProgramCollection() {
        return dataDetailProgramCollection;
    }

    public void setDataDetailProgramCollection(Collection<DataDetailProgram> dataDetailProgramCollection) {
        this.dataDetailProgramCollection = dataDetailProgramCollection;
    }

    public Data getDataId() {
        return dataId;
    }

    public void setDataId(Data dataId) {
        this.dataId = dataId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dataDetailId != null ? dataDetailId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DataDetail)) {
            return false;
        }
        DataDetail other = (DataDetail) object;
        if ((this.dataDetailId == null && other.dataDetailId != null) || (this.dataDetailId != null && !this.dataDetailId.equals(other.dataDetailId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.system.demo.persistence.entity.DataDetail[ dataDetailId=" + dataDetailId + " ]";
    }
    
}
