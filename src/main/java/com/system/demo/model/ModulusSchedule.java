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
@Table(name = "modulus_schedule")
@NamedQueries({
    @NamedQuery(name = "ModulusSchedule.findAll", query = "SELECT m FROM ModulusSchedule m"),
    @NamedQuery(name = "ModulusSchedule.findByModulusId", query = "SELECT m FROM ModulusSchedule m WHERE m.modulusSchedulePK.modulusId = :modulusId"),
    @NamedQuery(name = "ModulusSchedule.findByProgramPeriodId", query = "SELECT m FROM ModulusSchedule m WHERE m.modulusSchedulePK.programPeriodId = :programPeriodId"),
    @NamedQuery(name = "ModulusSchedule.findByModulusScheduleStartMonth", query = "SELECT m FROM ModulusSchedule m WHERE m.modulusScheduleStartMonth = :modulusScheduleStartMonth"),
    @NamedQuery(name = "ModulusSchedule.findByModulusScheduleFinalMonth", query = "SELECT m FROM ModulusSchedule m WHERE m.modulusScheduleFinalMonth = :modulusScheduleFinalMonth"),
    @NamedQuery(name = "ModulusSchedule.findByModulusScheduleInterestArrears", query = "SELECT m FROM ModulusSchedule m WHERE m.modulusScheduleInterestArrears = :modulusScheduleInterestArrears"),
    @NamedQuery(name = "ModulusSchedule.findByModulusScheduleState", query = "SELECT m FROM ModulusSchedule m WHERE m.modulusScheduleState = :modulusScheduleState")})
public class ModulusSchedule implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ModulusSchedulePK modulusSchedulePK;
    @Basic(optional = false)
    @Column(name = "modulus_schedule_start_month", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date modulusScheduleStartMonth;
    @Basic(optional = false)
    @Column(name = "modulus_schedule_final_month", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date modulusScheduleFinalMonth;
    @Basic(optional = false)
    @Column(name = "modulus_schedule_interest_arrears", nullable = false)
    private double modulusScheduleInterestArrears;
    @Basic(optional = false)
    @Column(name = "modulus_schedule_state", nullable = false)
    private Character modulusScheduleState;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "modulusSchedule")
    private Collection<CourseDetail> courseDetailCollection;
    @JoinColumn(name = "modulus_id", referencedColumnName = "modulus_id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Modulus modulus;
    @JoinColumn(name = "program_period_id", referencedColumnName = "program_period_id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private ProgramPeriod programPeriod;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "modulusSchedule")
    private Collection<PedagogicalSchedulePayment> pedagogicalSchedulePaymentCollection;

    public ModulusSchedule() {
    }

    public ModulusSchedule(ModulusSchedulePK modulusSchedulePK) {
        this.modulusSchedulePK = modulusSchedulePK;
    }

    public ModulusSchedule(ModulusSchedulePK modulusSchedulePK, Date modulusScheduleStartMonth, Date modulusScheduleFinalMonth, double modulusScheduleInterestArrears, Character modulusScheduleState) {
        this.modulusSchedulePK = modulusSchedulePK;
        this.modulusScheduleStartMonth = modulusScheduleStartMonth;
        this.modulusScheduleFinalMonth = modulusScheduleFinalMonth;
        this.modulusScheduleInterestArrears = modulusScheduleInterestArrears;
        this.modulusScheduleState = modulusScheduleState;
    }

    public ModulusSchedule(long modulusId, long programPeriodId) {
        this.modulusSchedulePK = new ModulusSchedulePK(modulusId, programPeriodId);
    }

    public ModulusSchedulePK getModulusSchedulePK() {
        return modulusSchedulePK;
    }

    public void setModulusSchedulePK(ModulusSchedulePK modulusSchedulePK) {
        this.modulusSchedulePK = modulusSchedulePK;
    }

    public Date getModulusScheduleStartMonth() {
        return modulusScheduleStartMonth;
    }

    public void setModulusScheduleStartMonth(Date modulusScheduleStartMonth) {
        this.modulusScheduleStartMonth = modulusScheduleStartMonth;
    }

    public Date getModulusScheduleFinalMonth() {
        return modulusScheduleFinalMonth;
    }

    public void setModulusScheduleFinalMonth(Date modulusScheduleFinalMonth) {
        this.modulusScheduleFinalMonth = modulusScheduleFinalMonth;
    }

    public double getModulusScheduleInterestArrears() {
        return modulusScheduleInterestArrears;
    }

    public void setModulusScheduleInterestArrears(double modulusScheduleInterestArrears) {
        this.modulusScheduleInterestArrears = modulusScheduleInterestArrears;
    }

    public Character getModulusScheduleState() {
        return modulusScheduleState;
    }

    public void setModulusScheduleState(Character modulusScheduleState) {
        this.modulusScheduleState = modulusScheduleState;
    }

    public Collection<CourseDetail> getCourseDetailCollection() {
        return courseDetailCollection;
    }

    public void setCourseDetailCollection(Collection<CourseDetail> courseDetailCollection) {
        this.courseDetailCollection = courseDetailCollection;
    }

    public Modulus getModulus() {
        return modulus;
    }

    public void setModulus(Modulus modulus) {
        this.modulus = modulus;
    }

    public ProgramPeriod getProgramPeriod() {
        return programPeriod;
    }

    public void setProgramPeriod(ProgramPeriod programPeriod) {
        this.programPeriod = programPeriod;
    }

    public Collection<PedagogicalSchedulePayment> getPedagogicalSchedulePaymentCollection() {
        return pedagogicalSchedulePaymentCollection;
    }

    public void setPedagogicalSchedulePaymentCollection(Collection<PedagogicalSchedulePayment> pedagogicalSchedulePaymentCollection) {
        this.pedagogicalSchedulePaymentCollection = pedagogicalSchedulePaymentCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (modulusSchedulePK != null ? modulusSchedulePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ModulusSchedule)) {
            return false;
        }
        ModulusSchedule other = (ModulusSchedule) object;
        if ((this.modulusSchedulePK == null && other.modulusSchedulePK != null) || (this.modulusSchedulePK != null && !this.modulusSchedulePK.equals(other.modulusSchedulePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.system.demo.model.ModulusSchedule[ modulusSchedulePK=" + modulusSchedulePK + " ]";
    }
    
}
