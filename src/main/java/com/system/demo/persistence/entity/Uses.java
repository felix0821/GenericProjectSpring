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
@Table(name = "uses", catalog = "ucps_system", schema = "public")
@NamedQueries({
    @NamedQuery(name = "Uses.findAll", query = "SELECT u FROM Uses u"),
    @NamedQuery(name = "Uses.findByUsesId", query = "SELECT u FROM Uses u WHERE u.usesId = :usesId"),
    @NamedQuery(name = "Uses.findByUsesName", query = "SELECT u FROM Uses u WHERE u.usesName = :usesName"),
    @NamedQuery(name = "Uses.findByUsesDescription", query = "SELECT u FROM Uses u WHERE u.usesDescription = :usesDescription")})
public class Uses implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "uses_id")
    private Long usesId;
    @Basic(optional = false)
    @Column(name = "uses_name")
    private String usesName;
    @Column(name = "uses_description")
    private String usesDescription;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "uses")
    private Collection<UsesRestriction> usesRestrictionCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "uses")
    private Collection<RequisitionUses> requisitionUsesCollection;

    public Uses() {
    }

    public Uses(Long usesId) {
        this.usesId = usesId;
    }

    public Uses(Long usesId, String usesName) {
        this.usesId = usesId;
        this.usesName = usesName;
    }

    public Long getUsesId() {
        return usesId;
    }

    public void setUsesId(Long usesId) {
        this.usesId = usesId;
    }

    public String getUsesName() {
        return usesName;
    }

    public void setUsesName(String usesName) {
        this.usesName = usesName;
    }

    public String getUsesDescription() {
        return usesDescription;
    }

    public void setUsesDescription(String usesDescription) {
        this.usesDescription = usesDescription;
    }

    public Collection<UsesRestriction> getUsesRestrictionCollection() {
        return usesRestrictionCollection;
    }

    public void setUsesRestrictionCollection(Collection<UsesRestriction> usesRestrictionCollection) {
        this.usesRestrictionCollection = usesRestrictionCollection;
    }

    public Collection<RequisitionUses> getRequisitionUsesCollection() {
        return requisitionUsesCollection;
    }

    public void setRequisitionUsesCollection(Collection<RequisitionUses> requisitionUsesCollection) {
        this.requisitionUsesCollection = requisitionUsesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usesId != null ? usesId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Uses)) {
            return false;
        }
        Uses other = (Uses) object;
        if ((this.usesId == null && other.usesId != null) || (this.usesId != null && !this.usesId.equals(other.usesId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.system.demo.persistence.entity.Uses[ usesId=" + usesId + " ]";
    }
    
}
