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
public class EnrollmentProgramPeriodPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "program_period_id", nullable = false)
    private long programPeriodId;
    @Basic(optional = false)
    @Column(name = "person_id", nullable = false)
    private long personId;

    public EnrollmentProgramPeriodPK() {
    }

    public EnrollmentProgramPeriodPK(long programPeriodId, long personId) {
        this.programPeriodId = programPeriodId;
        this.personId = personId;
    }

    public long getProgramPeriodId() {
        return programPeriodId;
    }

    public void setProgramPeriodId(long programPeriodId) {
        this.programPeriodId = programPeriodId;
    }

    public long getPersonId() {
        return personId;
    }

    public void setPersonId(long personId) {
        this.personId = personId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) programPeriodId;
        hash += (int) personId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EnrollmentProgramPeriodPK)) {
            return false;
        }
        EnrollmentProgramPeriodPK other = (EnrollmentProgramPeriodPK) object;
        if (this.programPeriodId != other.programPeriodId) {
            return false;
        }
        if (this.personId != other.personId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.system.demo.persistence.entity.EnrollmentProgramPeriodPK[ programPeriodId=" + programPeriodId + ", personId=" + personId + " ]";
    }
    
}
