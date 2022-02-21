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
@Table(name = "data")
@NamedQueries({
    @NamedQuery(name = "Data.findAll", query = "SELECT d FROM Data d"),
    @NamedQuery(name = "Data.findByDataId", query = "SELECT d FROM Data d WHERE d.dataId = :dataId"),
    @NamedQuery(name = "Data.findByDataName", query = "SELECT d FROM Data d WHERE d.dataName = :dataName"),
    @NamedQuery(name = "Data.findByDataDescription", query = "SELECT d FROM Data d WHERE d.dataDescription = :dataDescription"),
    @NamedQuery(name = "Data.findByDataValue", query = "SELECT d FROM Data d WHERE d.dataValue = :dataValue"),
    @NamedQuery(name = "Data.findByDataPlaceholder", query = "SELECT d FROM Data d WHERE d.dataPlaceholder = :dataPlaceholder"),
    @NamedQuery(name = "Data.findByDataPattern", query = "SELECT d FROM Data d WHERE d.dataPattern = :dataPattern"),
    @NamedQuery(name = "Data.findByDataRequired", query = "SELECT d FROM Data d WHERE d.dataRequired = :dataRequired"),
    @NamedQuery(name = "Data.findByDataDisable", query = "SELECT d FROM Data d WHERE d.dataDisable = :dataDisable"),
    @NamedQuery(name = "Data.findByDataHidden", query = "SELECT d FROM Data d WHERE d.dataHidden = :dataHidden"),
    @NamedQuery(name = "Data.findByDataType", query = "SELECT d FROM Data d WHERE d.dataType = :dataType"),
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
    @Column(name = "data_value", length = 256)
    private String dataValue;
    @Column(name = "data_placeholder", length = 64)
    private String dataPlaceholder;
    @Column(name = "data_pattern", length = 64)
    private String dataPattern;
    @Basic(optional = false)
    @Column(name = "data_required", nullable = false)
    private boolean dataRequired;
    @Basic(optional = false)
    @Column(name = "data_disable", nullable = false)
    private boolean dataDisable;
    @Basic(optional = false)
    @Column(name = "data_hidden", nullable = false)
    private boolean dataHidden;
    @Basic(optional = false)
    @Column(name = "data_type", nullable = false)
    private Character dataType;
    @Basic(optional = false)
    @Column(name = "data_state", nullable = false)
    private Character dataState;
    @JoinColumn(name = "data_category_id", referencedColumnName = "data_category_id", nullable = false)
    @ManyToOne(optional = false)
    private DataCategory dataCategoryId;
    @JoinColumn(name = "data_entry_id", referencedColumnName = "data_entry_id", nullable = false)
    @ManyToOne(optional = false)
    private DataEntry dataEntryId;
    @JoinColumn(name = "data_reference_id", referencedColumnName = "data_reference_id")
    @ManyToOne
    private DataReference dataReferenceId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "data")
    private Collection<ReportData> reportDataCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "data")
    private Collection<FinancialMovementData> financialMovementDataCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "data")
    private Collection<RequisitionData> requisitionDataCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "data")
    private Collection<PersonData> personDataCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "data")
    private Collection<PeriodData> periodDataCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "data")
    private Collection<ProgramData> programDataCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dataId")
    private Collection<DataDetail> dataDetailCollection;

    public Data() {
    }

    public Data(Long dataId) {
        this.dataId = dataId;
    }

    public Data(Long dataId, String dataName, boolean dataRequired, boolean dataDisable, boolean dataHidden, Character dataType, Character dataState) {
        this.dataId = dataId;
        this.dataName = dataName;
        this.dataRequired = dataRequired;
        this.dataDisable = dataDisable;
        this.dataHidden = dataHidden;
        this.dataType = dataType;
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

    public String getDataValue() {
        return dataValue;
    }

    public void setDataValue(String dataValue) {
        this.dataValue = dataValue;
    }

    public String getDataPlaceholder() {
        return dataPlaceholder;
    }

    public void setDataPlaceholder(String dataPlaceholder) {
        this.dataPlaceholder = dataPlaceholder;
    }

    public String getDataPattern() {
        return dataPattern;
    }

    public void setDataPattern(String dataPattern) {
        this.dataPattern = dataPattern;
    }

    public boolean getDataRequired() {
        return dataRequired;
    }

    public void setDataRequired(boolean dataRequired) {
        this.dataRequired = dataRequired;
    }

    public boolean getDataDisable() {
        return dataDisable;
    }

    public void setDataDisable(boolean dataDisable) {
        this.dataDisable = dataDisable;
    }

    public boolean getDataHidden() {
        return dataHidden;
    }

    public void setDataHidden(boolean dataHidden) {
        this.dataHidden = dataHidden;
    }

    public Character getDataType() {
        return dataType;
    }

    public void setDataType(Character dataType) {
        this.dataType = dataType;
    }

    public Character getDataState() {
        return dataState;
    }

    public void setDataState(Character dataState) {
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

    public DataReference getDataReferenceId() {
        return dataReferenceId;
    }

    public void setDataReferenceId(DataReference dataReferenceId) {
        this.dataReferenceId = dataReferenceId;
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

    public Collection<PeriodData> getPeriodDataCollection() {
        return periodDataCollection;
    }

    public void setPeriodDataCollection(Collection<PeriodData> periodDataCollection) {
        this.periodDataCollection = periodDataCollection;
    }

    public Collection<ProgramData> getProgramDataCollection() {
        return programDataCollection;
    }

    public void setProgramDataCollection(Collection<ProgramData> programDataCollection) {
        this.programDataCollection = programDataCollection;
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
        return "com.system.demo.persistence.entity.Data[ dataId=" + dataId + " ]";
    }
    
}
