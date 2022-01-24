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
public class AssistancePK implements Serializable {

    @Basic(optional = false)
    @Column(name = "horary_id", nullable = false)
    private long horaryId;
    @Basic(optional = false)
    @Column(name = "group_id", nullable = false)
    private long groupId;
    @Basic(optional = false)
    @Column(name = "module_id", nullable = false)
    private long moduleId;
    @Basic(optional = false)
    @Column(name = "program_period_id", nullable = false)
    private long programPeriodId;
    @Basic(optional = false)
    @Column(name = "course_id", nullable = false)
    private long courseId;
    @Basic(optional = false)
    @Column(name = "person_id", nullable = false)
    private long personId;

    public AssistancePK() {
    }

    public AssistancePK(long horaryId, long groupId, long moduleId, long programPeriodId, long courseId, long personId) {
        this.horaryId = horaryId;
        this.groupId = groupId;
        this.moduleId = moduleId;
        this.programPeriodId = programPeriodId;
        this.courseId = courseId;
        this.personId = personId;
    }

    public long getHoraryId() {
        return horaryId;
    }

    public void setHoraryId(long horaryId) {
        this.horaryId = horaryId;
    }

    public long getGroupId() {
        return groupId;
    }

    public void setGroupId(long groupId) {
        this.groupId = groupId;
    }

    public long getModuleId() {
        return moduleId;
    }

    public void setModuleId(long moduleId) {
        this.moduleId = moduleId;
    }

    public long getProgramPeriodId() {
        return programPeriodId;
    }

    public void setProgramPeriodId(long programPeriodId) {
        this.programPeriodId = programPeriodId;
    }

    public long getCourseId() {
        return courseId;
    }

    public void setCourseId(long courseId) {
        this.courseId = courseId;
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
        hash += (int) horaryId;
        hash += (int) groupId;
        hash += (int) moduleId;
        hash += (int) programPeriodId;
        hash += (int) courseId;
        hash += (int) personId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AssistancePK)) {
            return false;
        }
        AssistancePK other = (AssistancePK) object;
        if (this.horaryId != other.horaryId) {
            return false;
        }
        if (this.groupId != other.groupId) {
            return false;
        }
        if (this.moduleId != other.moduleId) {
            return false;
        }
        if (this.programPeriodId != other.programPeriodId) {
            return false;
        }
        if (this.courseId != other.courseId) {
            return false;
        }
        if (this.personId != other.personId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.system.demo.model.AssistancePK[ horaryId=" + horaryId + ", groupId=" + groupId + ", moduleId=" + moduleId + ", programPeriodId=" + programPeriodId + ", courseId=" + courseId + ", personId=" + personId + " ]";
    }
    
}
