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
@Table(name = "data_reference")
@NamedQueries({
    @NamedQuery(name = "DataReference.findAll", query = "SELECT d FROM DataReference d"),
    @NamedQuery(name = "DataReference.findByDataReferenceId", query = "SELECT d FROM DataReference d WHERE d.dataReferenceId = :dataReferenceId"),
    @NamedQuery(name = "DataReference.findByDataReferenceName", query = "SELECT d FROM DataReference d WHERE d.dataReferenceName = :dataReferenceName"),
    @NamedQuery(name = "DataReference.findByDataReferenceDescription", query = "SELECT d FROM DataReference d WHERE d.dataReferenceDescription = :dataReferenceDescription")})
public class DataReference implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "data_reference_id", nullable = false)
    private Long dataReferenceId;
    @Basic(optional = false)
    @Column(name = "data_reference_name", nullable = false, length = 64)
    private String dataReferenceName;
    @Basic(optional = false)
    @Column(name = "data_reference_description", nullable = false, length = 128)
    private String dataReferenceDescription;
    @OneToMany(mappedBy = "dataReferenceId")
    private Collection<Data> dataCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dataReference")
    private Collection<UsesRestriction> usesRestrictionCollection;

    public DataReference() {
    }

    public DataReference(Long dataReferenceId) {
        this.dataReferenceId = dataReferenceId;
    }

    public DataReference(Long dataReferenceId, String dataReferenceName, String dataReferenceDescription) {
        this.dataReferenceId = dataReferenceId;
        this.dataReferenceName = dataReferenceName;
        this.dataReferenceDescription = dataReferenceDescription;
    }

    public Long getDataReferenceId() {
        return dataReferenceId;
    }

    public void setDataReferenceId(Long dataReferenceId) {
        this.dataReferenceId = dataReferenceId;
    }

    public String getDataReferenceName() {
        return dataReferenceName;
    }

    public void setDataReferenceName(String dataReferenceName) {
        this.dataReferenceName = dataReferenceName;
    }

    public String getDataReferenceDescription() {
        return dataReferenceDescription;
    }

    public void setDataReferenceDescription(String dataReferenceDescription) {
        this.dataReferenceDescription = dataReferenceDescription;
    }

    public Collection<Data> getDataCollection() {
        return dataCollection;
    }

    public void setDataCollection(Collection<Data> dataCollection) {
        this.dataCollection = dataCollection;
    }

    public Collection<UsesRestriction> getUsesRestrictionCollection() {
        return usesRestrictionCollection;
    }

    public void setUsesRestrictionCollection(Collection<UsesRestriction> usesRestrictionCollection) {
        this.usesRestrictionCollection = usesRestrictionCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dataReferenceId != null ? dataReferenceId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DataReference)) {
            return false;
        }
        DataReference other = (DataReference) object;
        if ((this.dataReferenceId == null && other.dataReferenceId != null) || (this.dataReferenceId != null && !this.dataReferenceId.equals(other.dataReferenceId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.system.demo.persistence.entity.DataReference[ dataReferenceId=" + dataReferenceId + " ]";
    }
    
}
