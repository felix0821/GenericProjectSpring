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
public class ProgramDataPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "program_id")
    private long programId;
    @Basic(optional = false)
    @Column(name = "data_id")
    private long dataId;

    public ProgramDataPK() {
    }

    public ProgramDataPK(long programId, long dataId) {
        this.programId = programId;
        this.dataId = dataId;
    }

    public long getProgramId() {
        return programId;
    }

    public void setProgramId(long programId) {
        this.programId = programId;
    }

    public long getDataId() {
        return dataId;
    }

    public void setDataId(long dataId) {
        this.dataId = dataId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) programId;
        hash += (int) dataId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProgramDataPK)) {
            return false;
        }
        ProgramDataPK other = (ProgramDataPK) object;
        if (this.programId != other.programId) {
            return false;
        }
        if (this.dataId != other.dataId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.system.demo.persistence.entity.ProgramDataPK[ programId=" + programId + ", dataId=" + dataId + " ]";
    }
    
}
