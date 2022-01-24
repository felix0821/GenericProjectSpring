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
@Table(name = "interface_view")
@NamedQueries({
    @NamedQuery(name = "InterfaceView.findAll", query = "SELECT i FROM InterfaceView i"),
    @NamedQuery(name = "InterfaceView.findByInterfaceViewId", query = "SELECT i FROM InterfaceView i WHERE i.interfaceViewId = :interfaceViewId"),
    @NamedQuery(name = "InterfaceView.findByInterfaceViewName", query = "SELECT i FROM InterfaceView i WHERE i.interfaceViewName = :interfaceViewName"),
    @NamedQuery(name = "InterfaceView.findByInterfaceViewSite", query = "SELECT i FROM InterfaceView i WHERE i.interfaceViewSite = :interfaceViewSite"),
    @NamedQuery(name = "InterfaceView.findByInterfaceViewIndex", query = "SELECT i FROM InterfaceView i WHERE i.interfaceViewIndex = :interfaceViewIndex")})
public class InterfaceView implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "interface_view_id", nullable = false)
    private Long interfaceViewId;
    @Basic(optional = false)
    @Column(name = "interface_view_name", nullable = false, length = 64)
    private String interfaceViewName;
    @Basic(optional = false)
    @Column(name = "interface_view_site", nullable = false)
    private Character interfaceViewSite;
    @Basic(optional = false)
    @Column(name = "interface_view_index", nullable = false)
    private int interfaceViewIndex;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "interfaceView")
    private Collection<RoleView> roleViewCollection;
    @JoinColumn(name = "resource_id", referencedColumnName = "resource_id")
    @ManyToOne
    private Resource resourceId;

    public InterfaceView() {
    }

    public InterfaceView(Long interfaceViewId) {
        this.interfaceViewId = interfaceViewId;
    }

    public InterfaceView(Long interfaceViewId, String interfaceViewName, Character interfaceViewSite, int interfaceViewIndex) {
        this.interfaceViewId = interfaceViewId;
        this.interfaceViewName = interfaceViewName;
        this.interfaceViewSite = interfaceViewSite;
        this.interfaceViewIndex = interfaceViewIndex;
    }

    public Long getInterfaceViewId() {
        return interfaceViewId;
    }

    public void setInterfaceViewId(Long interfaceViewId) {
        this.interfaceViewId = interfaceViewId;
    }

    public String getInterfaceViewName() {
        return interfaceViewName;
    }

    public void setInterfaceViewName(String interfaceViewName) {
        this.interfaceViewName = interfaceViewName;
    }

    public Character getInterfaceViewSite() {
        return interfaceViewSite;
    }

    public void setInterfaceViewSite(Character interfaceViewSite) {
        this.interfaceViewSite = interfaceViewSite;
    }

    public int getInterfaceViewIndex() {
        return interfaceViewIndex;
    }

    public void setInterfaceViewIndex(int interfaceViewIndex) {
        this.interfaceViewIndex = interfaceViewIndex;
    }

    public Collection<RoleView> getRoleViewCollection() {
        return roleViewCollection;
    }

    public void setRoleViewCollection(Collection<RoleView> roleViewCollection) {
        this.roleViewCollection = roleViewCollection;
    }

    public Resource getResourceId() {
        return resourceId;
    }

    public void setResourceId(Resource resourceId) {
        this.resourceId = resourceId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (interfaceViewId != null ? interfaceViewId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InterfaceView)) {
            return false;
        }
        InterfaceView other = (InterfaceView) object;
        if ((this.interfaceViewId == null && other.interfaceViewId != null) || (this.interfaceViewId != null && !this.interfaceViewId.equals(other.interfaceViewId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.system.demo.model.InterfaceView[ interfaceViewId=" + interfaceViewId + " ]";
    }
    
}
