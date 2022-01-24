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
public class EnrollmentQualificationPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "qualification_criteria_id", nullable = false)
    private long qualificationCriteriaId;
    @Basic(optional = false)
    @Column(name = "user_id", nullable = false)
    private long userId;
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

    public EnrollmentQualificationPK() {
    }

    public EnrollmentQualificationPK(long qualificationCriteriaId, long userId, long groupId, long moduleId, long programPeriodId, long courseId) {
        this.qualificationCriteriaId = qualificationCriteriaId;
        this.userId = userId;
        this.groupId = groupId;
        this.moduleId = moduleId;
        this.programPeriodId = programPeriodId;
        this.courseId = courseId;
    }

    public long getQualificationCriteriaId() {
        return qualificationCriteriaId;
    }

    public void setQualificationCriteriaId(long qualificationCriteriaId) {
        this.qualificationCriteriaId = qualificationCriteriaId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) qualificationCriteriaId;
        hash += (int) userId;
        hash += (int) groupId;
        hash += (int) moduleId;
        hash += (int) programPeriodId;
        hash += (int) courseId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EnrollmentQualificationPK)) {
            return false;
        }
        EnrollmentQualificationPK other = (EnrollmentQualificationPK) object;
        if (this.qualificationCriteriaId != other.qualificationCriteriaId) {
            return false;
        }
        if (this.userId != other.userId) {
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
        return true;
    }

    @Override
    public String toString() {
        return "com.system.demo.model.EnrollmentQualificationPK[ qualificationCriteriaId=" + qualificationCriteriaId + ", userId=" + userId + ", groupId=" + groupId + ", moduleId=" + moduleId + ", programPeriodId=" + programPeriodId + ", courseId=" + courseId + " ]";
    }
    
}
