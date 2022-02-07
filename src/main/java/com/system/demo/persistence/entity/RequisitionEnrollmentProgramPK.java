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
public class RequisitionEnrollmentProgramPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "requisition_detail_id", nullable = false)
    private long requisitionDetailId;
    @Basic(optional = false)
    @Column(name = "person_id", nullable = false)
    private long personId;
    @Basic(optional = false)
    @Column(name = "program_id", nullable = false)
    private long programId;
    @Basic(optional = false)
    @Column(name = "pedagogical_period_id", nullable = false)
    private long pedagogicalPeriodId;

    public RequisitionEnrollmentProgramPK() {
    }

    public RequisitionEnrollmentProgramPK(long requisitionDetailId, long personId, long programId, long pedagogicalPeriodId) {
        this.requisitionDetailId = requisitionDetailId;
        this.personId = personId;
        this.programId = programId;
        this.pedagogicalPeriodId = pedagogicalPeriodId;
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
        hash += (int) requisitionDetailId;
        hash += (int) personId;
        hash += (int) programId;
        hash += (int) pedagogicalPeriodId;
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
        return "com.system.demo.persistence.entity.RequisitionEnrollmentProgramPK[ requisitionDetailId=" + requisitionDetailId + ", personId=" + personId + ", programId=" + programId + ", pedagogicalPeriodId=" + pedagogicalPeriodId + " ]";
    }
    
}
