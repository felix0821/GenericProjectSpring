/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.system.demo.persistence.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Felix
 */
@Entity
@Table(name = "payment_status")
@NamedQueries({
    @NamedQuery(name = "PaymentStatus.findAll", query = "SELECT p FROM PaymentStatus p"),
    @NamedQuery(name = "PaymentStatus.findByPaymentStatusId", query = "SELECT p FROM PaymentStatus p WHERE p.paymentStatusId = :paymentStatusId"),
    @NamedQuery(name = "PaymentStatus.findByPaymentStatusName", query = "SELECT p FROM PaymentStatus p WHERE p.paymentStatusName = :paymentStatusName"),
    @NamedQuery(name = "PaymentStatus.findByPaymentStatusDescription", query = "SELECT p FROM PaymentStatus p WHERE p.paymentStatusDescription = :paymentStatusDescription"),
    @NamedQuery(name = "PaymentStatus.findByPaymentStatusColor", query = "SELECT p FROM PaymentStatus p WHERE p.paymentStatusColor = :paymentStatusColor"),
    @NamedQuery(name = "PaymentStatus.findByPaymentStatusState", query = "SELECT p FROM PaymentStatus p WHERE p.paymentStatusState = :paymentStatusState")})
public class PaymentStatus implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "payment_status_id", nullable = false)
    private Long paymentStatusId;
    @Basic(optional = false)
    @Column(name = "payment_status_name", nullable = false, length = 64)
    private String paymentStatusName;
    @Column(name = "payment_status_description", length = 128)
    private String paymentStatusDescription;
    @Basic(optional = false)
    @Column(name = "payment_status_color", nullable = false, length = 32)
    private String paymentStatusColor;
    @Basic(optional = false)
    @Column(name = "payment_status_state", nullable = false)
    private Character paymentStatusState;
    @OneToMany(mappedBy = "paymentStatusId")
    private Collection<PaymentSchedule> paymentScheduleCollection;

    public PaymentStatus() {
    }

    public PaymentStatus(Long paymentStatusId) {
        this.paymentStatusId = paymentStatusId;
    }

    public PaymentStatus(Long paymentStatusId, String paymentStatusName, String paymentStatusColor, Character paymentStatusState) {
        this.paymentStatusId = paymentStatusId;
        this.paymentStatusName = paymentStatusName;
        this.paymentStatusColor = paymentStatusColor;
        this.paymentStatusState = paymentStatusState;
    }

    public Long getPaymentStatusId() {
        return paymentStatusId;
    }

    public void setPaymentStatusId(Long paymentStatusId) {
        this.paymentStatusId = paymentStatusId;
    }

    public String getPaymentStatusName() {
        return paymentStatusName;
    }

    public void setPaymentStatusName(String paymentStatusName) {
        this.paymentStatusName = paymentStatusName;
    }

    public String getPaymentStatusDescription() {
        return paymentStatusDescription;
    }

    public void setPaymentStatusDescription(String paymentStatusDescription) {
        this.paymentStatusDescription = paymentStatusDescription;
    }

    public String getPaymentStatusColor() {
        return paymentStatusColor;
    }

    public void setPaymentStatusColor(String paymentStatusColor) {
        this.paymentStatusColor = paymentStatusColor;
    }

    public Character getPaymentStatusState() {
        return paymentStatusState;
    }

    public void setPaymentStatusState(Character paymentStatusState) {
        this.paymentStatusState = paymentStatusState;
    }

    public Collection<PaymentSchedule> getPaymentScheduleCollection() {
        return paymentScheduleCollection;
    }

    public void setPaymentScheduleCollection(Collection<PaymentSchedule> paymentScheduleCollection) {
        this.paymentScheduleCollection = paymentScheduleCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (paymentStatusId != null ? paymentStatusId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PaymentStatus)) {
            return false;
        }
        PaymentStatus other = (PaymentStatus) object;
        if ((this.paymentStatusId == null && other.paymentStatusId != null) || (this.paymentStatusId != null && !this.paymentStatusId.equals(other.paymentStatusId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.system.demo.persistence.entity.PaymentStatus[ paymentStatusId=" + paymentStatusId + " ]";
    }
    
}
