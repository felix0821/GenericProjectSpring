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
public class RequisitionEnrollmentProgramPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "requisition_detail_id", nullable = false)
    private long requisitionDetailId;
    @Basic(optional = false)
    @Column(name = "person_id", nullable = false)
    private long personId;
    @Basic(optional = false)
    @Column(name = "program_period_id", nullable = false)
    private long programPeriodId;

    public RequisitionEnrollmentProgramPK() {
    }

    public RequisitionEnrollmentProgramPK(long requisitionDetailId, long personId, long programPeriodId) {
        this.requisitionDetailId = requisitionDetailId;
        this.personId = personId;
        this.programPeriodId = programPeriodId;
    }

    public long getRequisitionDetailId() {
        return requisitionDetailId;
    }

    public void setRequisitionDetailId(long requisitionDetailId) {
        this.requisitionDetailId = requisitionDetailId;
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
        hash += (int) requisitionDetailId;
        hash += (int) personId;
        hash += (int) programPeriodId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RequisitionEnrollmentProgramPK)) {
            return false;
        }
        RequisitionEnrollmentProgramPK other = (RequisitionEnrollmentProgramPK) object;
        if (this.requisitionDetailId != other.requisitionDetailId) {
            return false;
        }
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
        return "com.system.demo.model.RequisitionEnrollmentProgramPK[ requisitionDetailId=" + requisitionDetailId + ", personId=" + personId + ", programPeriodId=" + programPeriodId + " ]";
    }
    
}
