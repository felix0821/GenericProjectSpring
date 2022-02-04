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
@Table(name = "interface_view")
@NamedQueries({
    @NamedQuery(name = "InterfaceView.findAll", query = "SELECT i FROM InterfaceView i"),
    @NamedQuery(name = "InterfaceView.findByInterfaceViewId", query = "SELECT i FROM InterfaceView i WHERE i.interfaceViewId = :interfaceViewId"),
    @NamedQuery(name = "InterfaceView.findByInterfaceViewIndex", query = "SELECT i FROM InterfaceView i WHERE i.interfaceViewIndex = :interfaceViewIndex"),
    @NamedQuery(name = "InterfaceView.findByInterfaceViewName", query = "SELECT i FROM InterfaceView i WHERE i.interfaceViewName = :interfaceViewName"),
    @NamedQuery(name = "InterfaceView.findByInterfaceViewSite", query = "SELECT i FROM InterfaceView i WHERE i.interfaceViewSite = :interfaceViewSite")})
public class InterfaceView implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "interface_view_id", nullable = false)
    private Long interfaceViewId;
    @Basic(optional = false)
    @Column(name = "interface_view_index", nullable = false)
    private int interfaceViewIndex;
    @Basic(optional = false)
    @Column(name = "interface_view_name", nullable = false, length = 64)
    private String interfaceViewName;
    @Basic(optional = false)
    @Column(name = "interface_view_site", nullable = false)
    private Character interfaceViewSite;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "interfaceView")
    private Collection<RoleView> roleViewCollection;
    @OneToMany(mappedBy = "parentInterfaceViewId")
    private Collection<InterfaceView> interfaceViewCollection;
    @JoinColumn(name = "parent_interface_view_id", referencedColumnName = "interface_view_id")
    @ManyToOne
    private InterfaceView parentInterfaceViewId;
    @JoinColumn(name = "resource_id", referencedColumnName = "resource_id", nullable = false)
    @ManyToOne(optional = false)
    private Resource resourceId;

    public InterfaceView() {
    }

    public InterfaceView(Long interfaceViewId) {
        this.interfaceViewId = interfaceViewId;
    }

    public InterfaceView(Long interfaceViewId, int interfaceViewIndex, String interfaceViewName, Character interfaceViewSite) {
        this.interfaceViewId = interfaceViewId;
        this.interfaceViewIndex = interfaceViewIndex;
        this.interfaceViewName = interfaceViewName;
        this.interfaceViewSite = interfaceViewSite;
    }

    public Long getInterfaceViewId() {
        return interfaceViewId;
    }

    public void setInterfaceViewId(Long interfaceViewId) {
        this.interfaceViewId = interfaceViewId;
    }

    public int getInterfaceViewIndex() {
        return interfaceViewIndex;
    }

    public void setInterfaceViewIndex(int interfaceViewIndex) {
        this.interfaceViewIndex = interfaceViewIndex;
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

    public Collection<RoleView> getRoleViewCollection() {
        return roleViewCollection;
    }

    public void setRoleViewCollection(Collection<RoleView> roleViewCollection) {
        this.roleViewCollection = roleViewCollection;
    }

    public Collection<InterfaceView> getInterfaceViewCollection() {
        return interfaceViewCollection;
    }

    public void setInterfaceViewCollection(Collection<InterfaceView> interfaceViewCollection) {
        this.interfaceViewCollection = interfaceViewCollection;
    }

    public InterfaceView getParentInterfaceViewId() {
        return parentInterfaceViewId;
    }

    public void setParentInterfaceViewId(InterfaceView parentInterfaceViewId) {
        this.parentInterfaceViewId = parentInterfaceViewId;
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
        return "com.system.demo.persistence.entity.InterfaceView[ interfaceViewId=" + interfaceViewId + " ]";
    }
    
}
