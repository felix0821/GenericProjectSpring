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
    @Column(name = "program_period_id", nullable = false)
    private long programPeriodId;
    @Basic(optional = false)
    @Column(name = "modulus_id", nullable = false)
    private long modulusId;

    public ModulusSchedulePK() {
    }

    public ModulusSchedulePK(long programPeriodId, long modulusId) {
        this.programPeriodId = programPeriodId;
        this.modulusId = modulusId;
    }

    public long getProgramPeriodId() {
        return programPeriodId;
    }

    public void setProgramPeriodId(long programPeriodId) {
        this.programPeriodId = programPeriodId;
    }

    public long getModulusId() {
        return modulusId;
    }

    public void setModulusId(long modulusId) {
        this.modulusId = modulusId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) programPeriodId;
        hash += (int) modulusId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ModulusSchedulePK)) {
            return false;
        }
        ModulusSchedulePK other = (ModulusSchedulePK) object;
        if (this.programPeriodId != other.programPeriodId) {
            return false;
        }
        if (this.modulusId != other.modulusId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.system.demo.persistence.entity.ModulusSchedulePK[ programPeriodId=" + programPeriodId + ", modulusId=" + modulusId + " ]";
    }
    
}
