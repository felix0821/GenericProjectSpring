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
import javax.persistence.UniqueConstraint;

/**
 *
 * @author Felix
 */
@Entity
@Table(name = "resource", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"resource_name", "resource_url"})})
@NamedQueries({
    @NamedQuery(name = "Resource.findAll", query = "SELECT r FROM Resource r"),
    @NamedQuery(name = "Resource.findByResourceId", query = "SELECT r FROM Resource r WHERE r.resourceId = :resourceId"),
    @NamedQuery(name = "Resource.findByResourceIndex", query = "SELECT r FROM Resource r WHERE r.resourceIndex = :resourceIndex"),
    @NamedQuery(name = "Resource.findByResourceName", query = "SELECT r FROM Resource r WHERE r.resourceName = :resourceName"),
    @NamedQuery(name = "Resource.findByResourceUrl", query = "SELECT r FROM Resource r WHERE r.resourceUrl = :resourceUrl"),
    @NamedQuery(name = "Resource.findByResourceType", query = "SELECT r FROM Resource r WHERE r.resourceType = :resourceType"),
    @NamedQuery(name = "Resource.findByResourceState", query = "SELECT r FROM Resource r WHERE r.resourceState = :resourceState")})
public class Resource implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "resource_id", nullable = false)
    private Long resourceId;
    @Basic(optional = false)
    @Column(name = "resource_index", nullable = false)
    private int resourceIndex;
    @Basic(optional = false)
    @Column(name = "resource_name", nullable = false, length = 64)
    private String resourceName;
    @Basic(optional = false)
    @Column(name = "resource_url", nullable = false, length = 128)
    private String resourceUrl;
    @Basic(optional = false)
    @Column(name = "resource_type", nullable = false)
    private Character resourceType;
    @Basic(optional = false)
    @Column(name = "resource_state", nullable = false)
    private Character resourceState;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "resource")
    private Collection<Access> accessCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "resource")
    private Collection<ResourceContext> resourceContextCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "resourceId")
    private Collection<InterfaceView> interfaceViewCollection;

    public Resource() {
    }

    public Resource(Long resourceId) {
        this.resourceId = resourceId;
    }

    public Resource(Long resourceId, int resourceIndex, String resourceName, String resourceUrl, Character resourceType, Character resourceState) {
        this.resourceId = resourceId;
        this.resourceIndex = resourceIndex;
        this.resourceName = resourceName;
        this.resourceUrl = resourceUrl;
        this.resourceType = resourceType;
        this.resourceState = resourceState;
    }

    public Long getResourceId() {
        return resourceId;
    }

    public void setResourceId(Long resourceId) {
        this.resourceId = resourceId;
    }

    public int getResourceIndex() {
        return resourceIndex;
    }

    public void setResourceIndex(int resourceIndex) {
        this.resourceIndex = resourceIndex;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public String getResourceUrl() {
        return resourceUrl;
    }

    public void setResourceUrl(String resourceUrl) {
        this.resourceUrl = resourceUrl;
    }

    public Character getResourceType() {
        return resourceType;
    }

    public void setResourceType(Character resourceType) {
        this.resourceType = resourceType;
    }

    public Character getResourceState() {
        return resourceState;
    }

    public void setResourceState(Character resourceState) {
        this.resourceState = resourceState;
    }

    public Collection<Access> getAccessCollection() {
        return accessCollection;
    }

    public void setAccessCollection(Collection<Access> accessCollection) {
        this.accessCollection = accessCollection;
    }

    public Collection<ResourceContext> getResourceContextCollection() {
        return resourceContextCollection;
    }

    public void setResourceContextCollection(Collection<ResourceContext> resourceContextCollection) {
        this.resourceContextCollection = resourceContextCollection;
    }

    public Collection<InterfaceView> getInterfaceViewCollection() {
        return interfaceViewCollection;
    }

    public void setInterfaceViewCollection(Collection<InterfaceView> interfaceViewCollection) {
        this.interfaceViewCollection = interfaceViewCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (resourceId != null ? resourceId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Resource)) {
            return false;
        }
        Resource other = (Resource) object;
        if ((this.resourceId == null && other.resourceId != null) || (this.resourceId != null && !this.resourceId.equals(other.resourceId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.system.demo.persistence.entity.Resource[ resourceId=" + resourceId + " ]";
    }
    
}
