/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.system.demo.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Felix
 */
@Embeddable
public class PaymentDiscountPersonPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "payment_discount_id", nullable = false)
    private long paymentDiscountId;
    @Basic(optional = false)
    @Column(name = "person_id", nullable = false)
    private long personId;

    public PaymentDiscountPersonPK() {
    }

    public PaymentDiscountPersonPK(long paymentDiscountId, long personId) {
        this.paymentDiscountId = paymentDiscountId;
        this.personId = personId;
    }

    public long getPaymentDiscountId() {
        return paymentDiscountId;
    }

    public void setPaymentDiscountId(long paymentDiscountId) {
        this.paymentDiscountId = paymentDiscountId;
    }

    public long getPersonId() {
        return personId;
    }

    public void setPersonId(long personId) {
        this.personId = personId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) paymentDiscountId;
        hash += (int) personId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PaymentDiscountPersonPK)) {
            return false;
        }
        PaymentDiscountPersonPK other = (PaymentDiscountPersonPK) object;
        if (this.paymentDiscountId != other.paymentDiscountId) {
            return false;
        }
        if (this.personId != other.personId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.system.demo.model.PaymentDiscountPersonPK[ paymentDiscountId=" + paymentDiscountId + ", personId=" + personId + " ]";
    }
    
}
