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
    @NamedQuery(name = "ModulusSchedule.findByProgramPeriodId", query = "SELECT m FROM ModulusSchedule m WHERE m.modulusSchedulePK.programPeriodId = :programPeriodId"),
    @NamedQuery(name = "ModulusSchedule.findByModulusId", query = "SELECT m FROM ModulusSchedule m WHERE m.modulusSchedulePK.modulusId = :modulusId"),
    @NamedQuery(name = "ModulusSchedule.findByModulusScheduleStartDate", query = "SELECT m FROM ModulusSchedule m WHERE m.modulusScheduleStartDate = :modulusScheduleStartDate"),
    @NamedQuery(name = "ModulusSchedule.findByModulusScheduleFinalDate", query = "SELECT m FROM ModulusSchedule m WHERE m.modulusScheduleFinalDate = :modulusScheduleFinalDate"),
    @NamedQuery(name = "ModulusSchedule.findByModulusScheduleInterestArrears", query = "SELECT m FROM ModulusSchedule m WHERE m.modulusScheduleInterestArrears = :modulusScheduleInterestArrears"),
    @NamedQuery(name = "ModulusSchedule.findByModulusScheduleState", query = "SELECT m FROM ModulusSchedule m WHERE m.modulusScheduleState = :modulusScheduleState")})
public class ModulusSchedule implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ModulusSchedulePK modulusSchedulePK;
    @Basic(optional = false)
    @Column(name = "modulus_schedule_start_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date modulusScheduleStartDate;
    @Basic(optional = false)
    @Column(name = "modulus_schedule_final_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date modulusScheduleFinalDate;
    @Basic(optional = false)
    @Column(name = "modulus_schedule_interest_arrears", nullable = false)
    private double modulusScheduleInterestArrears;
    @Basic(optional = false)
    @Column(name = "modulus_schedule_state", nullable = false)
    private Character modulusScheduleState;
    @JoinColumn(name = "modulus_id", referencedColumnName = "modulus_id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Modulus modulus;
    @JoinColumn(name = "program_period_id", referencedColumnName = "program_period_id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private ProgramPeriod programPeriod;
    @OneToMany(mappedBy = "modulusSchedule")
    private Collection<PedagogicalSchedulePayment> pedagogicalSchedulePaymentCollection;

    public ModulusSchedule() {
    }

    public ModulusSchedule(ModulusSchedulePK modulusSchedulePK) {
        this.modulusSchedulePK = modulusSchedulePK;
    }

    public ModulusSchedule(ModulusSchedulePK modulusSchedulePK, Date modulusScheduleStartDate, Date modulusScheduleFinalDate, double modulusScheduleInterestArrears, Character modulusScheduleState) {
        this.modulusSchedulePK = modulusSchedulePK;
        this.modulusScheduleStartDate = modulusScheduleStartDate;
        this.modulusScheduleFinalDate = modulusScheduleFinalDate;
        this.modulusScheduleInterestArrears = modulusScheduleInterestArrears;
        this.modulusScheduleState = modulusScheduleState;
    }

    public ModulusSchedule(long programPeriodId, long modulusId) {
        this.modulusSchedulePK = new ModulusSchedulePK(programPeriodId, modulusId);
    }

    public ModulusSchedulePK getModulusSchedulePK() {
        return modulusSchedulePK;
    }

    public void setModulusSchedulePK(ModulusSchedulePK modulusSchedulePK) {
        this.modulusSchedulePK = modulusSchedulePK;
    }

    public Date getModulusScheduleStartDate() {
        return modulusScheduleStartDate;
    }

    public void setModulusScheduleStartDate(Date modulusScheduleStartDate) {
        this.modulusScheduleStartDate = modulusScheduleStartDate;
    }

    public Date getModulusScheduleFinalDate() {
        return modulusScheduleFinalDate;
    }

    public void setModulusScheduleFinalDate(Date modulusScheduleFinalDate) {
        this.modulusScheduleFinalDate = modulusScheduleFinalDate;
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
        return "com.system.demo.persistence.entity.ModulusSchedule[ modulusSchedulePK=" + modulusSchedulePK + " ]";
    }
    
}
