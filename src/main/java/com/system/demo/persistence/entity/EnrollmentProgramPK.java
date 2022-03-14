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
public class EnrollmentProgramPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "person_id")
    private long personId;
    @Basic(optional = false)
    @Column(name = "program_id")
    private long programId;
    @Basic(optional = false)
    @Column(name = "period_id")
    private long periodId;

    public EnrollmentProgramPK() {
    }

    public EnrollmentProgramPK(long personId, long programId, long periodId) {
        this.personId = personId;
        this.programId = programId;
        this.periodId = periodId;
    }

    public long getPersonId() {
        return personId;
    }

    public void setPersonId(long personId) {
        this.personId = personId;
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
        hash += (int) personId;
        hash += (int) programId;
        hash += (int) periodId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EnrollmentProgramPK)) {
            return false;
        }
        EnrollmentProgramPK other = (EnrollmentProgramPK) object;
        if (this.personId != other.personId) {
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
        return "com.system.demo.persistence.entity.EnrollmentProgramPK[ personId=" + personId + ", programId=" + programId + ", periodId=" + periodId + " ]";
    }
    
}
