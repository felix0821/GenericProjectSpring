/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.system.demo.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 *
 * @author Felix
 */
@Entity
@Table(name = "person", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"person_username","person_email"})})
@NamedQueries({
    @NamedQuery(name = "Person.findAll", query = "SELECT p FROM Person p"),
    @NamedQuery(name = "Person.findByPersonId", query = "SELECT p FROM Person p WHERE p.personId = :personId"),
    @NamedQuery(name = "Person.findByPersonUsername", query = "SELECT p FROM Person p WHERE p.personUsername = :personUsername"),
    @NamedQuery(name = "Person.findByPersonPassword", query = "SELECT p FROM Person p WHERE p.personPassword = :personPassword"),
    @NamedQuery(name = "Person.findByPersonName", query = "SELECT p FROM Person p WHERE p.personName = :personName"),
    @NamedQuery(name = "Person.findByPersonLastnameFather", query = "SELECT p FROM Person p WHERE p.personLastnameFather = :personLastnameFather"),
    @NamedQuery(name = "Person.findByPersonLastnameMother", query = "SELECT p FROM Person p WHERE p.personLastnameMother = :personLastnameMother"),
    @NamedQuery(name = "Person.findByPersonGender", query = "SELECT p FROM Person p WHERE p.personGender = :personGender"),
    @NamedQuery(name = "Person.findByPersonDateBirth", query = "SELECT p FROM Person p WHERE p.personDateBirth = :personDateBirth"),
    @NamedQuery(name = "Person.findByPersonDateRegistration", query = "SELECT p FROM Person p WHERE p.personDateRegistration = :personDateRegistration"),
    @NamedQuery(name = "Person.findByPersonEmail", query = "SELECT p FROM Person p WHERE p.personEmail = :personEmail"),
    @NamedQuery(name = "Person.findByPersonUrlProfilepicture", query = "SELECT p FROM Person p WHERE p.personUrlProfilepicture = :personUrlProfilepicture"),
    @NamedQuery(name = "Person.findByPersonState", query = "SELECT p FROM Person p WHERE p.personState = :personState")})
