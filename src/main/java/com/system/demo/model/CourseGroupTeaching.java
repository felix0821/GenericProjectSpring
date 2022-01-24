/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.system.demo.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Felix
 */
@Entity
@Table(name = "course_group_teaching")
@NamedQueries({
    @NamedQuery(name = "CourseGroupTeaching.findAll", query = "SELECT c FROM CourseGroupTeaching c"),
    @NamedQuery(name = "CourseGroupTeaching.findByGroupId", query = "SELECT c FROM CourseGroupTeaching c WHERE c.courseGroupTeachingPK.groupId = :groupId"),
    @NamedQuery(name = "CourseGroupTeaching.findByModuleId", query = "SELECT c FROM CourseGroupTeaching c WHERE c.courseGroupTeachingPK.moduleId = :moduleId"),
    @NamedQuery(name = "CourseGroupTeaching.findByProgramPeriodId", query = "SELECT c FROM CourseGroupTeaching c WHERE c.courseGroupTeachingPK.programPeriodId = :programPeriodId"),
    @NamedQuery(name = "CourseGroupTeaching.findByCourseId", query = "SELECT c FROM CourseGroupTeaching c WHERE c.courseGroupTeachingPK.courseId = :courseId"),
    @NamedQuery(name = "CourseGroupTeaching.findByCourseGroupCapacity", query = "SELECT c FROM CourseGroupTeaching c WHERE c.courseGroupCapacity = :courseGroupCapacity"),
    @NamedQuery(name = "CourseGroupTeaching.findByCourseGroupIdentifier", query = "SELECT c FROM CourseGroupTeaching c WHERE c.courseGroupIdentifier = :courseGroupIdentifier"),
    @NamedQuery(name = "CourseGroupTeaching.findByCourseGroupState", query = "SELECT c FROM CourseGroupTeaching c WHERE c.courseGroupState = :courseGroupState"),
    @NamedQuery(name = "CourseGroupTeaching.findByCourseGroupTeachingCurriculum", query = "SELECT c FROM CourseGroupTeaching c WHERE c.courseGroupTeachingCurriculum = :courseGroupTeachingCurriculum")})
public class CourseGroupTeaching implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CourseGroupTeachingPK courseGroupTeachingPK;
    @Basic(optional = false)
    @Column(name = "course_group_capacity", nullable = false)
    private int courseGroupCapacity;
    @Basic(optional = false)
    @Column(name = "course_group_identifier", nullable = false, length = 16)
    private String courseGroupIdentifier;
    @Basic(optional = false)
    @Column(name = "course_group_state", nullable = false)
    private Character courseGroupState;
    @Column(name = "course_group_teaching_curriculum", length = 256)
    private String courseGroupTeachingCurriculum;
    @JoinColumn(name = "course_id", referencedColumnName = "course_id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Course course;
    @JoinColumn(name = "group_id", referencedColumnName = "group_id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private GroupTeaching groupTeaching;
    @JoinColumns({
        @JoinColumn(name = "module_id", referencedColumnName = "module_id", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "program_period_id", referencedColumnName = "program_period_id", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Schedule schedule;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "courseGroupTeaching")
    private Collection<QualificationCriteria> qualificationCriteriaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "courseGroupTeaching")
    private Collection<Enrollment> enrollmentCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "courseGroupTeaching")
    private Collection<HoraryCourseGroup> horaryCourseGroupCollection;

    public CourseGroupTeaching() {
    }

    public CourseGroupTeaching(CourseGroupTeachingPK courseGroupTeachingPK) {
        this.courseGroupTeachingPK = courseGroupTeachingPK;
    }

    public CourseGroupTeaching(CourseGroupTeachingPK courseGroupTeachingPK, int courseGroupCapacity, String courseGroupIdentifier, Character courseGroupState) {
        this.courseGroupTeachingPK = courseGroupTeachingPK;
        this.courseGroupCapacity = courseGroupCapacity;
        this.courseGroupIdentifier = courseGroupIdentifier;
        this.courseGroupState = courseGroupState;
    }

    public CourseGroupTeaching(long groupId, long moduleId, long programPeriodId, long courseId) {
        this.courseGroupTeachingPK = new CourseGroupTeachingPK(groupId, moduleId, programPeriodId, courseId);
    }

    public CourseGroupTeachingPK getCourseGroupTeachingPK() {
        return courseGroupTeachingPK;
    }

    public void setCourseGroupTeachingPK(CourseGroupTeachingPK courseGroupTeachingPK) {
        this.courseGroupTeachingPK = courseGroupTeachingPK;
    }

    public int getCourseGroupCapacity() {
        return courseGroupCapacity;
    }

    public void setCourseGroupCapacity(int courseGroupCapacity) {
        this.courseGroupCapacity = courseGroupCapacity;
    }

    public String getCourseGroupIdentifier() {
        return courseGroupIdentifier;
    }

    public void setCourseGroupIdentifier(String courseGroupIdentifier) {
        this.courseGroupIdentifier = courseGroupIdentifier;
    }

    public Character getCourseGroupState() {
        return courseGroupState;
    }

    public void setCourseGroupState(Character courseGroupState) {
        this.courseGroupState = courseGroupState;
    }

    public String getCourseGroupTeachingCurriculum() {
        return courseGroupTeachingCurriculum;
    }

    public void setCourseGroupTeachingCurriculum(String courseGroupTeachingCurriculum) {
        this.courseGroupTeachingCurriculum = courseGroupTeachingCurriculum;
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

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    public Collection<QualificationCriteria> getQualificationCriteriaCollection() {
        return qualificationCriteriaCollection;
    }

    public void setQualificationCriteriaCollection(Collection<QualificationCriteria> qualificationCriteriaCollection) {
        this.qualificationCriteriaCollection = qualificationCriteriaCollection;
    }

    public Collection<Enrollment> getEnrollmentCollection() {
        return enrollmentCollection;
    }

    public void setEnrollmentCollection(Collection<Enrollment> enrollmentCollection) {
        this.enrollmentCollection = enrollmentCollection;
    }

    public Collection<HoraryCourseGroup> getHoraryCourseGroupCollection() {
        return horaryCourseGroupCollection;
    }

    public void setHoraryCourseGroupCollection(Collection<HoraryCourseGroup> horaryCourseGroupCollection) {
        this.horaryCourseGroupCollection = horaryCourseGroupCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (courseGroupTeachingPK != null ? courseGroupTeachingPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CourseGroupTeaching)) {
            return false;
        }
        CourseGroupTeaching other = (CourseGroupTeaching) object;
        if ((this.courseGroupTeachingPK == null && other.courseGroupTeachingPK != null) || (this.courseGroupTeachingPK != null && !this.courseGroupTeachingPK.equals(other.courseGroupTeachingPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.system.demo.model.CourseGroupTeaching[ courseGroupTeachingPK=" + courseGroupTeachingPK + " ]";
    }
    
}
