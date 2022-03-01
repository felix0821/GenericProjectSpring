/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.system.demo.persistence.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Felix
 */
@Entity
@Table(name = "person_registering")
@NamedQueries({
    @NamedQuery(name = "PersonRegistering.findAll", query = "SELECT p FROM PersonRegistering p"),
    @NamedQuery(name = "PersonRegistering.findByPersonRegisteringId", query = "SELECT p FROM PersonRegistering p WHERE p.personRegisteringId = :personRegisteringId"),
    @NamedQuery(name = "PersonRegistering.findByPersonRegisteringDate", query = "SELECT p FROM PersonRegistering p WHERE p.personRegisteringDate = :personRegisteringDate"),
    @NamedQuery(name = "PersonRegistering.findByPersonRegisteringCategory", query = "SELECT p FROM PersonRegistering p WHERE p.personRegisteringCategory = :personRegisteringCategory")})
public class PersonRegistering implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "person_registering_id", nullable = false)
    private Long personRegisteringId;
    @Basic(optional = false)
    @Column(name = "person_registering_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date personRegisteringDate;
    @Basic(optional = false)
    @Column(name = "person_registering_category", nullable = false)
    private Character personRegisteringCategory;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "personRegisteringId")
    private Collection<EnrollmentQualification> enrollmentQualificationCollection;
    @OneToMany(mappedBy = "personRegisteringId")
    private Collection<DiscountPerson> discountPersonCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "personRegisteringId")
    private Collection<Assistance> assistanceCollection;
    @JoinColumn(name = "person_id", referencedColumnName = "person_id", nullable = false)
    @ManyToOne(optional = false)
    private Person personId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "personRegisteringId")
    private Collection<EnrollmentCourse> enrollmentCourseCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "personRegisteringId")
    private Collection<QualificationRecovery> qualificationRecoveryCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "personRegisteringId")
    private Collection<FinancialMovementDetail> financialMovementDetailCollection;

    public PersonRegistering() {
    }

    public PersonRegistering(Long personRegisteringId) {
        this.personRegisteringId = personRegisteringId;
    }

    public PersonRegistering(Long personRegisteringId, Date personRegisteringDate, Character personRegisteringCategory) {
        this.personRegisteringId = personRegisteringId;
        this.personRegisteringDate = personRegisteringDate;
        this.personRegisteringCategory = personRegisteringCategory;
    }

    public Long getPersonRegisteringId() {
        return personRegisteringId;
    }

    public void setPersonRegisteringId(Long personRegisteringId) {
        this.personRegisteringId = personRegisteringId;
    }

    public Date getPersonRegisteringDate() {
        return personRegisteringDate;
    }

    public void setPersonRegisteringDate(Date personRegisteringDate) {
        this.personRegisteringDate = personRegisteringDate;
    }

    public Character getPersonRegisteringCategory() {
        return personRegisteringCategory;
    }

    public void setPersonRegisteringCategory(Character personRegisteringCategory) {
        this.personRegisteringCategory = personRegisteringCategory;
    }

    public Collection<EnrollmentQualification> getEnrollmentQualificationCollection() {
        return enrollmentQualificationCollection;
    }

    public void setEnrollmentQualificationCollection(Collection<EnrollmentQualification> enrollmentQualificationCollection) {
        this.enrollmentQualificationCollection = enrollmentQualificationCollection;
    }

    public Collection<DiscountPerson> getDiscountPersonCollection() {
        return discountPersonCollection;
    }

    public void setDiscountPersonCollection(Collection<DiscountPerson> discountPersonCollection) {
        this.discountPersonCollection = discountPersonCollection;
    }

    public Collection<Assistance> getAssistanceCollection() {
        return assistanceCollection;
    }

    public void setAssistanceCollection(Collection<Assistance> assistanceCollection) {
        this.assistanceCollection = assistanceCollection;
    }

    public Person getPersonId() {
        return personId;
    }

    public void setPersonId(Person personId) {
        this.personId = personId;
    }

    public Collection<EnrollmentCourse> getEnrollmentCourseCollection() {
        return enrollmentCourseCollection;
    }

    public void setEnrollmentCourseCollection(Collection<EnrollmentCourse> enrollmentCourseCollection) {
        this.enrollmentCourseCollection = enrollmentCourseCollection;
    }

    public Collection<QualificationRecovery> getQualificationRecoveryCollection() {
        return qualificationRecoveryCollection;
    }

    public void setQualificationRecoveryCollection(Collection<QualificationRecovery> qualificationRecoveryCollection) {
        this.qualificationRecoveryCollection = qualificationRecoveryCollection;
    }

    public Collection<FinancialMovementDetail> getFinancialMovementDetailCollection() {
        return financialMovementDetailCollection;
    }

    public void setFinancialMovementDetailCollection(Collection<FinancialMovementDetail> financialMovementDetailCollection) {
        this.financialMovementDetailCollection = financialMovementDetailCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (personRegisteringId != null ? personRegisteringId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PersonRegistering)) {
            return false;
        }
        PersonRegistering other = (PersonRegistering) object;
        if ((this.personRegisteringId == null && other.personRegisteringId != null) || (this.personRegisteringId != null && !this.personRegisteringId.equals(other.personRegisteringId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.system.demo.persistence.entity.PersonRegistering[ personRegisteringId=" + personRegisteringId + " ]";
    }
    
}
