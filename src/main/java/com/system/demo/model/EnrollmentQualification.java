/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.system.demo.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Felix
 */
@Entity
@Table(name = "enrollment_qualification")
@NamedQueries({
    @NamedQuery(name = "EnrollmentQualification.findAll", query = "SELECT e FROM EnrollmentQualification e"),
    @NamedQuery(name = "EnrollmentQualification.findByQualificationCriteriaId", query = "SELECT e FROM EnrollmentQualification e WHERE e.enrollmentQualificationPK.qualificationCriteriaId = :qualificationCriteriaId"),
    @NamedQuery(name = "EnrollmentQualification.findByUserId", query = "SELECT e FROM EnrollmentQualification e WHERE e.enrollmentQualificationPK.userId = :userId"),
    @NamedQuery(name = "EnrollmentQualification.findByGroupId", query = "SELECT e FROM EnrollmentQualification e WHERE e.enrollmentQualificationPK.groupId = :groupId"),
    @NamedQuery(name = "EnrollmentQualification.findByEnrollmentQualificationValue", query = "SELECT e FROM EnrollmentQualification e WHERE e.enrollmentQualificationValue = :enrollmentQualificationValue"),
    @NamedQuery(name = "EnrollmentQualification.findByModuleId", query = "SELECT e FROM EnrollmentQualification e WHERE e.enrollmentQualificationPK.moduleId = :moduleId"),
    @NamedQuery(name = "EnrollmentQualification.findByProgramPeriodId", query = "SELECT e FROM EnrollmentQualification e WHERE e.enrollmentQualificationPK.programPeriodId = :programPeriodId"),
    @NamedQuery(name = "EnrollmentQualification.findByCourseId", query = "SELECT e FROM EnrollmentQualification e WHERE e.enrollmentQualificationPK.courseId = :courseId")})
public class EnrollmentQualification implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EnrollmentQualificationPK enrollmentQualificationPK;
    @Basic(optional = false)
    @Column(name = "enrollment_qualification_value", nullable = false)
    private double enrollmentQualificationValue;
    @JoinColumns({
        @JoinColumn(name = "user_id", referencedColumnName = "person_id", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "group_id", referencedColumnName = "group_id", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "module_id", referencedColumnName = "module_id", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "program_period_id", referencedColumnName = "program_period_id", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "course_id", referencedColumnName = "course_id", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Enrollment enrollment;
    @JoinColumn(name = "evaluated_status_id", referencedColumnName = "evaluated_status_id", nullable = false)
    @ManyToOne(optional = false)
    private EvaluatedStatus evaluatedStatusId;
    @JoinColumn(name = "person_registering_id", referencedColumnName = "person_registering_id", nullable = false)
    @ManyToOne(optional = false)
    private PersonRegistering personRegisteringId;
    @JoinColumn(name = "qualification_criteria_id", referencedColumnName = "qualification_criteria_id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private QualificationCriteria qualificationCriteria;

    public EnrollmentQualification() {
    }

    public EnrollmentQualification(EnrollmentQualificationPK enrollmentQualificationPK) {
        this.enrollmentQualificationPK = enrollmentQualificationPK;
    }

    public EnrollmentQualification(EnrollmentQualificationPK enrollmentQualificationPK, double enrollmentQualificationValue) {
        this.enrollmentQualificationPK = enrollmentQualificationPK;
        this.enrollmentQualificationValue = enrollmentQualificationValue;
    }

    public EnrollmentQualification(long qualificationCriteriaId, long userId, long groupId, long moduleId, long programPeriodId, long courseId) {
        this.enrollmentQualificationPK = new EnrollmentQualificationPK(qualificationCriteriaId, userId, groupId, moduleId, programPeriodId, courseId);
    }

    public EnrollmentQualificationPK getEnrollmentQualificationPK() {
        return enrollmentQualificationPK;
    }

    public void setEnrollmentQualificationPK(EnrollmentQualificationPK enrollmentQualificationPK) {
        this.enrollmentQualificationPK = enrollmentQualificationPK;
    }

    public double getEnrollmentQualificationValue() {
        return enrollmentQualificationValue;
    }

    public void setEnrollmentQualificationValue(double enrollmentQualificationValue) {
        this.enrollmentQualificationValue = enrollmentQualificationValue;
    }

    public Enrollment getEnrollment() {
        return enrollment;
    }

    public void setEnrollment(Enrollment enrollment) {
        this.enrollment = enrollment;
    }

    public EvaluatedStatus getEvaluatedStatusId() {
        return evaluatedStatusId;
    }

    public void setEvaluatedStatusId(EvaluatedStatus evaluatedStatusId) {
        this.evaluatedStatusId = evaluatedStatusId;
    }

    public PersonRegistering getPersonRegisteringId() {
        return personRegisteringId;
    }

    public void setPersonRegisteringId(PersonRegistering personRegisteringId) {
        this.personRegisteringId = personRegisteringId;
    }

    public QualificationCriteria getQualificationCriteria() {
        return qualificationCriteria;
    }

    public void setQualificationCriteria(QualificationCriteria qualificationCriteria) {
        this.qualificationCriteria = qualificationCriteria;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (enrollmentQualificationPK != null ? enrollmentQualificationPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EnrollmentQualification)) {
            return false;
        }
        EnrollmentQualification other = (EnrollmentQualification) object;
        if ((this.enrollmentQualificationPK == null && other.enrollmentQualificationPK != null) || (this.enrollmentQualificationPK != null && !this.enrollmentQualificationPK.equals(other.enrollmentQualificationPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.system.demo.model.EnrollmentQualification[ enrollmentQualificationPK=" + enrollmentQualificationPK + " ]";
    }
    
}
