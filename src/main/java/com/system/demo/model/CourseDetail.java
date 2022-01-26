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
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "course_detail")
@NamedQueries({
    @NamedQuery(name = "CourseDetail.findAll", query = "SELECT c FROM CourseDetail c"),
    @NamedQuery(name = "CourseDetail.findByCourseDetailId", query = "SELECT c FROM CourseDetail c WHERE c.courseDetailId = :courseDetailId"),
    @NamedQuery(name = "CourseDetail.findByCourseGroupCapacity", query = "SELECT c FROM CourseDetail c WHERE c.courseGroupCapacity = :courseGroupCapacity"),
    @NamedQuery(name = "CourseDetail.findByCourseGroupIdentifier", query = "SELECT c FROM CourseDetail c WHERE c.courseGroupIdentifier = :courseGroupIdentifier"),
    @NamedQuery(name = "CourseDetail.findByCourseGroupState", query = "SELECT c FROM CourseDetail c WHERE c.courseGroupState = :courseGroupState"),
    @NamedQuery(name = "CourseDetail.findByCourseGroupTeachingCurriculum", query = "SELECT c FROM CourseDetail c WHERE c.courseGroupTeachingCurriculum = :courseGroupTeachingCurriculum")})
public class CourseDetail implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "course_detail_id", nullable = false)
    private Long courseDetailId;
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
    @JoinColumn(name = "course_id", referencedColumnName = "course_id", nullable = false)
    @ManyToOne(optional = false)
    private Course courseId;
    @JoinColumn(name = "group_id", referencedColumnName = "group_id", nullable = false)
    @ManyToOne(optional = false)
    private GroupTeaching groupId;
    @JoinColumns({
        @JoinColumn(name = "modulus_id", referencedColumnName = "modulus_id", nullable = false),
        @JoinColumn(name = "program_period_id", referencedColumnName = "program_period_id", nullable = false)})
    @ManyToOne(optional = false)
    private ModulusSchedule modulusSchedule;
    @OneToMany(mappedBy = "courseDetailId")
    private Collection<QualificationCriteria> qualificationCriteriaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "courseDetail")
    private Collection<EnrollmentCourse> enrollmentCourseCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "courseDetail")
    private Collection<HoraryCourseGroup> horaryCourseGroupCollection;

    public CourseDetail() {
    }

    public CourseDetail(Long courseDetailId) {
        this.courseDetailId = courseDetailId;
    }

    public CourseDetail(Long courseDetailId, int courseGroupCapacity, String courseGroupIdentifier, Character courseGroupState) {
        this.courseDetailId = courseDetailId;
        this.courseGroupCapacity = courseGroupCapacity;
        this.courseGroupIdentifier = courseGroupIdentifier;
        this.courseGroupState = courseGroupState;
    }

    public Long getCourseDetailId() {
        return courseDetailId;
    }

    public void setCourseDetailId(Long courseDetailId) {
        this.courseDetailId = courseDetailId;
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

    public Course getCourseId() {
        return courseId;
    }

    public void setCourseId(Course courseId) {
        this.courseId = courseId;
    }

    public GroupTeaching getGroupId() {
        return groupId;
    }

    public void setGroupId(GroupTeaching groupId) {
        this.groupId = groupId;
    }

    public ModulusSchedule getModulusSchedule() {
        return modulusSchedule;
    }

    public void setModulusSchedule(ModulusSchedule modulusSchedule) {
        this.modulusSchedule = modulusSchedule;
    }

    public Collection<QualificationCriteria> getQualificationCriteriaCollection() {
        return qualificationCriteriaCollection;
    }

    public void setQualificationCriteriaCollection(Collection<QualificationCriteria> qualificationCriteriaCollection) {
        this.qualificationCriteriaCollection = qualificationCriteriaCollection;
    }

    public Collection<EnrollmentCourse> getEnrollmentCourseCollection() {
        return enrollmentCourseCollection;
    }

    public void setEnrollmentCourseCollection(Collection<EnrollmentCourse> enrollmentCourseCollection) {
        this.enrollmentCourseCollection = enrollmentCourseCollection;
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
        hash += (courseDetailId != null ? courseDetailId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CourseDetail)) {
            return false;
        }
        CourseDetail other = (CourseDetail) object;
        if ((this.courseDetailId == null && other.courseDetailId != null) || (this.courseDetailId != null && !this.courseDetailId.equals(other.courseDetailId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.system.demo.model.CourseDetail[ courseDetailId=" + courseDetailId + " ]";
    }
    
}
