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
@Table(name = "program_period", catalog = "ucps_system", schema = "public")
@NamedQueries({
    @NamedQuery(name = "ProgramPeriod.findAll", query = "SELECT p FROM ProgramPeriod p"),
    @NamedQuery(name = "ProgramPeriod.findByProgramId", query = "SELECT p FROM ProgramPeriod p WHERE p.programPeriodPK.programId = :programId"),
    @NamedQuery(name = "ProgramPeriod.findByPeriodId", query = "SELECT p FROM ProgramPeriod p WHERE p.programPeriodPK.periodId = :periodId"),
    @NamedQuery(name = "ProgramPeriod.findByProgramPeriodIndex", query = "SELECT p FROM ProgramPeriod p WHERE p.programPeriodIndex = :programPeriodIndex"),
    @NamedQuery(name = "ProgramPeriod.findByProgramPeriodPayEnrollment", query = "SELECT p FROM ProgramPeriod p WHERE p.programPeriodPayEnrollment = :programPeriodPayEnrollment"),
    @NamedQuery(name = "ProgramPeriod.findByProgramPeriodPayPension", query = "SELECT p FROM ProgramPeriod p WHERE p.programPeriodPayPension = :programPeriodPayPension"),
    @NamedQuery(name = "ProgramPeriod.findByProgramPeriodOpening", query = "SELECT p FROM ProgramPeriod p WHERE p.programPeriodOpening = :programPeriodOpening"),
    @NamedQuery(name = "ProgramPeriod.findByProgramPeriodEnrollmentClosure", query = "SELECT p FROM ProgramPeriod p WHERE p.programPeriodEnrollmentClosure = :programPeriodEnrollmentClosure"),
    @NamedQuery(name = "ProgramPeriod.findByProgramPeriodClosing", query = "SELECT p FROM ProgramPeriod p WHERE p.programPeriodClosing = :programPeriodClosing"),
    @NamedQuery(name = "ProgramPeriod.findByProgramPeriodState", query = "SELECT p FROM ProgramPeriod p WHERE p.programPeriodState = :programPeriodState")})
