/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.system.demo.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
@Table(name = "payment_discount")
@NamedQueries({
    @NamedQuery(name = "PaymentDiscount.findAll", query = "SELECT p FROM PaymentDiscount p"),
    @NamedQuery(name = "PaymentDiscount.findByPaymentDiscountId", query = "SELECT p FROM PaymentDiscount p WHERE p.paymentDiscountId = :paymentDiscountId"),
    @NamedQuery(name = "PaymentDiscount.findByPaymentDiscountName", query = "SELECT p FROM PaymentDiscount p WHERE p.paymentDiscountName = :paymentDiscountName"),
    @NamedQuery(name = "PaymentDiscount.findByPaymentDiscountDescription", query = "SELECT p FROM PaymentDiscount p WHERE p.paymentDiscountDescription = :paymentDiscountDescription"),
    @NamedQuery(name = "PaymentDiscount.findByPaymentDiscountState", query = "SELECT p FROM PaymentDiscount p WHERE p.paymentDiscountState = :paymentDiscountState"),
    @NamedQuery(name = "PaymentDiscount.findByPaymentDiscountPercent", query = "SELECT p FROM PaymentDiscount p WHERE p.paymentDiscountPercent = :paymentDiscountPercent")})
public class PaymentDiscount implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "payment_discount_id", nullable = false)
    private Long paymentDiscountId;
    @Basic(optional = false)
    @Column(name = "payment_discount_name", nullable = false, length = 64)
    private String paymentDiscountName;
    @Column(name = "payment_discount_description", length = 128)
    private String paymentDiscountDescription;
    @Basic(optional = false)
    @Column(name = "payment_discount_state", nullable = false)
    private Character paymentDiscountState;
    @Basic(optional = false)
    @Column(name = "payment_discount_percent", nullable = false)
    private double paymentDiscountPercent;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "paymentDiscount")
    private Collection<PaymentDiscountPerson> paymentDiscountPersonCollection;

    public PaymentDiscount() {
    }

    public PaymentDiscount(Long paymentDiscountId) {
        this.paymentDiscountId = paymentDiscountId;
    }

    public PaymentDiscount(Long paymentDiscountId, String paymentDiscountName, Character paymentDiscountState, double paymentDiscountPercent) {
        this.paymentDiscountId = paymentDiscountId;
        this.paymentDiscountName = paymentDiscountName;
        this.paymentDiscountState = paymentDiscountState;
        this.paymentDiscountPercent = paymentDiscountPercent;
    }

    public Long getPaymentDiscountId() {
        return paymentDiscountId;
    }

    public void setPaymentDiscountId(Long paymentDiscountId) {
        this.paymentDiscountId = paymentDiscountId;
    }

    public String getPaymentDiscountName() {
        return paymentDiscountName;
    }

    public void setPaymentDiscountName(String paymentDiscountName) {
        this.paymentDiscountName = paymentDiscountName;
    }

    public String getPaymentDiscountDescription() {
        return paymentDiscountDescription;
    }

    public void setPaymentDiscountDescription(String paymentDiscountDescription) {
        this.paymentDiscountDescription = paymentDiscountDescription;
    }

    public Character getPaymentDiscountState() {
        return paymentDiscountState;
    }

    public void setPaymentDiscountState(Character paymentDiscountState) {
        this.paymentDiscountState = paymentDiscountState;
    }

    public double getPaymentDiscountPercent() {
        return paymentDiscountPercent;
    }

    public void setPaymentDiscountPercent(double paymentDiscountPercent) {
        this.paymentDiscountPercent = paymentDiscountPercent;
    }

    public Collection<PaymentDiscountPerson> getPaymentDiscountPersonCollection() {
        return paymentDiscountPersonCollection;
    }

    public void setPaymentDiscountPersonCollection(Collection<PaymentDiscountPerson> paymentDiscountPersonCollection) {
        this.paymentDiscountPersonCollection = paymentDiscountPersonCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (paymentDiscountId != null ? paymentDiscountId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PaymentDiscount)) {
            return false;
        }
        PaymentDiscount other = (PaymentDiscount) object;
        if ((this.paymentDiscountId == null && other.paymentDiscountId != null) || (this.paymentDiscountId != null && !this.paymentDiscountId.equals(other.paymentDiscountId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.system.demo.model.PaymentDiscount[ paymentDiscountId=" + paymentDiscountId + " ]";
    }
    
}
