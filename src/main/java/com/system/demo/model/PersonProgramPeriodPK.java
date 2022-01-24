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
public class PersonProgramPeriodPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "person_id", nullable = false)
    private long personId;
    @Basic(optional = false)
    @Column(name = "program_period_id", nullable = false)
    private long programPeriodId;

    public PersonProgramPeriodPK() {
    }

    public PersonProgramPeriodPK(long personId, long programPeriodId) {
        this.personId = personId;
        this.programPeriodId = programPeriodId;
    }

    public long getPersonId() {
        return personId;
    }

    public void setPersonId(long personId) {
        this.personId = personId;
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
        hash += (int) personId;
        hash += (int) programPeriodId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PersonProgramPeriodPK)) {
            return false;
        }
        PersonProgramPeriodPK other = (PersonProgramPeriodPK) object;
        if (this.personId != other.personId) {
            return false;
        }
        if (this.programPeriodId != other.programPeriodId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.system.demo.model.PersonProgramPeriodPK[ personId=" + personId + ", programPeriodId=" + programPeriodId + " ]";
    }
    
}
