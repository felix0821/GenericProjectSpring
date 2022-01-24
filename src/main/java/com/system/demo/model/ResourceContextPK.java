/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.system.demo.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Felix
 */
@Embeddable
public class ResourceContextPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "context_id", nullable = false)
    private long contextId;
    @Basic(optional = false)
    @Column(name = "resource_id", nullable = false)
    private long resourceId;

    public ResourceContextPK() {
    }

    public ResourceContextPK(long contextId, long resourceId) {
        this.contextId = contextId;
        this.resourceId = resourceId;
    }

    public long getContextId() {
        return contextId;
    }

    public void setContextId(long contextId) {
        this.contextId = contextId;
    }

    public long getResourceId() {
        return resourceId;
    }

    public void setResourceId(long resourceId) {
        this.resourceId = resourceId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) contextId;
        hash += (int) resourceId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ResourceContextPK)) {
            return false;
        }
        ResourceContextPK other = (ResourceContextPK) object;
        if (this.contextId != other.contextId) {
            return false;
        }
        if (this.resourceId != other.resourceId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.system.demo.model.ResourceContextPK[ contextId=" + contextId + ", resourceId=" + resourceId + " ]";
    }
    
}
