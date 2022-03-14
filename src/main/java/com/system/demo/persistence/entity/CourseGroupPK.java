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
public class CourseGroupPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "course_id")
    private long courseId;
    @Basic(optional = false)
    @Column(name = "group_id")
    private long groupId;

    public CourseGroupPK() {
    }

    public CourseGroupPK(long courseId, long groupId) {
        this.courseId = courseId;
        this.groupId = groupId;
    }

    public long getCourseId() {
        return courseId;
    }

    public void setCourseId(long courseId) {
        this.courseId = courseId;
    }

    public long getGroupId() {
        return groupId;
    }

    public void setGroupId(long groupId) {
        this.groupId = groupId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) courseId;
        hash += (int) groupId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CourseGroupPK)) {
            return false;
        }
        CourseGroupPK other = (CourseGroupPK) object;
        if (this.courseId != other.courseId) {
            return false;
        }
        if (this.groupId != other.groupId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.system.demo.persistence.entity.CourseGroupPK[ courseId=" + courseId + ", groupId=" + groupId + " ]";
    }
    
}
