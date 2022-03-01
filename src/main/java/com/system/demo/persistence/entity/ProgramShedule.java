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
@Table(name = "program_shedule")
@NamedQueries({
    @NamedQuery(name = "ProgramShedule.findAll", query = "SELECT p FROM ProgramShedule p"),
    @NamedQuery(name = "ProgramShedule.findBySheduleId", query = "SELECT p FROM ProgramShedule p WHERE p.sheduleId = :sheduleId"),
    @NamedQuery(name = "ProgramShedule.findByProgramSheduleMonth", query = "SELECT p FROM ProgramShedule p WHERE p.programSheduleMonth = :programSheduleMonth"),
    @NamedQuery(name = "ProgramShedule.findByProgramSheduleStartDate", query = "SELECT p FROM ProgramShedule p WHERE p.programSheduleStartDate = :programSheduleStartDate"),
    @NamedQuery(name = "ProgramShedule.findByProgramSheduleFinalDate", query = "SELECT p FROM ProgramShedule p WHERE p.programSheduleFinalDate = :programSheduleFinalDate")})
public class ProgramShedule implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "shedule_id", nullable = false)
    private Long sheduleId;
    @Basic(optional = false)
    @Column(name = "program_shedule_month", nullable = false)
    private int programSheduleMonth;
    @Basic(optional = false)
    @Column(name = "program_shedule_start_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date programSheduleStartDate;
    @Basic(optional = false)
    @Column(name = "program_shedule_final_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date programSheduleFinalDate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sheduleId")
    private Collection<PaymentSchedule> paymentScheduleCollection;
    @JoinColumns({
        @JoinColumn(name = "program_id", referencedColumnName = "program_id", nullable = false),
        @JoinColumn(name = "period_id", referencedColumnName = "period_id", nullable = false)})
    @ManyToOne(optional = false)
    private ProgramPeriod programPeriod;

    public ProgramShedule() {
    }

    public ProgramShedule(Long sheduleId) {
        this.sheduleId = sheduleId;
    }

    public ProgramShedule(Long sheduleId, int programSheduleMonth, Date programSheduleStartDate, Date programSheduleFinalDate) {
        this.sheduleId = sheduleId;
        this.programSheduleMonth = programSheduleMonth;
        this.programSheduleStartDate = programSheduleStartDate;
        this.programSheduleFinalDate = programSheduleFinalDate;
    }

    public Long getSheduleId() {
        return sheduleId;
    }

    public void setSheduleId(Long sheduleId) {
        this.sheduleId = sheduleId;
    }

    public int getProgramSheduleMonth() {
        return programSheduleMonth;
    }

    public void setProgramSheduleMonth(int programSheduleMonth) {
        this.programSheduleMonth = programSheduleMonth;
    }

    public Date getProgramSheduleStartDate() {
        return programSheduleStartDate;
    }

    public void setProgramSheduleStartDate(Date programSheduleStartDate) {
        this.programSheduleStartDate = programSheduleStartDate;
    }

    public Date getProgramSheduleFinalDate() {
        return programSheduleFinalDate;
    }

    public void setProgramSheduleFinalDate(Date programSheduleFinalDate) {
        this.programSheduleFinalDate = programSheduleFinalDate;
    }

    public Collection<PaymentSchedule> getPaymentScheduleCollection() {
        return paymentScheduleCollection;
    }

    public void setPaymentScheduleCollection(Collection<PaymentSchedule> paymentScheduleCollection) {
        this.paymentScheduleCollection = paymentScheduleCollection;
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
        hash += (sheduleId != null ? sheduleId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProgramShedule)) {
            return false;
        }
        ProgramShedule other = (ProgramShedule) object;
        if ((this.sheduleId == null && other.sheduleId != null) || (this.sheduleId != null && !this.sheduleId.equals(other.sheduleId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.system.demo.persistence.entity.ProgramShedule[ sheduleId=" + sheduleId + " ]";
    }
    
}
