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
@Table(name = "qualification_criteria")
@NamedQueries({
    @NamedQuery(name = "QualificationCriteria.findAll", query = "SELECT q FROM QualificationCriteria q"),
    @NamedQuery(name = "QualificationCriteria.findByQualificationCriteriaId", query = "SELECT q FROM QualificationCriteria q WHERE q.qualificationCriteriaId = :qualificationCriteriaId"),
    @NamedQuery(name = "QualificationCriteria.findByQualificationCriteriaIndex", query = "SELECT q FROM QualificationCriteria q WHERE q.qualificationCriteriaIndex = :qualificationCriteriaIndex"),
    @NamedQuery(name = "QualificationCriteria.findByQualificationCriteriaName", query = "SELECT q FROM QualificationCriteria q WHERE q.qualificationCriteriaName = :qualificationCriteriaName"),
    @NamedQuery(name = "QualificationCriteria.findByQualificationCriteriaPorcentual", query = "SELECT q FROM QualificationCriteria q WHERE q.qualificationCriteriaPorcentual = :qualificationCriteriaPorcentual")})
public class QualificationCriteria implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "qualification_criteria_id", nullable = false)
    private Long qualificationCriteriaId;
    @Basic(optional = false)
    @Column(name = "qualification_criteria_index", nullable = false)
    private int qualificationCriteriaIndex;
    @Basic(optional = false)
    @Column(name = "qualification_criteria_name", nullable = false, length = 64)
    private String qualificationCriteriaName;
    @Basic(optional = false)
    @Column(name = "qualification_criteria_porcentual", nullable = false)
    private double qualificationCriteriaPorcentual;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "qualificationCriteria")
    private Collection<EnrollmentQualification> enrollmentQualificationCollection;
    @JoinColumn(name = "course_detail_id", referencedColumnName = "course_detail_id")
    @ManyToOne
    private CourseDetail courseDetailId;

    public QualificationCriteria() {
    }

    public QualificationCriteria(Long qualificationCriteriaId) {
        this.qualificationCriteriaId = qualificationCriteriaId;
    }

    public QualificationCriteria(Long qualificationCriteriaId, int qualificationCriteriaIndex, String qualificationCriteriaName, double qualificationCriteriaPorcentual) {
        this.qualificationCriteriaId = qualificationCriteriaId;
        this.qualificationCriteriaIndex = qualificationCriteriaIndex;
        this.qualificationCriteriaName = qualificationCriteriaName;
        this.qualificationCriteriaPorcentual = qualificationCriteriaPorcentual;
    }

    public Long getQualificationCriteriaId() {
        return qualificationCriteriaId;
    }

    public void setQualificationCriteriaId(Long qualificationCriteriaId) {
        this.qualificationCriteriaId = qualificationCriteriaId;
    }

    public int getQualificationCriteriaIndex() {
        return qualificationCriteriaIndex;
    }

    public void setQualificationCriteriaIndex(int qualificationCriteriaIndex) {
        this.qualificationCriteriaIndex = qualificationCriteriaIndex;
    }

    public String getQualificationCriteriaName() {
        return qualificationCriteriaName;
    }

    public void setQualificationCriteriaName(String qualificationCriteriaName) {
        this.qualificationCriteriaName = qualificationCriteriaName;
    }

    public double getQualificationCriteriaPorcentual() {
        return qualificationCriteriaPorcentual;
    }

    public void setQualificationCriteriaPorcentual(double qualificationCriteriaPorcentual) {
        this.qualificationCriteriaPorcentual = qualificationCriteriaPorcentual;
    }

    public Collection<EnrollmentQualification> getEnrollmentQualificationCollection() {
        return enrollmentQualificationCollection;
    }

    public void setEnrollmentQualificationCollection(Collection<EnrollmentQualification> enrollmentQualificationCollection) {
        this.enrollmentQualificationCollection = enrollmentQualificationCollection;
    }

    public CourseDetail getCourseDetailId() {
        return courseDetailId;
    }

    public void setCourseDetailId(CourseDetail courseDetailId) {
        this.courseDetailId = courseDetailId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (qualificationCriteriaId != null ? qualificationCriteriaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof QualificationCriteria)) {
            return false;
        }
        QualificationCriteria other = (QualificationCriteria) object;
        if ((this.qualificationCriteriaId == null && other.qualificationCriteriaId != null) || (this.qualificationCriteriaId != null && !this.qualificationCriteriaId.equals(other.qualificationCriteriaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.system.demo.model.QualificationCriteria[ qualificationCriteriaId=" + qualificationCriteriaId + " ]";
    }
    
}
