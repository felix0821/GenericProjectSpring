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
public class ProgramPeriodPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "program_id", nullable = false)
    private long programId;
    @Basic(optional = false)
    @Column(name = "period_id", nullable = false)
    private long periodId;

    public ProgramPeriodPK() {
    }

    public ProgramPeriodPK(long programId, long periodId) {
        this.programId = programId;
        this.periodId = periodId;
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
        hash += (int) programId;
        hash += (int) periodId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProgramPeriodPK)) {
            return false;
        }
        ProgramPeriodPK other = (ProgramPeriodPK) object;
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
        return "com.system.demo.persistence.entity.ProgramPeriodPK[ programId=" + programId + ", periodId=" + periodId + " ]";
    }
    
}
