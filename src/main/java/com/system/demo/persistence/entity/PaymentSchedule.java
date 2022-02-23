/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.system.demo.persistence.entity;

import java.io.Serializable;
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
@Table(name = "payment_schedule")
@NamedQueries({
    @NamedQuery(name = "PaymentSchedule.findAll", query = "SELECT p FROM PaymentSchedule p"),
    @NamedQuery(name = "PaymentSchedule.findByPaymentScheduleId", query = "SELECT p FROM PaymentSchedule p WHERE p.paymentScheduleId = :paymentScheduleId"),
    @NamedQuery(name = "PaymentSchedule.findByPaymentScheduleIndex", query = "SELECT p FROM PaymentSchedule p WHERE p.paymentScheduleIndex = :paymentScheduleIndex"),
    @NamedQuery(name = "PaymentSchedule.findByPaymentScheduleMonth", query = "SELECT p FROM PaymentSchedule p WHERE p.paymentScheduleMonth = :paymentScheduleMonth"),
    @NamedQuery(name = "PaymentSchedule.findByPaymentScheduleStartPayday", query = "SELECT p FROM PaymentSchedule p WHERE p.paymentScheduleStartPayday = :paymentScheduleStartPayday"),
    @NamedQuery(name = "PaymentSchedule.findByPaymentScheduleFinalPayday", query = "SELECT p FROM PaymentSchedule p WHERE p.paymentScheduleFinalPayday = :paymentScheduleFinalPayday")})
public class PaymentSchedule implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "payment_schedule_id", nullable = false)
    private Long paymentScheduleId;
    @Basic(optional = false)
    @Column(name = "payment_schedule_index", nullable = false)
    private int paymentScheduleIndex;
    @Basic(optional = false)
    @Column(name = "payment_schedule_month", nullable = false)
    private int paymentScheduleMonth;
    @Basic(optional = false)
    @Column(name = "payment_schedule_start_payday", nullable = false)
    private int paymentScheduleStartPayday;
    @Basic(optional = false)
    @Column(name = "payment_schedule_final_payday", nullable = false)
    private int paymentScheduleFinalPayday;
    @JoinColumns({
        @JoinColumn(name = "person_id", referencedColumnName = "person_id", nullable = false),
        @JoinColumn(name = "program_id", referencedColumnName = "program_id", nullable = false),
        @JoinColumn(name = "period_id", referencedColumnName = "period_id", nullable = false)})
    @ManyToOne(optional = false)
    private EnrollmentProgram enrollmentProgram;
    @JoinColumn(name = "payment_status_id", referencedColumnName = "payment_status_id")
    @ManyToOne
    private PaymentStatus paymentStatusId;

    public PaymentSchedule() {
    }

    public PaymentSchedule(Long paymentScheduleId) {
        this.paymentScheduleId = paymentScheduleId;
    }

    public PaymentSchedule(Long paymentScheduleId, int paymentScheduleIndex, int paymentScheduleMonth, int paymentScheduleStartPayday, int paymentScheduleFinalPayday) {
        this.paymentScheduleId = paymentScheduleId;
        this.paymentScheduleIndex = paymentScheduleIndex;
        this.paymentScheduleMonth = paymentScheduleMonth;
        this.paymentScheduleStartPayday = paymentScheduleStartPayday;
        this.paymentScheduleFinalPayday = paymentScheduleFinalPayday;
    }

    public Long getPaymentScheduleId() {
        return paymentScheduleId;
    }

    public void setPaymentScheduleId(Long paymentScheduleId) {
        this.paymentScheduleId = paymentScheduleId;
    }

    public int getPaymentScheduleIndex() {
        return paymentScheduleIndex;
    }

    public void setPaymentScheduleIndex(int paymentScheduleIndex) {
        this.paymentScheduleIndex = paymentScheduleIndex;
    }

    public int getPaymentScheduleMonth() {
        return paymentScheduleMonth;
    }

    public void setPaymentScheduleMonth(int paymentScheduleMonth) {
        this.paymentScheduleMonth = paymentScheduleMonth;
    }

    public int getPaymentScheduleStartPayday() {
        return paymentScheduleStartPayday;
    }

    public void setPaymentScheduleStartPayday(int paymentScheduleStartPayday) {
        this.paymentScheduleStartPayday = paymentScheduleStartPayday;
    }

    public int getPaymentScheduleFinalPayday() {
        return paymentScheduleFinalPayday;
    }

    public void setPaymentScheduleFinalPayday(int paymentScheduleFinalPayday) {
        this.paymentScheduleFinalPayday = paymentScheduleFinalPayday;
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