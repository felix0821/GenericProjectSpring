/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.system.demo.persistence.entity;

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
import javax.persistence.UniqueConstraint;

/**
 *
 * @author Felix
 */
@Entity
@Table(name = "course_detail", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"group_id", "course_id", "modulus_id", "program_id", "period_id"})})
@NamedQueries({
    @NamedQuery(name = "CourseDetail.findAll", query = "SELECT c FROM CourseDetail c"),
    @NamedQuery(name = "CourseDetail.findByCourseDetailId", query = "SELECT c FROM CourseDetail c WHERE c.courseDetailId = :courseDetailId"),
    @NamedQuery(name = "CourseDetail.findByCourseDetailCapacity", query = "SELECT c FROM CourseDetail c WHERE c.courseDetailCapacity = :courseDetailCapacity"),
    @NamedQuery(name = "CourseDetail.findByCourseDetailTeachingCurriculum", query = "SELECT c FROM CourseDetail c WHERE c.courseDetailTeachingCurriculum = :courseDetailTeachingCurriculum"),
    @NamedQuery(name = "CourseDetail.findByCourseDetailState", query = "SELECT c FROM CourseDetail c WHERE c.courseDetailState = :courseDetailState")})
public class CourseDetail implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "course_detail_id", nullable = false)
    private Long courseDetailId;
    @Basic(optional = false)
    @Column(name = "course_detail_capacity", nullable = false)
    private int courseDetailCapacity;
    @Column(name = "course_detail_teaching_curriculum", length = 256)
    private String courseDetailTeachingCurriculum;
    @Basic(optional = false)
    @Column(name = "course_detail_state", nullable = false)
    private Character courseDetailState;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "courseDetail")
    private Collection<CourseRole> courseRoleCollection;
    @JoinColumn(name = "course_id", referencedColumnName = "course_id", nullable = false)
    @ManyToOne(optional = false)
    private Course courseId;
    @JoinColumn(name = "group_id", referencedColumnName = "group_id", nullable = false)
    @ManyToOne(optional = false)
    private GroupTeaching groupId;
    @JoinColumns({
        @JoinColumn(name = "modulus_id", referencedColumnName = "modulus_id", nullable = false),
        @JoinColumn(name = "program_id", referencedColumnName = "program_id", nullable = false),
        @JoinColumn(name = "period_id", referencedColumnName = "period_id", nullable = false)})
    @ManyToOne(optional = false)
    private ModulusDetail modulusDetail;
    @JoinColumn(name = "schedule_id", referencedColumnName = "schedule_id")
    @ManyToOne
    private Schedule scheduleId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "courseDetailId")
    private Collection<QualificationCriteria> qualificationCriteriaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "courseDetail")
    private Collection<EnrollmentCourse> enrollmentCourseCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "courseDetailId")
    private Collection<Horary> horaryCollection;

    public CourseDetail() {
    }

    public CourseDetail(Long courseDetailId) {
        this.courseDetailId = courseDetailId;
    }

    public CourseDetail(Long courseDetailId, int courseDetailCapacity, Character courseDetailState) {
        this.courseDetailId = courseDetailId;
        this.courseDetailCapacity = courseDetailCapacity;
        this.courseDetailState = courseDetailState;
    }

    public Long getCourseDetailId() {
        return courseDetailId;
    }

    public void setCourseDetailId(Long courseDetailId) {
        this.courseDetailId = courseDetailId;
    }

    public int getCourseDetailCapacity() {
        return courseDetailCapacity;
    }

    public void setCourseDetailCapacity(int courseDetailCapacity) {
        this.courseDetailCapacity = courseDetailCapacity;
    }

    public String getCourseDetailTeachingCurriculum() {
        return courseDetailTeachingCurriculum;
    }

    public void setCourseDetailTeachingCurriculum(String courseDetailTeachingCurriculum) {
        this.courseDetailTeachingCurriculum = courseDetailTeachingCurriculum;
    }

    public Character getCourseDetailState() {
        return courseDetailState;
    }

    public void setCourseDetailState(Character courseDetailState) {
        this.courseDetailState = courseDetailState;
    }

    public Collection<CourseRole> getCourseRoleCollection() {
        return courseRoleCollection;
    }

    public void setCourseRoleCollection(Collection<CourseRole> courseRoleCollection) {
        this.courseRoleCollection = courseRoleCollection;
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

    public ModulusDetail getModulusDetail() {
        return modulusDetail;
    }

    public void setModulusDetail(ModulusDetail modulusDetail) {
        this.modulusDetail = modulusDetail;
    }

    public Schedule getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(Schedule scheduleId) {
        this.scheduleId = scheduleId;
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

    public Collection<Horary> getHoraryCollection() {
        return horaryCollection;
    }

    public void setHoraryCollection(Collection<Horary> horaryCollection) {
        this.horaryCollection = horaryCollection;
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
        return "com.system.demo.persistence.entity.CourseDetail[ courseDetailId=" + courseDetailId + " ]";
    }
    
}
