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
@Table(name = "enrollment")
@NamedQueries({
    @NamedQuery(name = "Enrollment.findAll", query = "SELECT e FROM Enrollment e"),
    @NamedQuery(name = "Enrollment.findByPersonId", query = "SELECT e FROM Enrollment e WHERE e.enrollmentPK.personId = :personId"),
    @NamedQuery(name = "Enrollment.findByGroupId", query = "SELECT e FROM Enrollment e WHERE e.enrollmentPK.groupId = :groupId"),
    @NamedQuery(name = "Enrollment.findByModuleId", query = "SELECT e FROM Enrollment e WHERE e.enrollmentPK.moduleId = :moduleId"),
    @NamedQuery(name = "Enrollment.findByProgramPeriodId", query = "SELECT e FROM Enrollment e WHERE e.enrollmentPK.programPeriodId = :programPeriodId"),
    @NamedQuery(name = "Enrollment.findByCourseId", query = "SELECT e FROM Enrollment e WHERE e.enrollmentPK.courseId = :courseId"),
    @NamedQuery(name = "Enrollment.findByEnrollmentState", query = "SELECT e FROM Enrollment e WHERE e.enrollmentState = :enrollmentState")})
public class Enrollment implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EnrollmentPK enrollmentPK;
    @Basic(optional = false)
    @Column(name = "enrollment_state", nullable = false)
    private Character enrollmentState;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "enrollment")
    private Collection<EnrollmentQualification> enrollmentQualificationCollection;
    @JoinColumns({
        @JoinColumn(name = "group_id", referencedColumnName = "group_id", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "module_id", referencedColumnName = "module_id", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "program_period_id", referencedColumnName = "program_period_id", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "course_id", referencedColumnName = "course_id", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private CourseGroupTeaching courseGroupTeaching;
    @JoinColumn(name = "person_id", referencedColumnName = "person_id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Person person;
    @JoinColumn(name = "person_registering_id", referencedColumnName = "person_registering_id", nullable = false)
    @ManyToOne(optional = false)
    private PersonRegistering personRegisteringId;
    @JoinColumn(name = "role_id", referencedColumnName = "role_id", nullable = false)
    @ManyToOne(optional = false)
    private Role roleId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "enrollment")
    private Collection<QualificationRecovery> qualificationRecoveryCollection;

    public Enrollment() {
    }

    public Enrollment(EnrollmentPK enrollmentPK) {
        this.enrollmentPK = enrollmentPK;
    }

    public Enrollment(EnrollmentPK enrollmentPK, Character enrollmentState) {
        this.enrollmentPK = enrollmentPK;
        this.enrollmentState = enrollmentState;
    }

    public Enrollment(long personId, long groupId, long moduleId, long programPeriodId, long courseId) {
        this.enrollmentPK = new EnrollmentPK(personId, groupId, moduleId, programPeriodId, courseId);
    }

    public EnrollmentPK getEnrollmentPK() {
        return enrollmentPK;
    }

    public void setEnrollmentPK(EnrollmentPK enrollmentPK) {
        this.enrollmentPK = enrollmentPK;
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

    public CourseGroupTeaching getCourseGroupTeaching() {
        return courseGroupTeaching;
    }

    public void setCourseGroupTeaching(CourseGroupTeaching courseGroupTeaching) {
        this.courseGroupTeaching = courseGroupTeaching;
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
        hash += (enrollmentPK != null ? enrollmentPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Enrollment)) {
            return false;
        }
        Enrollment other = (Enrollment) object;
        if ((this.enrollmentPK == null && other.enrollmentPK != null) || (this.enrollmentPK != null && !this.enrollmentPK.equals(other.enrollmentPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.system.demo.model.Enrollment[ enrollmentPK=" + enrollmentPK + " ]";
    }
    
}
