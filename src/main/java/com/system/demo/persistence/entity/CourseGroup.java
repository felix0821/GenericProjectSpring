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
@Table(name = "course_group")
@NamedQueries({
    @NamedQuery(name = "CourseGroup.findAll", query = "SELECT c FROM CourseGroup c"),
    @NamedQuery(name = "CourseGroup.findByCourseId", query = "SELECT c FROM CourseGroup c WHERE c.courseGroupPK.courseId = :courseId"),
    @NamedQuery(name = "CourseGroup.findByGroupId", query = "SELECT c FROM CourseGroup c WHERE c.courseGroupPK.groupId = :groupId"),
    @NamedQuery(name = "CourseGroup.findByCourseGroupState", query = "SELECT c FROM CourseGroup c WHERE c.courseGroupState = :courseGroupState")})
public class CourseGroup implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CourseGroupPK courseGroupPK;
    @Basic(optional = false)
    @Column(name = "course_group_state", nullable = false, length = 20)
    private String courseGroupState;
    @JoinColumn(name = "course_id", referencedColumnName = "course_id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Course course;
    @JoinColumn(name = "group_id", referencedColumnName = "group_id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private GroupTeaching groupTeaching;

    public CourseGroup() {
    }

    public CourseGroup(CourseGroupPK courseGroupPK) {
        this.courseGroupPK = courseGroupPK;
    }

    public CourseGroup(CourseGroupPK courseGroupPK, String courseGroupState) {
        this.courseGroupPK = courseGroupPK;
        this.courseGroupState = courseGroupState;
    }

    public CourseGroup(long courseId, long groupId) {
        this.courseGroupPK = new CourseGroupPK(courseId, groupId);
    }

    public CourseGroupPK getCourseGroupPK() {
        return courseGroupPK;
    }

    public void setCourseGroupPK(CourseGroupPK courseGroupPK) {
        this.courseGroupPK = courseGroupPK;
    }

    public String getCourseGroupState() {
        return courseGroupState;
    }

    public void setCourseGroupState(String courseGroupState) {
        this.courseGroupState = courseGroupState;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public GroupTeaching getGroupTeaching() {
        return groupTeaching;
    }

    public void setGroupTeaching(GroupTeaching groupTeaching) {
        this.groupTeaching = groupTeaching;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (courseGroupPK != null ? courseGroupPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CourseGroup)) {
            return false;
        }
        CourseGroup other = (CourseGroup) object;
        if ((this.courseGroupPK == null && other.courseGroupPK != null) || (this.courseGroupPK != null && !this.courseGroupPK.equals(other.courseGroupPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.system.demo.persistence.entity.CourseGroup[ courseGroupPK=" + courseGroupPK + " ]";
    }
    
}
