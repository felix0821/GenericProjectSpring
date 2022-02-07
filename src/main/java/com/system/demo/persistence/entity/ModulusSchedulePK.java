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
public class ModulusSchedulePK implements Serializable {

    @Basic(optional = false)
    @Column(name = "modulus_id", nullable = false)
    private long modulusId;
    @Basic(optional = false)
    @Column(name = "program_id", nullable = false)
    private long programId;
    @Basic(optional = false)
    @Column(name = "pedagogical_period_id", nullable = false)
    private long pedagogicalPeriodId;

    public ModulusSchedulePK() {
    }

    public ModulusSchedulePK(long modulusId, long programId, long pedagogicalPeriodId) {
        this.modulusId = modulusId;
        this.programId = programId;
        this.pedagogicalPeriodId = pedagogicalPeriodId;
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

    public long getPedagogicalPeriodId() {
        return pedagogicalPeriodId;
    }

    public void setPedagogicalPeriodId(long pedagogicalPeriodId) {
        this.pedagogicalPeriodId = pedagogicalPeriodId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) modulusId;
        hash += (int) programId;
        hash += (int) pedagogicalPeriodId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ModulusSchedulePK)) {
            return false;
        }
        ModulusSchedulePK other = (ModulusSchedulePK) object;
        if (this.modulusId != other.modulusId) {
            return false;
        }
        if (this.programId != other.programId) {
            return false;
        }
        if (this.pedagogicalPeriodId != other.pedagogicalPeriodId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.system.demo.persistence.entity.ModulusSchedulePK[ modulusId=" + modulusId + ", programId=" + programId + ", pedagogicalPeriodId=" + pedagogicalPeriodId + " ]";
    }
    
}
