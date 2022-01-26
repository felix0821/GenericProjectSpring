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
@Table(name = "enrollment_course")
@NamedQueries({
    @NamedQuery(name = "EnrollmentCourse.findAll", query = "SELECT e FROM EnrollmentCourse e"),
    @NamedQuery(name = "EnrollmentCourse.findByPersonId", query = "SELECT e FROM EnrollmentCourse e WHERE e.enrollmentCoursePK.personId = :personId"),
    @NamedQuery(name = "EnrollmentCourse.findByCourseDetailId", query = "SELECT e FROM EnrollmentCourse e WHERE e.enrollmentCoursePK.courseDetailId = :courseDetailId"),
    @NamedQuery(name = "EnrollmentCourse.findByEnrollmentState", query = "SELECT e FROM EnrollmentCourse e WHERE e.enrollmentState = :enrollmentState")})
public class EnrollmentCourse implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EnrollmentCoursePK enrollmentCoursePK;
    @Basic(optional = false)
    @Column(name = "enrollment_state", nullable = false)
    private Character enrollmentState;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "enrollmentCourse")
    private Collection<EnrollmentQualification> enrollmentQualificationCollection;
    @JoinColumn(name = "course_detail_id", referencedColumnName = "course_detail_id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private CourseDetail courseDetail;
    @JoinColumn(name = "person_id", referencedColumnName = "person_id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Person person;
    @JoinColumn(name = "person_registering_id", referencedColumnName = "person_registering_id", nullable = false)
    @ManyToOne(optional = false)
    private PersonRegistering personRegisteringId;
    @JoinColumn(name = "role_id", referencedColumnName = "role_id", nullable = false)
    @ManyToOne(optional = false)
    private Role roleId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "enrollmentCourse")
    private Collection<QualificationRecovery> qualificationRecoveryCollection;

    public EnrollmentCourse() {
    }

    public EnrollmentCourse(EnrollmentCoursePK enrollmentCoursePK) {
        this.enrollmentCoursePK = enrollmentCoursePK;
    }

    public EnrollmentCourse(EnrollmentCoursePK enrollmentCoursePK, Character enrollmentState) {
        this.enrollmentCoursePK = enrollmentCoursePK;
        this.enrollmentState = enrollmentState;
    }

    public EnrollmentCourse(long personId, long courseDetailId) {
        this.enrollmentCoursePK = new EnrollmentCoursePK(personId, courseDetailId);
    }

    public EnrollmentCoursePK getEnrollmentCoursePK() {
        return enrollmentCoursePK;
    }

    public void setEnrollmentCoursePK(EnrollmentCoursePK enrollmentCoursePK) {
        this.enrollmentCoursePK = enrollmentCoursePK;
    }

    public Character getEnrollmentState() {
        return enrollmentState;
    }

    public void setEnrollmentState(Character enrollmentState) {
        this.enrollmentState = enrollmentState;
    }

    public Collection<EnrollmentQualification> getEnrollmentQualificationCollection() {
        return enrollmentQualificationCollection;
    }

    public void setEnrollmentQualificationCollection(Collection<EnrollmentQualification> enrollmentQualificationCollection) {
        this.enrollmentQualificationCollection = enrollmentQualificationCollection;
    }

    public CourseDetail getCourseDetail() {
        return courseDetail;
    }

    public void setCourseDetail(CourseDetail courseDetail) {
        this.courseDetail = courseDetail;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public PersonRegistering getPersonRegisteringId() {
        return personRegisteringId;
    }

    public void setPersonRegisteringId(PersonRegistering personRegisteringId) {
        this.personRegisteringId = personRegisteringId;
    }

    public Role getRoleId() {
        return roleId;
    }

    public void setRoleId(Role roleId) {
        this.roleId = roleId;
    }

    public Collection<QualificationRecovery> getQualificationRecoveryCollection() {
        return qualificationRecoveryCollection;
    }

    public void setQualificationRecoveryCollection(Collection<QualificationRecovery> qualificationRecoveryCollection) {
        this.qualificationRecoveryCollection = qualificationRecoveryCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (enrollmentCoursePK != null ? enrollmentCoursePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EnrollmentCourse)) {
            return false;
        }
        EnrollmentCourse other = (EnrollmentCourse) object;
        if ((this.enrollmentCoursePK == null && other.enrollmentCoursePK != null) || (this.enrollmentCoursePK != null && !this.enrollmentCoursePK.equals(other.enrollmentCoursePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.system.demo.model.EnrollmentCourse[ enrollmentCoursePK=" + enrollmentCoursePK + " ]";
    }
    
}
