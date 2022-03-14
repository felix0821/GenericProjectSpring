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
public class DataDetailProgramPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "data_detail_id")
    private long dataDetailId;
    @Basic(optional = false)
    @Column(name = "program_id")
    private long programId;

    public DataDetailProgramPK() {
    }

    public DataDetailProgramPK(long dataDetailId, long programId) {
        this.dataDetailId = dataDetailId;
        this.programId = programId;
    }

    public long getDataDetailId() {
        return dataDetailId;
    }

    public void setDataDetailId(long dataDetailId) {
        this.dataDetailId = dataDetailId;
    }

    public long getProgramId() {
        return programId;
    }

    public void setProgramId(long programId) {
        this.programId = programId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) dataDetailId;
        hash += (int) programId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DataDetailProgramPK)) {
            return false;
        }
        DataDetailProgramPK other = (DataDetailProgramPK) object;
        if (this.dataDetailId != other.dataDetailId) {
            return false;
        }
        if (this.programId != other.programId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.system.demo.persistence.entity.DataDetailProgramPK[ dataDetailId=" + dataDetailId + ", programId=" + programId + " ]";
    }
    
}
