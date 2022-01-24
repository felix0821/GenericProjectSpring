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
@Table(name = "data")
@NamedQueries({
    @NamedQuery(name = "Data.findAll", query = "SELECT d FROM Data d"),
    @NamedQuery(name = "Data.findByDataId", query = "SELECT d FROM Data d WHERE d.dataId = :dataId"),
    @NamedQuery(name = "Data.findByDataName", query = "SELECT d FROM Data d WHERE d.dataName = :dataName"),
    @NamedQuery(name = "Data.findByDataDescription", query = "SELECT d FROM Data d WHERE d.dataDescription = :dataDescription"),
    @NamedQuery(name = "Data.findByDataState", query = "SELECT d FROM Data d WHERE d.dataState = :dataState")})
public class Data implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "data_id", nullable = false)
    private Long dataId;
    @Basic(optional = false)
    @Column(name = "data_name", nullable = false, length = 64)
    private String dataName;
    @Column(name = "data_description", length = 128)
    private String dataDescription;
    @Basic(optional = false)
    @Column(name = "data_state", nullable = false, length = 1)
    private String dataState;
    @JoinColumn(name = "data_category_id", referencedColumnName = "data_category_id", nullable = false)
    @ManyToOne(optional = false)
    private DataCategory dataCategoryId;
    @JoinColumn(name = "data_entry_id", referencedColumnName = "data_entry_id", nullable = false)
    @ManyToOne(optional = false)
    private DataEntry dataEntryId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "data")
    private Collection<ReportData> reportDataCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "data")
    private Collection<FinancialMovementData> financialMovementDataCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "data")
    private Collection<RequisitionData> requisitionDataCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "data")
    private Collection<PersonData> personDataCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dataId")
    private Collection<DataDetail> dataDetailCollection;

    public Data() {
    }

    public Data(Long dataId) {
        this.dataId = dataId;
    }

    public Data(Long dataId, String dataName, String dataState) {
        this.dataId = dataId;
        this.dataName = dataName;
        this.dataState = dataState;
    }

    public Long getDataId() {
        return dataId;
    }

    public void setDataId(Long dataId) {
        this.dataId = dataId;
    }

    public String getDataName() {
        return dataName;
    }

    public void setDataName(String dataName) {
        this.dataName = dataName;
    }

    public String getDataDescription() {
        return dataDescription;
    }

    public void setDataDescription(String dataDescription) {
        this.dataDescription = dataDescription;
    }

    public String getDataState() {
        return dataState;
    }

    public void setDataState(String dataState) {
        this.dataState = dataState;
    }

    public DataCategory getDataCategoryId() {
        return dataCategoryId;
    }

    public void setDataCategoryId(DataCategory dataCategoryId) {
        this.dataCategoryId = dataCategoryId;
    }

    public DataEntry getDataEntryId() {
        return dataEntryId;
    }

    public void setDataEntryId(DataEntry dataEntryId) {
        this.dataEntryId = dataEntryId;
    }

    public Collection<ReportData> getReportDataCollection() {
        return reportDataCollection;
    }

    public void setReportDataCollection(Collection<ReportData> reportDataCollection) {
        this.reportDataCollection = reportDataCollection;
    }

    public Collection<FinancialMovementData> getFinancialMovementDataCollection() {
        return financialMovementDataCollection;
    }

    public void setFinancialMovementDataCollection(Collection<FinancialMovementData> financialMovementDataCollection) {
        this.financialMovementDataCollection = financialMovementDataCollection;
    }

    public Collection<RequisitionData> getRequisitionDataCollection() {
        return requisitionDataCollection;
    }

    public void setRequisitionDataCollection(Collection<RequisitionData> requisitionDataCollection) {
        this.requisitionDataCollection = requisitionDataCollection;
    }

    public Collection<PersonData> getPersonDataCollection() {
        return personDataCollection;
    }

    public void setPersonDataCollection(Collection<PersonData> personDataCollection) {
        this.personDataCollection = personDataCollection;
    }

    public Collection<DataDetail> getDataDetailCollection() {
        return dataDetailCollection;
    }

    public void setDataDetailCollection(Collection<DataDetail> dataDetailCollection) {
        this.dataDetailCollection = dataDetailCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dataId != null ? dataId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Data)) {
            return false;
        }
        Data other = (Data) object;
        if ((this.dataId == null && other.dataId != null) || (this.dataId != null && !this.dataId.equals(other.dataId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.system.demo.model.Data[ dataId=" + dataId + " ]";
    }
    
}
