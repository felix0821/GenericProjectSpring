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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Felix
 */
@Entity
@Table(name = "evaluated_status", catalog = "ucps_system", schema = "public")
@NamedQueries({
    @NamedQuery(name = "EvaluatedStatus.findAll", query = "SELECT e FROM EvaluatedStatus e"),
    @NamedQuery(name = "EvaluatedStatus.findByEvaluatedStatusId", query = "SELECT e FROM EvaluatedStatus e WHERE e.evaluatedStatusId = :evaluatedStatusId"),
    @NamedQuery(name = "EvaluatedStatus.findByEvaluatedStatusName", query = "SELECT e FROM EvaluatedStatus e WHERE e.evaluatedStatusName = :evaluatedStatusName"),
    @NamedQuery(name = "EvaluatedStatus.findByEvaluatedStatusColor", query = "SELECT e FROM EvaluatedStatus e WHERE e.evaluatedStatusColor = :evaluatedStatusColor")})
public class EvaluatedStatus implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "evaluated_status_id")
    private Long evaluatedStatusId;
    @Basic(optional = false)
    @Column(name = "evaluated_status_name")
    private String evaluatedStatusName;
    @Basic(optional = false)
    @Column(name = "evaluated_status_color")
    private String evaluatedStatusColor;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "evaluatedStatusId")
    private Collection<EnrollmentQualification> enrollmentQualificationCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "evaluatedStatusId")
    private Collection<QualificationRecovery> qualificationRecoveryCollection;

    public EvaluatedStatus() {
    }

    public EvaluatedStatus(Long evaluatedStatusId) {
        this.evaluatedStatusId = evaluatedStatusId;
    }

    public EvaluatedStatus(Long evaluatedStatusId, String evaluatedStatusName, String evaluatedStatusColor) {
        this.evaluatedStatusId = evaluatedStatusId;
        this.evaluatedStatusName = evaluatedStatusName;
        this.evaluatedStatusColor = evaluatedStatusColor;
    }

    public Long getEvaluatedStatusId() {
        return evaluatedStatusId;
    }

    public void setEvaluatedStatusId(Long evaluatedStatusId) {
        this.evaluatedStatusId = evaluatedStatusId;
    }

    public String getEvaluatedStatusName() {
        return evaluatedStatusName;
    }

    public void setEvaluatedStatusName(String evaluatedStatusName) {
        this.evaluatedStatusName = evaluatedStatusName;
    }

    public String getEvaluatedStatusColor() {
        return evaluatedStatusColor;
    }

    public void setEvaluatedStatusColor(String evaluatedStatusColor) {
        this.evaluatedStatusColor = evaluatedStatusColor;
    }

    public Collection<EnrollmentQualification> getEnrollmentQualificationCollection() {
        return enrollmentQualificationCollection;
    }

    public void setEnrollmentQualificationCollection(Collection<EnrollmentQualification> enrollmentQualificationCollection) {
        this.enrollmentQualificationCollection = enrollmentQualificationCollection;
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
        hash += (evaluatedStatusId != null ? evaluatedStatusId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EvaluatedStatus)) {
            return false;
        }
        EvaluatedStatus other = (EvaluatedStatus) object;
        if ((this.evaluatedStatusId == null && other.evaluatedStatusId != null) || (this.evaluatedStatusId != null && !this.evaluatedStatusId.equals(other.evaluatedStatusId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.system.demo.persistence.entity.EvaluatedStatus[ evaluatedStatusId=" + evaluatedStatusId + " ]";
    }
    
}
