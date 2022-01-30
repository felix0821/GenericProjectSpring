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
@Table(name = "data_category")
@NamedQueries({
    @NamedQuery(name = "DataCategory.findAll", query = "SELECT d FROM DataCategory d"),
    @NamedQuery(name = "DataCategory.findByDataCategoryId", query = "SELECT d FROM DataCategory d WHERE d.dataCategoryId = :dataCategoryId"),
    @NamedQuery(name = "DataCategory.findByDataCategoryName", query = "SELECT d FROM DataCategory d WHERE d.dataCategoryName = :dataCategoryName"),
    @NamedQuery(name = "DataCategory.findByDataCategoryDescription", query = "SELECT d FROM DataCategory d WHERE d.dataCategoryDescription = :dataCategoryDescription"),
    @NamedQuery(name = "DataCategory.findByDataCategoryState", query = "SELECT d FROM DataCategory d WHERE d.dataCategoryState = :dataCategoryState")})
public class DataCategory implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "data_category_id", nullable = false)
    private Long dataCategoryId;
    @Basic(optional = false)
    @Column(name = "data_category_name", nullable = false, length = 64)
    private String dataCategoryName;
    @Column(name = "data_category_description", length = 128)
    private String dataCategoryDescription;
    @Basic(optional = false)
    @Column(name = "data_category_state", nullable = false)
    private Character dataCategoryState;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dataCategoryId")
    private Collection<Data> dataCollection;

    public DataCategory() {
    }

    public DataCategory(Long dataCategoryId) {
        this.dataCategoryId = dataCategoryId;
    }

    public DataCategory(Long dataCategoryId, String dataCategoryName, Character dataCategoryState) {
        this.dataCategoryId = dataCategoryId;
        this.dataCategoryName = dataCategoryName;
        this.dataCategoryState = dataCategoryState;
    }

    public Long getDataCategoryId() {
        return dataCategoryId;
    }

    public void setDataCategoryId(Long dataCategoryId) {
        this.dataCategoryId = dataCategoryId;
    }

    public String getDataCategoryName() {
        return dataCategoryName;
    }

    public void setDataCategoryName(String dataCategoryName) {
        this.dataCategoryName = dataCategoryName;
    }

    public String getDataCategoryDescription() {
        return dataCategoryDescription;
    }

    public void setDataCategoryDescription(String dataCategoryDescription) {
        this.dataCategoryDescription = dataCategoryDescription;
    }

    public Character getDataCategoryState() {
        return dataCategoryState;
    }

    public void setDataCategoryState(Character dataCategoryState) {
        this.dataCategoryState = dataCategoryState;
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
        hash += (dataCategoryId != null ? dataCategoryId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DataCategory)) {
            return false;
        }
        DataCategory other = (DataCategory) object;
        if ((this.dataCategoryId == null && other.dataCategoryId != null) || (this.dataCategoryId != null && !this.dataCategoryId.equals(other.dataCategoryId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.system.demo.model.DataCategory[ dataCategoryId=" + dataCategoryId + " ]";
    }
    
}
