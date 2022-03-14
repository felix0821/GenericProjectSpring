/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.system.demo.persistence.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Felix
 */
@Entity
@Table(name = "course_role", catalog = "ucps_system", schema = "public")
@NamedQueries({
    @NamedQuery(name = "CourseRole.findAll", query = "SELECT c FROM CourseRole c"),
    @NamedQuery(name = "CourseRole.findByCourseDetailId", query = "SELECT c FROM CourseRole c WHERE c.courseRolePK.courseDetailId = :courseDetailId"),
    @NamedQuery(name = "CourseRole.findByRoleId", query = "SELECT c FROM CourseRole c WHERE c.courseRolePK.roleId = :roleId"),
    @NamedQuery(name = "CourseRole.findByCourseRoleEnroll", query = "SELECT c FROM CourseRole c WHERE c.courseRoleEnroll = :courseRoleEnroll"),
    @NamedQuery(name = "CourseRole.findByCourseRoleState", query = "SELECT c FROM CourseRole c WHERE c.courseRoleState = :courseRoleState")})
public class CourseRole implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CourseRolePK courseRolePK;
    @Basic(optional = false)
    @Column(name = "course_role_enroll")
    private boolean courseRoleEnroll;
    @Basic(optional = false)
    @Column(name = "course_role_state")
    private Character courseRoleState;
    @JoinColumn(name = "course_detail_id", referencedColumnName = "course_detail_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private CourseDetail courseDetail;
    @JoinColumn(name = "schedule_id", referencedColumnName = "schedule_id")
    @ManyToOne
    private ModulusSchedule scheduleId;
    @JoinColumn(name = "role_id", referencedColumnName = "role_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Role role;

    public CourseRole() {
    }

    public CourseRole(CourseRolePK courseRolePK) {
        this.courseRolePK = courseRolePK;
    }

    public CourseRole(CourseRolePK courseRolePK, boolean courseRoleEnroll, Character courseRoleState) {
        this.courseRolePK = courseRolePK;
        this.courseRoleEnroll = courseRoleEnroll;
        this.courseRoleState = courseRoleState;
    }

    public CourseRole(long courseDetailId, long roleId) {
        this.courseRolePK = new CourseRolePK(courseDetailId, roleId);
    }

    public CourseRolePK getCourseRolePK() {
        return courseRolePK;
    }

    public void setCourseRolePK(CourseRolePK courseRolePK) {
        this.courseRolePK = courseRolePK;
    }

    public boolean getCourseRoleEnroll() {
        return courseRoleEnroll;
    }

    public void setCourseRoleEnroll(boolean courseRoleEnroll) {
        this.courseRoleEnroll = courseRoleEnroll;
    }

    public Character getCourseRoleState() {
        return courseRoleState;
    }

    public void setCourseRoleState(Character courseRoleState) {
        this.courseRoleState = courseRoleState;
    }

    public CourseDetail getCourseDetail() {
        return courseDetail;
    }

    public void setCourseDetail(CourseDetail courseDetail) {
        this.courseDetail = courseDetail;
    }

    public ModulusSchedule getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(ModulusSchedule scheduleId) {
        this.scheduleId = scheduleId;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (courseRolePK != null ? courseRolePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CourseRole)) {
            return false;
        }
        CourseRole other = (CourseRole) object;
        if ((this.courseRolePK == null && other.courseRolePK != null) || (this.courseRolePK != null && !this.courseRolePK.equals(other.courseRolePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.system.demo.persistence.entity.CourseRole[ courseRolePK=" + courseRolePK + " ]";
    }
    
}
