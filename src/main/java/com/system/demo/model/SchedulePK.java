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
public class SchedulePK implements Serializable {

    @Basic(optional = false)
    @Column(name = "program_period_id", nullable = false)
    private long programPeriodId;
    @Basic(optional = false)
    @Column(name = "module_id", nullable = false)
    private long moduleId;

    public SchedulePK() {
    }

    public SchedulePK(long programPeriodId, long moduleId) {
        this.programPeriodId = programPeriodId;
        this.moduleId = moduleId;
    }

    public long getProgramPeriodId() {
        return programPeriodId;
    }

    public void setProgramPeriodId(long programPeriodId) {
        this.programPeriodId = programPeriodId;
    }

    public long getModuleId() {
        return moduleId;
    }

    public void setModuleId(long moduleId) {
        this.moduleId = moduleId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) programPeriodId;
        hash += (int) moduleId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SchedulePK)) {
            return false;
        }
        SchedulePK other = (SchedulePK) object;
        if (this.programPeriodId != other.programPeriodId) {
            return false;
        }
        if (this.moduleId != other.moduleId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.system.demo.model.SchedulePK[ programPeriodId=" + programPeriodId + ", moduleId=" + moduleId + " ]";
    }
    
}
