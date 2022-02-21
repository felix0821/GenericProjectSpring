/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.system.demo.persistence.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Felix
 */
@Entity
@Table(name = "uses_restriction")
@NamedQueries({
    @NamedQuery(name = "UsesRestriction.findAll", query = "SELECT u FROM UsesRestriction u"),
    @NamedQuery(name = "UsesRestriction.findByUsesId", query = "SELECT u FROM UsesRestriction u WHERE u.usesRestrictionPK.usesId = :usesId"),
    @NamedQuery(name = "UsesRestriction.findByDataReferenceId", query = "SELECT u FROM UsesRestriction u WHERE u.usesRestrictionPK.dataReferenceId = :dataReferenceId"),
    @NamedQuery(name = "UsesRestriction.findByUsesRestrictionState", query = "SELECT u FROM UsesRestriction u WHERE u.usesRestrictionState = :usesRestrictionState")})
public class UsesRestriction implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected UsesRestrictionPK usesRestrictionPK;
    @Basic(optional = false)
    @Column(name = "uses_restriction_state", nullable = false)
    private Character usesRestrictionState;
    @JoinColumn(name = "data_reference_id", referencedColumnName = "data_reference_id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private DataReference dataReference;
    @JoinColumn(name = "uses_id", referencedColumnName = "uses_id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Uses uses;

    public UsesRestriction() {
    }

    public UsesRestriction(UsesRestrictionPK usesRestrictionPK) {
        this.usesRestrictionPK = usesRestrictionPK;
    }

    public UsesRestriction(UsesRestrictionPK usesRestrictionPK, Character usesRestrictionState) {
        this.usesRestrictionPK = usesRestrictionPK;
        this.usesRestrictionState = usesRestrictionState;
    }

    public UsesRestriction(long usesId, long dataReferenceId) {
        this.usesRestrictionPK = new UsesRestrictionPK(usesId, dataReferenceId);
    }

    public UsesRestrictionPK getUsesRestrictionPK() {
        return usesRestrictionPK;
    }

    public void setUsesRestrictionPK(UsesRestrictionPK usesRestrictionPK) {
        this.usesRestrictionPK = usesRestrictionPK;
    }

    public Character getUsesRestrictionState() {
        return usesRestrictionState;
    }

    public void setUsesRestrictionState(Character usesRestrictionState) {
        this.usesRestrictionState = usesRestrictionState;
    }

    public DataReference getDataReference() {
        return dataReference;
    }

    public void setDataReference(DataReference dataReference) {
        this.dataReference = dataReference;
    }

    public Uses getUses() {
        return uses;
    }

    public void setUses(Uses uses) {
        this.uses = uses;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usesRestrictionPK != null ? usesRestrictionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsesRestriction)) {
            return false;
        }
        UsesRestriction other = (UsesRestriction) object;
        if ((this.usesRestrictionPK == null && other.usesRestrictionPK != null) || (this.usesRestrictionPK != null && !this.usesRestrictionPK.equals(other.usesRestrictionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.system.demo.persistence.entity.UsesRestriction[ usesRestrictionPK=" + usesRestrictionPK + " ]";
    }
    
}
