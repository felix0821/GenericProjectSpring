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
import javax.persistence.JoinColumns;
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
@Table(name = "enrollment_program")
@NamedQueries({
    @NamedQuery(name = "EnrollmentProgram.findAll", query = "SELECT e FROM EnrollmentProgram e"),
    @NamedQuery(name = "EnrollmentProgram.findByPersonId", query = "SELECT e FROM EnrollmentProgram e WHERE e.enrollmentProgramPK.personId = :personId"),
    @NamedQuery(name = "EnrollmentProgram.findByProgramId", query = "SELECT e FROM EnrollmentProgram e WHERE e.enrollmentProgramPK.programId = :programId"),
    @NamedQuery(name = "EnrollmentProgram.findByPeriodId", query = "SELECT e FROM EnrollmentProgram e WHERE e.enrollmentProgramPK.periodId = :periodId"),
    @NamedQuery(name = "EnrollmentProgram.findByEnrollmentProgramDate", query = "SELECT e FROM EnrollmentProgram e WHERE e.enrollmentProgramDate = :enrollmentProgramDate"),
    @NamedQuery(name = "EnrollmentProgram.findByEnrollmentProgramChecking", query = "SELECT e FROM EnrollmentProgram e WHERE e.enrollmentProgramChecking = :enrollmentProgramChecking"),
    @NamedQuery(name = "EnrollmentProgram.findByEnrollmentProgramState", query = "SELECT e FROM EnrollmentProgram e WHERE e.enrollmentProgramState = :enrollmentProgramState")})
public class EnrollmentProgram implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EnrollmentProgramPK enrollmentProgramPK;
    @Basic(optional = false)
    @Column(name = "enrollment_program_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date enrollmentProgramDate;
    @Basic(optional = false)
    @Column(name = "enrollment_program_checking", nullable = false)
    private boolean enrollmentProgramChecking;
    @Basic(optional = false)
    @Column(name = "enrollment_program_state", nullable = false)
    private Character enrollmentProgramState;
    @JoinColumn(name = "person_id", referencedColumnName = "person_id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Person person;
    @JoinColumns({
        @JoinColumn(name = "program_id", referencedColumnName = "program_id", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "period_id", referencedColumnName = "period_id", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private ProgramPeriod programPeriod;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "enrollmentProgram")
    private Collection<RequisitionEnrollmentProgram> requisitionEnrollmentProgramCollection;

    public EnrollmentProgram() {
    }

    public EnrollmentProgram(EnrollmentProgramPK enrollmentProgramPK) {
        this.enrollmentProgramPK = enrollmentProgramPK;
    }

    public EnrollmentProgram(EnrollmentProgramPK enrollmentProgramPK, Date enrollmentProgramDate, boolean enrollmentProgramChecking, Character enrollmentProgramState) {
        this.enrollmentProgramPK = enrollmentProgramPK;
        this.enrollmentProgramDate = enrollmentProgramDate;
        this.enrollmentProgramChecking = enrollmentProgramChecking;
        this.enrollmentProgramState = enrollmentProgramState;
    }

    public EnrollmentProgram(long personId, long programId, long periodId) {
        this.enrollmentProgramPK = new EnrollmentProgramPK(personId, programId, periodId);
    }

    public EnrollmentProgramPK getEnrollmentProgramPK() {
        return enrollmentProgramPK;
    }

    public void setEnrollmentProgramPK(EnrollmentProgramPK enrollmentProgramPK) {
        this.enrollmentProgramPK = enrollmentProgramPK;
    }

    public Date getEnrollmentProgramDate() {
        return enrollmentProgramDate;
    }

    public void setEnrollmentProgramDate(Date enrollmentProgramDate) {
        this.enrollmentProgramDate = enrollmentProgramDate;
    }

    public boolean getEnrollmentProgramChecking() {
        return enrollmentProgramChecking;
    }

    public void setEnrollmentProgramChecking(boolean enrollmentProgramChecking) {
        this.enrollmentProgramChecking = enrollmentProgramChecking;
    }

    public Character getEnrollmentProgramState() {
        return enrollmentProgramState;
    }

    public void setEnrollmentProgramState(Character enrollmentProgramState) {
        this.enrollmentProgramState = enrollmentProgramState;
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
        hash += (enrollmentProgramPK != null ? enrollmentProgramPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EnrollmentProgram)) {
            return false;
        }
        EnrollmentProgram other = (EnrollmentProgram) object;
        if ((this.enrollmentProgramPK == null && other.enrollmentProgramPK != null) || (this.enrollmentProgramPK != null && !this.enrollmentProgramPK.equals(other.enrollmentProgramPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.system.demo.persistence.entity.EnrollmentProgram[ enrollmentProgramPK=" + enrollmentProgramPK + " ]";
    }
    
}
