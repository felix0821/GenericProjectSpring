/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.system.demo.persistence.entity;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Felix
 */
@Entity
@Table(name = "payment_schedule", catalog = "ucps_system", schema = "public")
@NamedQueries({
    @NamedQuery(name = "PaymentSchedule.findAll", query = "SELECT p FROM PaymentSchedule p"),
    @NamedQuery(name = "PaymentSchedule.findByPaymentScheduleId", query = "SELECT p FROM PaymentSchedule p WHERE p.paymentScheduleId = :paymentScheduleId"),
    @NamedQuery(name = "PaymentSchedule.findByPaymentScheduleIndex", query = "SELECT p FROM PaymentSchedule p WHERE p.paymentScheduleIndex = :paymentScheduleIndex")})
public class PaymentSchedule implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "payment_schedule_id")
    private Long paymentScheduleId;
    @Column(name = "payment_schedule_index")
    private BigInteger paymentScheduleIndex;
    @JoinColumns({
        @JoinColumn(name = "person_id", referencedColumnName = "person_id"),
        @JoinColumn(name = "program_id", referencedColumnName = "program_id"),
        @JoinColumn(name = "period_id", referencedColumnName = "period_id")})
    @ManyToOne(optional = false)
    private EnrollmentProgram enrollmentProgram;
    @JoinColumn(name = "payment_status_id", referencedColumnName = "payment_status_id")
    @ManyToOne(optional = false)
    private PaymentStatus paymentStatusId;
    @JoinColumn(name = "shedule_id", referencedColumnName = "shedule_id")
    @ManyToOne(optional = false)
    private ProgramShedule sheduleId;

    public PaymentSchedule() {
    }

    public PaymentSchedule(Long paymentScheduleId) {
        this.paymentScheduleId = paymentScheduleId;
    }

    public Long getPaymentScheduleId() {
        return paymentScheduleId;
    }

    public void setPaymentScheduleId(Long paymentScheduleId) {
        this.paymentScheduleId = paymentScheduleId;
    }

    public BigInteger getPaymentScheduleIndex() {
        return paymentScheduleIndex;
    }

    public void setPaymentScheduleIndex(BigInteger paymentScheduleIndex) {
        this.paymentScheduleIndex = paymentScheduleIndex;
    }

    public EnrollmentProgram getEnrollmentProgram() {
        return enrollmentProgram;
    }

    public void setEnrollmentProgram(EnrollmentProgram enrollmentProgram) {
        this.enrollmentProgram = enrollmentProgram;
    }

    public PaymentStatus getPaymentStatusId() {
        return paymentStatusId;
    }

    public void setPaymentStatusId(PaymentStatus paymentStatusId) {
        this.paymentStatusId = paymentStatusId;
    }

    public ProgramShedule getSheduleId() {
        return sheduleId;
    }

    public void setSheduleId(ProgramShedule sheduleId) {
        this.sheduleId = sheduleId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (paymentScheduleId != null ? paymentScheduleId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PaymentSchedule)) {
            return false;
        }
        PaymentSchedule other = (PaymentSchedule) object;
        if ((this.paymentScheduleId == null && other.paymentScheduleId != null) || (this.paymentScheduleId != null && !this.paymentScheduleId.equals(other.paymentScheduleId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.system.demo.persistence.entity.PaymentSchedule[ paymentScheduleId=" + paymentScheduleId + " ]";
    }
    
}
