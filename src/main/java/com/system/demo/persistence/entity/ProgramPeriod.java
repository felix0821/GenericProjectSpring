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
@Table(name = "program_period")
@NamedQueries({
    @NamedQuery(name = "ProgramPeriod.findAll", query = "SELECT p FROM ProgramPeriod p"),
    @NamedQuery(name = "ProgramPeriod.findByProgramId", query = "SELECT p FROM ProgramPeriod p WHERE p.programPeriodPK.programId = :programId"),
    @NamedQuery(name = "ProgramPeriod.findByPedagogicalPeriodId", query = "SELECT p FROM ProgramPeriod p WHERE p.programPeriodPK.pedagogicalPeriodId = :pedagogicalPeriodId"),
    @NamedQuery(name = "ProgramPeriod.findByProgramPeriodIndex", query = "SELECT p FROM ProgramPeriod p WHERE p.programPeriodIndex = :programPeriodIndex"),
    @NamedQuery(name = "ProgramPeriod.findByProgramPeriodPayEnrollment", query = "SELECT p FROM ProgramPeriod p WHERE p.programPeriodPayEnrollment = :programPeriodPayEnrollment"),
    @NamedQuery(name = "ProgramPeriod.findByProgramPeriodPayPension", query = "SELECT p FROM ProgramPeriod p WHERE p.programPeriodPayPension = :programPeriodPayPension"),
    @NamedQuery(name = "ProgramPeriod.findByProgramPeriodOpening", query = "SELECT p FROM ProgramPeriod p WHERE p.programPeriodOpening = :programPeriodOpening"),
    @NamedQuery(name = "ProgramPeriod.findByProgramPeriodClosingEnrollment", query = "SELECT p FROM ProgramPeriod p WHERE p.programPeriodClosingEnrollment = :programPeriodClosingEnrollment"),
    @NamedQuery(name = "ProgramPeriod.findByProgramPeriodClosing", query = "SELECT p FROM ProgramPeriod p WHERE p.programPeriodClosing = :programPeriodClosing"),
    @NamedQuery(name = "ProgramPeriod.findByProgramPeriodState", query = "SELECT p FROM ProgramPeriod p WHERE p.programPeriodState = :programPeriodState")})
public class ProgramPeriod implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProgramPeriodPK programPeriodPK;
    @Basic(optional = false)
    @Column(name = "program_period_index", nullable = false)
    private int programPeriodIndex;
    @Basic(optional = false)
    @Column(name = "program_period_pay_enrollment", nullable = false)
    private double programPeriodPayEnrollment;
    @Basic(optional = false)
    @Column(name = "program_period_pay_pension", nullable = false)
    private double programPeriodPayPension;
    @Basic(optional = false)
    @Column(name = "program_period_opening", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date programPeriodOpening;
    @Basic(optional = false)
    @Column(name = "program_period_closing_enrollment", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date programPeriodClosingEnrollment;
    @Basic(optional = false)
    @Column(name = "program_period_closing", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date programPeriodClosing;
    @Basic(optional = false)
    @Column(name = "program_period_state", nullable = false)
    private Character programPeriodState;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "programPeriod")
    private Collection<EnrollmentProgramPeriod> enrollmentProgramPeriodCollection;
    @JoinColumn(name = "pedagogical_period_id", referencedColumnName = "pedagogical_period_id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private PedagogicalPeriod pedagogicalPeriod;
    @JoinColumn(name = "program_id", referencedColumnName = "program_id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Program program;
    @OneToMany(mappedBy = "programPeriod")
    private Collection<CourseDetail> courseDetailCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "programPeriod")
    private Collection<ModulusSchedule> modulusScheduleCollection;

    public ProgramPeriod() {
    }

    public ProgramPeriod(ProgramPeriodPK programPeriodPK) {
        this.programPeriodPK = programPeriodPK;
    }

    public ProgramPeriod(ProgramPeriodPK programPeriodPK, int programPeriodIndex, double programPeriodPayEnrollment, double programPeriodPayPension, Date programPeriodOpening, Date programPeriodClosingEnrollment, Date programPeriodClosing, Character programPeriodState) {
        this.programPeriodPK = programPeriodPK;
        this.programPeriodIndex = programPeriodIndex;
        this.programPeriodPayEnrollment = programPeriodPayEnrollment;
        this.programPeriodPayPension = programPeriodPayPension;
        this.programPeriodOpening = programPeriodOpening;
        this.programPeriodClosingEnrollment = programPeriodClosingEnrollment;
        this.programPeriodClosing = programPeriodClosing;
        this.programPeriodState = programPeriodState;
    }

    public ProgramPeriod(long programId, long pedagogicalPeriodId) {
        this.programPeriodPK = new ProgramPeriodPK(programId, pedagogicalPeriodId);
    }

    public ProgramPeriodPK getProgramPeriodPK() {
        return programPeriodPK;
    }

    public void setProgramPeriodPK(ProgramPeriodPK programPeriodPK) {
        this.programPeriodPK = programPeriodPK;
    }

    public int getProgramPeriodIndex() {
        return programPeriodIndex;
    }

    public void setProgramPeriodIndex(int programPeriodIndex) {
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

    public Date getProgramPeriodClosingEnrollment() {
        return programPeriodClosingEnrollment;
    }

    public void setProgramPeriodClosingEnrollment(Date programPeriodClosingEnrollment) {
        this.programPeriodClosingEnrollment = programPeriodClosingEnrollment;
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

    public Collection<EnrollmentProgramPeriod> getEnrollmentProgramPeriodCollection() {
        return enrollmentProgramPeriodCollection;
    }

    public void setEnrollmentProgramPeriodCollection(Collection<EnrollmentProgramPeriod> enrollmentProgramPeriodCollection) {
        this.enrollmentProgramPeriodCollection = enrollmentProgramPeriodCollection;
    }

    public PedagogicalPeriod getPedagogicalPeriod() {
        return pedagogicalPeriod;
    }

    public void setPedagogicalPeriod(PedagogicalPeriod pedagogicalPeriod) {
        this.pedagogicalPeriod = pedagogicalPeriod;
    }

    public Program getProgram() {
        return program;
    }

    public void setProgram(Program program) {
        this.program = program;
    }

    public Collection<CourseDetail> getCourseDetailCollection() {
        return courseDetailCollection;
    }

    public void setCourseDetailCollection(Collection<CourseDetail> courseDetailCollection) {
        this.courseDetailCollection = courseDetailCollection;
    }

    public Collection<ModulusSchedule> getModulusScheduleCollection() {
        return modulusScheduleCollection;
    }

    public void setModulusScheduleCollection(Collection<ModulusSchedule> modulusScheduleCollection) {
        this.modulusScheduleCollection = modulusScheduleCollection;
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
