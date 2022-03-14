/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.system.demo.persistence.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Felix
 */
@Embeddable
public class UsesRestrictionPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "uses_id")
    private long usesId;
    @Basic(optional = false)
    @Column(name = "data_reference_id")
    private long dataReferenceId;

    public UsesRestrictionPK() {
    }

    public UsesRestrictionPK(long usesId, long dataReferenceId) {
        this.usesId = usesId;
        this.dataReferenceId = dataReferenceId;
    }

    public long getUsesId() {
        return usesId;
    }

    public void setUsesId(long usesId) {
        this.usesId = usesId;
    }

    public long getDataReferenceId() {
        return dataReferenceId;
    }

    public void setDataReferenceId(long dataReferenceId) {
        this.dataReferenceId = dataReferenceId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) usesId;
        hash += (int) dataReferenceId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsesRestrictionPK)) {
            return false;
        }
        UsesRestrictionPK other = (UsesRestrictionPK) object;
        if (this.usesId != other.usesId) {
            return false;
        }
        if (this.dataReferenceId != other.dataReferenceId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.system.demo.persistence.entity.UsesRestrictionPK[ usesId=" + usesId + ", dataReferenceId=" + dataReferenceId + " ]";
    }
    
}
