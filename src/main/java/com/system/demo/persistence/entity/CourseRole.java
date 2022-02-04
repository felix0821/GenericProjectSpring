/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.system.demo.persistence.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Felix
 */
@Entity
@Table(name = "course_role")
@NamedQueries({
    @NamedQuery(name = "CourseRole.findAll", query = "SELECT c FROM CourseRole c"),
    @NamedQuery(name = "CourseRole.findByCourseDetailId", query = "SELECT c FROM CourseRole c WHERE c.courseRolePK.courseDetailId = :courseDetailId"),
    @NamedQuery(name = "CourseRole.findByRoleId", query = "SELECT c FROM CourseRole c WHERE c.courseRolePK.roleId = :roleId"),
    @NamedQuery(name = "CourseRole.findByCourseRoleRegistrationDate", query = "SELECT c FROM CourseRole c WHERE c.courseRoleRegistrationDate = :courseRoleRegistrationDate"),
    @NamedQuery(name = "CourseRole.findByCourseRoleExpirationDate", query = "SELECT c FROM CourseRole c WHERE c.courseRoleExpirationDate = :courseRoleExpirationDate")})
public class CourseRole implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CourseRolePK courseRolePK;
    @Basic(optional = false)
    @Column(name = "course_role_registration_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date courseRoleRegistrationDate;
    @Basic(optional = false)
    @Column(name = "course_role_expiration_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date courseRoleExpirationDate;
    @JoinColumn(name = "course_detail_id", referencedColumnName = "course_detail_id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private CourseDetail courseDetail;
    @JoinColumn(name = "role_id", referencedColumnName = "role_id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Role role;

    public CourseRole() {
    }

    public CourseRole(CourseRolePK courseRolePK) {
        this.courseRolePK = courseRolePK;
    }

    public CourseRole(CourseRolePK courseRolePK, Date courseRoleRegistrationDate, Date courseRoleExpirationDate) {
        this.courseRolePK = courseRolePK;
        this.courseRoleRegistrationDate = courseRoleRegistrationDate;
        this.courseRoleExpirationDate = courseRoleExpirationDate;
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

    public Date getCourseRoleRegistrationDate() {
        return courseRoleRegistrationDate;
    }

    public void setCourseRoleRegistrationDate(Date courseRoleRegistrationDate) {
        this.courseRoleRegistrationDate = courseRoleRegistrationDate;
    }

    public Date getCourseRoleExpirationDate() {
        return courseRoleExpirationDate;
    }

    public void setCourseRoleExpirationDate(Date courseRoleExpirationDate) {
        this.courseRoleExpirationDate = courseRoleExpirationDate;
    }

    public CourseDetail getCourseDetail() {
        return courseDetail;
    }

    public void setCourseDetail(CourseDetail courseDetail) {
        this.courseDetail = courseDetail;
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