public class Person implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "person_id", nullable = false)
    private Long personId;
    @Basic(optional = false)
    @Column(name = "person_username", nullable = false, length = 32)
    private String personUsername;
    @Basic(optional = false)
    @Column(name = "person_password", nullable = false, length = 128)
    private String personPassword;
    @Basic(optional = false)
    @Column(name = "person_name", nullable = false, length = 128)
    private String personName;
    @Basic(optional = false)
    @Column(name = "person_lastname_father", nullable = false, length = 128)
    private String personLastnameFather;
    @Basic(optional = false)
    @Column(name = "person_lastname_mother", nullable = false, length = 128)
    private String personLastnameMother;
    @Column(name = "person_gender")
    private Character personGender;
    @Column(name = "person_date_birth")
    @Temporal(TemporalType.DATE)
    private Date personDateBirth;
    @Basic(optional = false)
    @Column(name = "person_date_registration", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date personDateRegistration;
    @Basic(optional = false)
    @Column(name = "person_email", nullable = false, length = 128)
    private String personEmail;
    @Column(name = "person_url_profilepicture", length = 256)
    private String personUrlProfilepicture;
    @Basic(optional = false)
    @Column(name = "person_state", nullable = false)
    private Character personState;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "person", fetch = FetchType.EAGER)
    private Collection<PersonRole> personRoleCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "person")
    private Collection<PersonDataDetail> personDataDetailCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "personId")
    private Collection<CertificateStudies> certificateStudiesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "personId")
    private Collection<RequisitionDetail> requisitionDetailCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "person")
    private Collection<RequisitionPerson> requisitionPersonCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "person")
    private Collection<PersonIdentificationDocument> identificationDocumentPersonCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "person")
    private Collection<PersonProgramPeriod> personProgramPeriodCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "personId")
    private Collection<PaymentSchedule> paymentScheduleCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "personId")
    private Collection<RequisitionRemark> requisitionRemarkCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "person")
    private Collection<Assistance> assistanceCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "personId")
    private Collection<PersonRegistering> personRegisteringCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "person")
    private Collection<Enrollment> enrollmentCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "personId")
    private Collection<RequisitionStatusDetail> requisitionStatusDetailCollection;

    @Transient
    @JsonIgnore
	private String confirmPassword;
    
    public Person() {
    }

    public Person(Long personId) {
        this.personId = personId;
    }

    public Person(Long personId, String personUsername, String personPassword, String personName, String personLastnameFather, String personLastnameMother, Date personDateRegistration, String personEmail, Character personState) {
        this.personId = personId;
        this.personUsername = personUsername;
        this.personPassword = personPassword;
        this.personName = personName;
        this.personLastnameFather = personLastnameFather;
        this.personLastnameMother = personLastnameMother;
        this.personDateRegistration = personDateRegistration;
        this.personEmail = personEmail;
        this.personState = personState;
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public String getPersonUsername() {
        return personUsername;
    }

    public void setPersonUsername(String personUsername) {
        this.personUsername = personUsername;
    }

    public String getPersonPassword() {
		return personPassword;
	}

	public void setPersonPassword(String personPassword) {
		this.personPassword = personPassword;
	}

	public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getPersonLastnameFather() {
        return personLastnameFather;
    }

    public void setPersonLastnameFather(String personLastnameFather) {
        this.personLastnameFather = personLastnameFather;
    }

    public String getPersonLastnameMother() {
        return personLastnameMother;
    }

    public void setPersonLastnameMother(String personLastnameMother) {
        this.personLastnameMother = personLastnameMother;
    }

    public Character getPersonGender() {
		return personGender;
	}

	public void setPersonGender(Character personGender) {
		this.personGender = personGender;
	}

	public Date getPersonDateBirth() {
        return personDateBirth;
    }

    public void setPersonDateBirth(Date personDateBirth) {
        this.personDateBirth = personDateBirth;
    }

    public Date getPersonDateRegistration() {
        return personDateRegistration;
    }

    public void setPersonDateRegistration(Date personDateRegistration) {
        this.personDateRegistration = personDateRegistration;
    }

    public String getPersonEmail() {
        return personEmail;
    }

    public void setPersonEmail(String personEmail) {
        this.personEmail = personEmail;
    }

    public String getPersonUrlProfilepicture() {
        return personUrlProfilepicture;
    }

    public void setPersonUrlProfilepicture(String personUrlProfilepicture) {
        this.personUrlProfilepicture = personUrlProfilepicture;
    }

    public Character getPersonState() {
        return personState;
    }

    public void setPersonState(Character personState) {
        this.personState = personState;
    }

    public Collection<PersonRole> getPersonRoleCollection() {
        return personRoleCollection;
    }

    public void setPersonRoleCollection(Collection<PersonRole> personRoleCollection) {
        this.personRoleCollection = personRoleCollection;
    }

    public Collection<PersonDataDetail> getPersonDataDetailCollection() {
        return personDataDetailCollection;
    }

    public void setPersonDataDetailCollection(Collection<PersonDataDetail> personDataDetailCollection) {
        this.personDataDetailCollection = personDataDetailCollection;
    }

    public Collection<CertificateStudies> getCertificateStudiesCollection() {
        return certificateStudiesCollection;
    }

    public void setCertificateStudiesCollection(Collection<CertificateStudies> certificateStudiesCollection) {
        this.certificateStudiesCollection = certificateStudiesCollection;
    }

    public Collection<RequisitionDetail> getRequisitionDetailCollection() {
        return requisitionDetailCollection;
    }

    public void setRequisitionDetailCollection(Collection<RequisitionDetail> requisitionDetailCollection) {
        this.requisitionDetailCollection = requisitionDetailCollection;
    }

    public Collection<RequisitionPerson> getRequisitionPersonCollection() {
        return requisitionPersonCollection;
    }

    public void setRequisitionPersonCollection(Collection<RequisitionPerson> requisitionPersonCollection) {
        this.requisitionPersonCollection = requisitionPersonCollection;
    }

    public Collection<PersonIdentificationDocument> getIdentificationDocumentPersonCollection() {
        return identificationDocumentPersonCollection;
    }

    public void setIdentificationDocumentPersonCollection(Collection<PersonIdentificationDocument> identificationDocumentPersonCollection) {
        this.identificationDocumentPersonCollection = identificationDocumentPersonCollection;
    }

    public Collection<PersonProgramPeriod> getPersonProgramPeriodCollection() {
        return personProgramPeriodCollection;
    }

    public void setPersonProgramPeriodCollection(Collection<PersonProgramPeriod> personProgramPeriodCollection) {
        this.personProgramPeriodCollection = personProgramPeriodCollection;
    }

    public Collection<PaymentSchedule> getPaymentScheduleCollection() {
        return paymentScheduleCollection;
    }

    public void setPaymentScheduleCollection(Collection<PaymentSchedule> paymentScheduleCollection) {
        this.paymentScheduleCollection = paymentScheduleCollection;
    }

    public Collection<RequisitionRemark> getRequisitionRemarkCollection() {
        return requisitionRemarkCollection;
    }

    public void setRequisitionRemarkCollection(Collection<RequisitionRemark> requisitionRemarkCollection) {
        this.requisitionRemarkCollection = requisitionRemarkCollection;
    }

    public Collection<Assistance> getAssistanceCollection() {
        return assistanceCollection;
    }

    public void setAssistanceCollection(Collection<Assistance> assistanceCollection) {
        this.assistanceCollection = assistanceCollection;
    }

    public Collection<PersonRegistering> getPersonRegisteringCollection() {
        return personRegisteringCollection;
    }

    public void setPersonRegisteringCollection(Collection<PersonRegistering> personRegisteringCollection) {
        this.personRegisteringCollection = personRegisteringCollection;
    }

    public Collection<Enrollment> getEnrollmentCollection() {
        return enrollmentCollection;
    }

    public void setEnrollmentCollection(Collection<Enrollment> enrollmentCollection) {
        this.enrollmentCollection = enrollmentCollection;
    }

    public Collection<RequisitionStatusDetail> getRequisitionStatusDetailCollection() {
        return requisitionStatusDetailCollection;
    }

    public void setRequisitionStatusDetailCollection(Collection<RequisitionStatusDetail> requisitionStatusDetailCollection) {
        this.requisitionStatusDetailCollection = requisitionStatusDetailCollection;
    }
    
    public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (personId != null ? personId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Person)) {
            return false;
        }
        Person other = (Person) object;
        if ((this.personId == null && other.personId != null) || (this.personId != null && !this.personId.equals(other.personId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.system.demo.model.Person[ personId=" + personId + " ]";
    }
    
}
