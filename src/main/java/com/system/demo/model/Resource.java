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
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 *
 * @author Felix
 */
@Entity
@Table(name = "resource")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Resource.findAll", query = "SELECT r FROM Resource r"),
    @NamedQuery(name = "Resource.findByIdResource", query = "SELECT r FROM Resource r WHERE r.idResource = :idResource"),
    @NamedQuery(name = "Resource.findByUrlName", query = "SELECT r FROM Resource r WHERE r.urlName = :urlName"),
    @NamedQuery(name = "Resource.findByDescription", query = "SELECT r FROM Resource r WHERE r.description = :description"),
    @NamedQuery(name = "Resource.findByState", query = "SELECT r FROM Resource r WHERE r.state = :state")})
public class Resource implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_resource")
    private Long idResource;
    @Basic(optional = false)
    @Column(name = "url_name")
    private String urlName;
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @Column(name = "state")
    private Character state;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "resource", fetch = FetchType.EAGER)
    private Collection<Access> accessCollection;

    public Resource() {
    }

    public Resource(Long idResource) {
        this.idResource = idResource;
    }

    public Resource(Long idResource, String urlName, Character state) {
        this.idResource = idResource;
        this.urlName = urlName;
        this.state = state;
    }

    public Long getIdResource() {
        return idResource;
    }

    public void setIdResource(Long idResource) {
        this.idResource = idResource;
    }

    public String getUrlName() {
        return urlName;
    }

    public void setUrlName(String urlName) {
        this.urlName = urlName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Character getState() {
        return state;
    }

    public void setState(Character state) {
        this.state = state;
    }

    @XmlTransient
    public Collection<Access> getAccessCollection() {
        return accessCollection;
    }

    public void setAccessCollection(Collection<Access> accessCollection) {
        this.accessCollection = accessCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idResource != null ? idResource.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Resource)) {
            return false;
        }
        Resource other = (Resource) object;
        if ((this.idResource == null && other.idResource != null) || (this.idResource != null && !this.idResource.equals(other.idResource))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "vacancies_application_system.Resource[ idResource=" + idResource + " ]";
    }
    
}
