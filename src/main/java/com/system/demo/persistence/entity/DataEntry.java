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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Felix
 */
@Entity
@Table(name = "data_entry")
@NamedQueries({
    @NamedQuery(name = "DataEntry.findAll", query = "SELECT d FROM DataEntry d"),
    @NamedQuery(name = "DataEntry.findByDataEntryId", query = "SELECT d FROM DataEntry d WHERE d.dataEntryId = :dataEntryId"),
    @NamedQuery(name = "DataEntry.findByDataEntryType", query = "SELECT d FROM DataEntry d WHERE d.dataEntryType = :dataEntryType"),
    @NamedQuery(name = "DataEntry.findByDataEntryAccept", query = "SELECT d FROM DataEntry d WHERE d.dataEntryAccept = :dataEntryAccept"),
    @NamedQuery(name = "DataEntry.findByDataEntrySelection", query = "SELECT d FROM DataEntry d WHERE d.dataEntrySelection = :dataEntrySelection"),
    @NamedQuery(name = "DataEntry.findByDataEntryName", query = "SELECT d FROM DataEntry d WHERE d.dataEntryName = :dataEntryName")})
public class DataEntry implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "data_entry_id", nullable = false)
    private Long dataEntryId;
    @Basic(optional = false)
    @Column(name = "data_entry_type", nullable = false, length = 32)
    private String dataEntryType;
    @Column(name = "data_entry_accept", length = 128)
    private String dataEntryAccept;
    @Basic(optional = false)
    @Column(name = "data_entry_selection", nullable = false)
    private boolean dataEntrySelection;
    @Basic(optional = false)
    @Column(name = "data_entry_name", nullable = false, length = 64)
    private String dataEntryName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dataEntryId")
    private Collection<Data> dataCollection;

    public DataEntry() {
    }

    public DataEntry(Long dataEntryId) {
        this.dataEntryId = dataEntryId;
    }

    public DataEntry(Long dataEntryId, String dataEntryType, boolean dataEntrySelection, String dataEntryName) {
        this.dataEntryId = dataEntryId;
        this.dataEntryType = dataEntryType;
        this.dataEntrySelection = dataEntrySelection;
        this.dataEntryName = dataEntryName;
    }

    public Long getDataEntryId() {
        return dataEntryId;
    }

    public void setDataEntryId(Long dataEntryId) {
        this.dataEntryId = dataEntryId;
    }

    public String getDataEntryType() {
        return dataEntryType;
    }

    public void setDataEntryType(String dataEntryType) {
        this.dataEntryType = dataEntryType;
    }

    public String getDataEntryAccept() {
        return dataEntryAccept;
    }

    public void setDataEntryAccept(String dataEntryAccept) {
        this.dataEntryAccept = dataEntryAccept;
    }

    public boolean getDataEntrySelection() {
        return dataEntrySelection;
    }

    public void setDataEntrySelection(boolean dataEntrySelection) {
        this.dataEntrySelection = dataEntrySelection;
    }

    public String getDataEntryName() {
        return dataEntryName;
    }

    public void setDataEntryName(String dataEntryName) {
        this.dataEntryName = dataEntryName;
    }

    public Collection<Data> getDataCollection() {
        return dataCollection;
    }

    public void setDataCollection(Collection<Data> dataCollection) {
        this.dataCollection = dataCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dataEntryId != null ? dataEntryId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DataEntry)) {
            return false;
        }
        DataEntry other = (DataEntry) object;
        if ((this.dataEntryId == null && other.dataEntryId != null) || (this.dataEntryId != null && !this.dataEntryId.equals(other.dataEntryId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.system.demo.persistence.entity.DataEntry[ dataEntryId=" + dataEntryId + " ]";
    }
    
}
