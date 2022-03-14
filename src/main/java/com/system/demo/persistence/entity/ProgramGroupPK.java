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
public class ProgramGroupPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "program_id")
    private long programId;
    @Basic(optional = false)
    @Column(name = "group_id")
    private long groupId;

    public ProgramGroupPK() {
    }

    public ProgramGroupPK(long programId, long groupId) {
        this.programId = programId;
        this.groupId = groupId;
    }

    public long getProgramId() {
        return programId;
    }

    public void setProgramId(long programId) {
        this.programId = programId;
    }

    public long getGroupId() {
        return groupId;
    }

    public void setGroupId(long groupId) {
        this.groupId = groupId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) programId;
        hash += (int) groupId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProgramGroupPK)) {
            return false;
        }
        ProgramGroupPK other = (ProgramGroupPK) object;
        if (this.programId != other.programId) {
            return false;
        }
        if (this.groupId != other.groupId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.system.demo.persistence.entity.ProgramGroupPK[ programId=" + programId + ", groupId=" + groupId + " ]";
    }
    
}