public class ProgramPeriod implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProgramPeriodPK programPeriodPK;
    @Column(name = "program_period_index")
    private Integer programPeriodIndex;
    @Basic(optional = false)
    @Column(name = "program_period_pay_enrollment")
    private double programPeriodPayEnrollment;
    @Basic(optional = false)
    @Column(name = "program_period_pay_pension")
    private double programPeriodPayPension;
    @Basic(optional = false)
    @Column(name = "program_period_opening")
    @Temporal(TemporalType.DATE)
    private Date programPeriodOpening;
    @Basic(optional = false)
    @Column(name = "program_period_enrollment_closure")
    @Temporal(TemporalType.DATE)
    private Date programPeriodEnrollmentClosure;
    @Basic(optional = false)
    @Column(name = "program_period_closing")
    @Temporal(TemporalType.DATE)
    private Date programPeriodClosing;
    @Basic(optional = false)
    @Column(name = "program_period_state")
    private Character programPeriodState;
    @JoinColumn(name = "period_id", referencedColumnName = "period_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Period period;
    @JoinColumn(name = "program_id", referencedColumnName = "program_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Program program;
    @JoinColumn(name = "requisition_id", referencedColumnName = "requisition_id")
    @ManyToOne
    private Requisition requisitionId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "programPeriod")
    private Collection<ProgramShedule> programSheduleCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "programPeriod")
    private Collection<EnrollmentProgram> enrollmentProgramCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "programPeriod")
    private Collection<ModulusDetail> modulusDetailCollection;

    public ProgramPeriod() {
    }

    public ProgramPeriod(ProgramPeriodPK programPeriodPK) {
        this.programPeriodPK = programPeriodPK;
    }

    public ProgramPeriod(ProgramPeriodPK programPeriodPK, double programPeriodPayEnrollment, double programPeriodPayPension, Date programPeriodOpening, Date programPeriodEnrollmentClosure, Date programPeriodClosing, Character programPeriodState) {
        this.programPeriodPK = programPeriodPK;
        this.programPeriodPayEnrollment = programPeriodPayEnrollment;
        this.programPeriodPayPension = programPeriodPayPension;
        this.programPeriodOpening = programPeriodOpening;
        this.programPeriodEnrollmentClosure = programPeriodEnrollmentClosure;
        this.programPeriodClosing = programPeriodClosing;
        this.programPeriodState = programPeriodState;
    }

    public ProgramPeriod(long programId, long periodId) {
        this.programPeriodPK = new ProgramPeriodPK(programId, periodId);
    }

    public ProgramPeriodPK getProgramPeriodPK() {
        return programPeriodPK;
    }

    public void setProgramPeriodPK(ProgramPeriodPK programPeriodPK) {
        this.programPeriodPK = programPeriodPK;
    }

    public Integer getProgramPeriodIndex() {
        return programPeriodIndex;
    }

    public void setProgramPeriodIndex(Integer programPeriodIndex) {
        this.programPeriodIndex = programPeriodIndex;
    }

    public double getProgramPeriodPayEnrollment() {
        return programPeriodPayEnrollment;
    }

    public void setProgramPeriodPayEnrollment(double programPeriodPayEnrollment) {
        this.programPeriodPayEnrollment = programPeriodPayEnrollment;
    }

    public double getProgramPeriodPayPension() {
        return programPeriodPayPension;
    }

    public void setProgramPeriodPayPension(double programPeriodPayPension) {
        this.programPeriodPayPension = programPeriodPayPension;
    }

    public Date getProgramPeriodOpening() {
        return programPeriodOpening;
    }

    public void setProgramPeriodOpening(Date programPeriodOpening) {
        this.programPeriodOpening = programPeriodOpening;
    }

    public Date getProgramPeriodEnrollmentClosure() {
        return programPeriodEnrollmentClosure;
    }

    public void setProgramPeriodEnrollmentClosure(Date programPeriodEnrollmentClosure) {
        this.programPeriodEnrollmentClosure = programPeriodEnrollmentClosure;
    }

    public Date getProgramPeriodClosing() {
        return programPeriodClosing;
    }

    public void setProgramPeriodClosing(Date programPeriodClosing) {
        this.programPeriodClosing = programPeriodClosing;
    }

    public Character getProgramPeriodState() {
        return programPeriodState;
    }

    public void setProgramPeriodState(Character programPeriodState) {
        this.programPeriodState = programPeriodState;
    }

    public Period getPeriod() {
        return period;
    }

    public void setPeriod(Period period) {
        this.period = period;
    }

    public Program getProgram() {
        return program;
    }

    public void setProgram(Program program) {
        this.program = program;
    }

    public Requisition getRequisitionId() {
        return requisitionId;
    }

    public void setRequisitionId(Requisition requisitionId) {
        this.requisitionId = requisitionId;
    }

    public Collection<ProgramShedule> getProgramSheduleCollection() {
        return programSheduleCollection;
    }

    public void setProgramSheduleCollection(Collection<ProgramShedule> programSheduleCollection) {
        this.programSheduleCollection = programSheduleCollection;
    }

    public Collection<EnrollmentProgram> getEnrollmentProgramCollection() {
        return enrollmentProgramCollection;
    }

    public void setEnrollmentProgramCollection(Collection<EnrollmentProgram> enrollmentProgramCollection) {
        this.enrollmentProgramCollection = enrollmentProgramCollection;
    }

    public Collection<ModulusDetail> getModulusDetailCollection() {
        return modulusDetailCollection;
    }

    public void setModulusDetailCollection(Collection<ModulusDetail> modulusDetailCollection) {
        this.modulusDetailCollection = modulusDetailCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (programPeriodPK != null ? programPeriodPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProgramPeriod)) {
            return false;
        }
        ProgramPeriod other = (ProgramPeriod) object;
        if ((this.programPeriodPK == null && other.programPeriodPK != null) || (this.programPeriodPK != null && !this.programPeriodPK.equals(other.programPeriodPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.system.demo.persistence.entity.ProgramPeriod[ programPeriodPK=" + programPeriodPK + " ]";
    }
    
}
