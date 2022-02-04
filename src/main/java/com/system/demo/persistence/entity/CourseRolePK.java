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
public class CourseRolePK implements Serializable {

    @Basic(optional = false)
    @Column(name = "course_detail_id", nullable = false)
    private long courseDetailId;
    @Basic(optional = false)
    @Column(name = "role_id", nullable = false)
    private long roleId;

    public CourseRolePK() {
    }

    public CourseRolePK(long courseDetailId, long roleId) {
        this.courseDetailId = courseDetailId;
        this.roleId = roleId;
    }

    public long getCourseDetailId() {
        return courseDetailId;
    }

    public void setCourseDetailId(long courseDetailId) {
        this.courseDetailId = courseDetailId;
    }

    public long getRoleId() {
        return roleId;
    }

    public void setRoleId(long roleId) {
        this.roleId = roleId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) courseDetailId;
        hash += (int) roleId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CourseRolePK)) {
            return false;
        }
        CourseRolePK other = (CourseRolePK) object;
        if (this.courseDetailId != other.courseDetailId) {
            return false;
        }
        if (this.roleId != other.roleId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.system.demo.persistence.entity.CourseRolePK[ courseDetailId=" + courseDetailId + ", roleId=" + roleId + " ]";
    }
    
}
