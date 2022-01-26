/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.system.demo.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "qualification_recovery")
@NamedQueries({
    @NamedQuery(name = "QualificationRecovery.findAll", query = "SELECT q FROM QualificationRecovery q"),
    @NamedQuery(name = "QualificationRecovery.findByQualificationRecoveryId", query = "SELECT q FROM QualificationRecovery q WHERE q.qualificationRecoveryId = :qualificationRecoveryId"),
    @NamedQuery(name = "QualificationRecovery.findByQualificationRecoveryValue", query = "SELECT q FROM QualificationRecovery q WHERE q.qualificationRecoveryValue = :qualificationRecoveryValue")})
public class QualificationRecovery implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "qualification_recovery_id", nullable = false)
    private Long qualificationRecoveryId;
    @Basic(optional = false)
    @Column(name = "qualification_recovery_value", nullable = false)
    private double qualificationRecoveryValue;
    @JoinColumns({
        @JoinColumn(name = "person_id", referencedColumnName = "person_id", nullable = false),
        @JoinColumn(name = "course_detail_id", referencedColumnName = "course_detail_id")})
    @ManyToOne(optional = false)
    private EnrollmentCourse enrollmentCourse;
    @JoinColumn(name = "evaluated_status_id", referencedColumnName = "evaluated_status_id", nullable = false)
    @ManyToOne(optional = false)
    private EvaluatedStatus evaluatedStatusId;
    @JoinColumn(name = "person_registering_id", referencedColumnName = "person_registering_id", nullable = false)
    @ManyToOne(optional = false)
    private PersonRegistering personRegisteringId;

    public QualificationRecovery() {
    }

    public QualificationRecovery(Long qualificationRecoveryId) {
        this.qualificationRecoveryId = qualificationRecoveryId;
    }

    public QualificationRecovery(Long qualificationRecoveryId, double qualificationRecoveryValue) {
        this.qualificationRecoveryId = qualificationRecoveryId;
        this.qualificationRecoveryValue = qualificationRecoveryValue;
    }

    public Long getQualificationRecoveryId() {
        return qualificationRecoveryId;
    }

    public void setQualificationRecoveryId(Long qualificationRecoveryId) {
        this.qualificationRecoveryId = qualificationRecoveryId;
    }

    public double getQualificationRecoveryValue() {
        return qualificationRecoveryValue;
    }

    public void setQualificationRecoveryValue(double qualificationRecoveryValue) {
        this.qualificationRecoveryValue = qualificationRecoveryValue;
    }

    public EnrollmentCourse getEnrollmentCourse() {
        return enrollmentCourse;
    }

    public void setEnrollmentCourse(EnrollmentCourse enrollmentCourse) {
        this.enrollmentCourse = enrollmentCourse;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (qualificationRecoveryId != null ? qualificationRecoveryId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof QualificationRecovery)) {
            return false;
        }
        QualificationRecovery other = (QualificationRecovery) object;
        if ((this.qualificationRecoveryId == null && other.qualificationRecoveryId != null) || (this.qualificationRecoveryId != null && !this.qualificationRecoveryId.equals(other.qualificationRecoveryId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.system.demo.model.QualificationRecovery[ qualificationRecoveryId=" + qualificationRecoveryId + " ]";
    }
    
}
