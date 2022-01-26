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
public class ModulusSchedulePK implements Serializable {

    @Basic(optional = false)
    @Column(name = "modulus_id", nullable = false)
    private long modulusId;
    @Basic(optional = false)
    @Column(name = "program_period_id", nullable = false)
    private long programPeriodId;

    public ModulusSchedulePK() {
    }

    public ModulusSchedulePK(long modulusId, long programPeriodId) {
        this.modulusId = modulusId;
        this.programPeriodId = programPeriodId;
    }

    public long getModulusId() {
        return modulusId;
    }

    public void setModulusId(long modulusId) {
        this.modulusId = modulusId;
    }

    public long getProgramPeriodId() {
        return programPeriodId;
    }

    public void setProgramPeriodId(long programPeriodId) {
        this.programPeriodId = programPeriodId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) modulusId;
        hash += (int) programPeriodId;
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
        if (this.programPeriodId != other.programPeriodId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.system.demo.model.ModulusSchedulePK[ modulusId=" + modulusId + ", programPeriodId=" + programPeriodId + " ]";
    }
    
}
