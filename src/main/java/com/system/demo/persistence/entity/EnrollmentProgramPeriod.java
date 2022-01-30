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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "enrollment_program_period")
@NamedQueries({
    @NamedQuery(name = "EnrollmentProgramPeriod.findAll", query = "SELECT e FROM EnrollmentProgramPeriod e"),
    @NamedQuery(name = "EnrollmentProgramPeriod.findByProgramPeriodId", query = "SELECT e FROM EnrollmentProgramPeriod e WHERE e.enrollmentProgramPeriodPK.programPeriodId = :programPeriodId"),
    @NamedQuery(name = "EnrollmentProgramPeriod.findByPersonId", query = "SELECT e FROM EnrollmentProgramPeriod e WHERE e.enrollmentProgramPeriodPK.personId = :personId"),
    @NamedQuery(name = "EnrollmentProgramPeriod.findByPersonProgramPeriodDate", query = "SELECT e FROM EnrollmentProgramPeriod e WHERE e.personProgramPeriodDate = :personProgramPeriodDate"),
    @NamedQuery(name = "EnrollmentProgramPeriod.findByPersonProgramPeriodState", query = "SELECT e FROM EnrollmentProgramPeriod e WHERE e.personProgramPeriodState = :personProgramPeriodState")})
public class EnrollmentProgramPeriod implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EnrollmentProgramPeriodPK enrollmentProgramPeriodPK;
    @Basic(optional = false)
    @Column(name = "person_program_period_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date personProgramPeriodDate;
    @Basic(optional = false)
    @Column(name = "person_program_period_state", nullable = false)
    private Character personProgramPeriodState;
    @JoinColumn(name = "person_id", referencedColumnName = "person_id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Person person;
    @JoinColumn(name = "program_period_id", referencedColumnName = "program_period_id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private ProgramPeriod programPeriod;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "enrollmentProgramPeriod")
    private Collection<RequisitionEnrollmentProgram> requisitionEnrollmentProgramCollection;

    public EnrollmentProgramPeriod() {
    }

    public EnrollmentProgramPeriod(EnrollmentProgramPeriodPK enrollmentProgramPeriodPK) {
        this.enrollmentProgramPeriodPK = enrollmentProgramPeriodPK;
    }

    public EnrollmentProgramPeriod(EnrollmentProgramPeriodPK enrollmentProgramPeriodPK, Date personProgramPeriodDate, Character personProgramPeriodState) {
        this.enrollmentProgramPeriodPK = enrollmentProgramPeriodPK;
        this.personProgramPeriodDate = personProgramPeriodDate;
        this.personProgramPeriodState = personProgramPeriodState;
    }

    public EnrollmentProgramPeriod(long programPeriodId, long personId) {
        this.enrollmentProgramPeriodPK = new EnrollmentProgramPeriodPK(programPeriodId, personId);
    }

    public EnrollmentProgramPeriodPK getEnrollmentProgramPeriodPK() {
        return enrollmentProgramPeriodPK;
    }

    public void setEnrollmentProgramPeriodPK(EnrollmentProgramPeriodPK enrollmentProgramPeriodPK) {
        this.enrollmentProgramPeriodPK = enrollmentProgramPeriodPK;
    }

    public Date getPersonProgramPeriodDate() {
        return personProgramPeriodDate;
    }

    public void setPersonProgramPeriodDate(Date personProgramPeriodDate) {
        this.personProgramPeriodDate = personProgramPeriodDate;
    }

    public Character getPersonProgramPeriodState() {
        return personProgramPeriodState;
    }

    public void setPersonProgramPeriodState(Character personProgramPeriodState) {
        this.personProgramPeriodState = personProgramPeriodState;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public ProgramPeriod getProgramPeriod() {
        return programPeriod;
    }

    public void setProgramPeriod(ProgramPeriod programPeriod) {
        this.programPeriod = programPeriod;
    }

    public Collection<RequisitionEnrollmentProgram> getRequisitionEnrollmentProgramCollection() {
        return requisitionEnrollmentProgramCollection;
    }

    public void setRequisitionEnrollmentProgramCollection(Collection<RequisitionEnrollmentProgram> requisitionEnrollmentProgramCollection) {
        this.requisitionEnrollmentProgramCollection = requisitionEnrollmentProgramCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (enrollmentProgramPeriodPK != null ? enrollmentProgramPeriodPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EnrollmentProgramPeriod)) {
            return false;
        }
        EnrollmentProgramPeriod other = (EnrollmentProgramPeriod) object;
        if ((this.enrollmentProgramPeriodPK == null && other.enrollmentProgramPeriodPK != null) || (this.enrollmentProgramPeriodPK != null && !this.enrollmentProgramPeriodPK.equals(other.enrollmentProgramPeriodPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.system.demo.model.EnrollmentProgramPeriod[ enrollmentProgramPeriodPK=" + enrollmentProgramPeriodPK + " ]";
    }
    
}
