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
public class ModulusDetailPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "modulus_id")
    private long modulusId;
    @Basic(optional = false)
    @Column(name = "program_id")
    private long programId;
    @Basic(optional = false)
    @Column(name = "period_id")
    private long periodId;

    public ModulusDetailPK() {
    }

    public ModulusDetailPK(long modulusId, long programId, long periodId) {
        this.modulusId = modulusId;
        this.programId = programId;
        this.periodId = periodId;
    }

    public long getModulusId() {
        return modulusId;
    }

    public void setModulusId(long modulusId) {
        this.modulusId = modulusId;
    }

    public long getProgramId() {
        return programId;
    }

    public void setProgramId(long programId) {
        this.programId = programId;
    }

    public long getPeriodId() {
        return periodId;
    }

    public void setPeriodId(long periodId) {
        this.periodId = periodId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) modulusId;
        hash += (int) programId;
        hash += (int) periodId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ModulusDetailPK)) {
            return false;
        }
        ModulusDetailPK other = (ModulusDetailPK) object;
        if (this.modulusId != other.modulusId) {
            return false;
        }
        if (this.programId != other.programId) {
            return false;
        }
        if (this.periodId != other.periodId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.system.demo.persistence.entity.ModulusDetailPK[ modulusId=" + modulusId + ", programId=" + programId + ", periodId=" + periodId + " ]";
    }
    
}
