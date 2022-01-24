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
@Table(name = "schedule")
@NamedQueries({
    @NamedQuery(name = "Schedule.findAll", query = "SELECT s FROM Schedule s"),
    @NamedQuery(name = "Schedule.findByProgramPeriodId", query = "SELECT s FROM Schedule s WHERE s.schedulePK.programPeriodId = :programPeriodId"),
    @NamedQuery(name = "Schedule.findByModuleId", query = "SELECT s FROM Schedule s WHERE s.schedulePK.moduleId = :moduleId"),
    @NamedQuery(name = "Schedule.findByScheduleStartMonth", query = "SELECT s FROM Schedule s WHERE s.scheduleStartMonth = :scheduleStartMonth"),
    @NamedQuery(name = "Schedule.findByScheduleFinalMonth", query = "SELECT s FROM Schedule s WHERE s.scheduleFinalMonth = :scheduleFinalMonth"),
    @NamedQuery(name = "Schedule.findByScheduleInterestArrears", query = "SELECT s FROM Schedule s WHERE s.scheduleInterestArrears = :scheduleInterestArrears"),
    @NamedQuery(name = "Schedule.findByScheduleState", query = "SELECT s FROM Schedule s WHERE s.scheduleState = :scheduleState")})
public class Schedule implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SchedulePK schedulePK;
    @Basic(optional = false)
    @Column(name = "schedule_start_month", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date scheduleStartMonth;
    @Basic(optional = false)
    @Column(name = "schedule_final_month", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date scheduleFinalMonth;
    @Basic(optional = false)
    @Column(name = "schedule_interest_arrears", nullable = false)
    private double scheduleInterestArrears;
    @Basic(optional = false)
    @Column(name = "schedule_state", nullable = false)
    private Character scheduleState;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "schedule")
    private Collection<CourseGroupTeaching> courseGroupTeachingCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "schedule")
    private Collection<PaymentSchedule> paymentScheduleCollection;
    @JoinColumn(name = "module_id", referencedColumnName = "module_id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Modulus modulus;
    @JoinColumn(name = "program_period_id", referencedColumnName = "program_period_id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private ProgramPeriod programPeriod;

    public Schedule() {
    }

    public Schedule(SchedulePK schedulePK) {
        this.schedulePK = schedulePK;
    }

    public Schedule(SchedulePK schedulePK, Date scheduleStartMonth, Date scheduleFinalMonth, double scheduleInterestArrears, Character scheduleState) {
        this.schedulePK = schedulePK;
        this.scheduleStartMonth = scheduleStartMonth;
        this.scheduleFinalMonth = scheduleFinalMonth;
        this.scheduleInterestArrears = scheduleInterestArrears;
        this.scheduleState = scheduleState;
    }

    public Schedule(long programPeriodId, long moduleId) {
        this.schedulePK = new SchedulePK(programPeriodId, moduleId);
    }

    public SchedulePK getSchedulePK() {
        return schedulePK;
    }

    public void setSchedulePK(SchedulePK schedulePK) {
        this.schedulePK = schedulePK;
    }

    public Date getScheduleStartMonth() {
        return scheduleStartMonth;
    }

    public void setScheduleStartMonth(Date scheduleStartMonth) {
        this.scheduleStartMonth = scheduleStartMonth;
    }

    public Date getScheduleFinalMonth() {
        return scheduleFinalMonth;
    }

    public void setScheduleFinalMonth(Date scheduleFinalMonth) {
        this.scheduleFinalMonth = scheduleFinalMonth;
    }

    public double getScheduleInterestArrears() {
        return scheduleInterestArrears;
    }

    public void setScheduleInterestArrears(double scheduleInterestArrears) {
        this.scheduleInterestArrears = scheduleInterestArrears;
    }

    public Character getScheduleState() {
        return scheduleState;
    }

    public void setScheduleState(Character scheduleState) {
        this.scheduleState = scheduleState;
    }

    public Collection<CourseGroupTeaching> getCourseGroupTeachingCollection() {
        return courseGroupTeachingCollection;
    }

    public void setCourseGroupTeachingCollection(Collection<CourseGroupTeaching> courseGroupTeachingCollection) {
        this.courseGroupTeachingCollection = courseGroupTeachingCollection;
    }

    public Collection<PaymentSchedule> getPaymentScheduleCollection() {
        return paymentScheduleCollection;
    }

    public void setPaymentScheduleCollection(Collection<PaymentSchedule> paymentScheduleCollection) {
        this.paymentScheduleCollection = paymentScheduleCollection;
    }

    public Modulus getModule() {
        return modulus;
    }

    public void setModule(Modulus modulus) {
        this.modulus = modulus;
    }

    public ProgramPeriod getProgramPeriod() {
        return programPeriod;
    }

    public void setProgramPeriod(ProgramPeriod programPeriod) {
        this.programPeriod = programPeriod;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (schedulePK != null ? schedulePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Schedule)) {
            return false;
        }
        Schedule other = (Schedule) object;
        if ((this.schedulePK == null && other.schedulePK != null) || (this.schedulePK != null && !this.schedulePK.equals(other.schedulePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.system.demo.model.Schedule[ schedulePK=" + schedulePK + " ]";
    }
    
}
