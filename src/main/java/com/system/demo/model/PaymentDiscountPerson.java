/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.system.demo.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Felix
 */
@Entity
@Table(name = "payment_discount_person")
@NamedQueries({
    @NamedQuery(name = "PaymentDiscountPerson.findAll", query = "SELECT p FROM PaymentDiscountPerson p"),
    @NamedQuery(name = "PaymentDiscountPerson.findByPaymentDiscountId", query = "SELECT p FROM PaymentDiscountPerson p WHERE p.paymentDiscountPersonPK.paymentDiscountId = :paymentDiscountId"),
    @NamedQuery(name = "PaymentDiscountPerson.findByPersonId", query = "SELECT p FROM PaymentDiscountPerson p WHERE p.paymentDiscountPersonPK.personId = :personId"),
    @NamedQuery(name = "PaymentDiscountPerson.findByPaymentDiscountPersonResource", query = "SELECT p FROM PaymentDiscountPerson p WHERE p.paymentDiscountPersonResource = :paymentDiscountPersonResource"),
    @NamedQuery(name = "PaymentDiscountPerson.findByPaymentDiscountPersonState", query = "SELECT p FROM PaymentDiscountPerson p WHERE p.paymentDiscountPersonState = :paymentDiscountPersonState")})
public class PaymentDiscountPerson implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PaymentDiscountPersonPK paymentDiscountPersonPK;
    @Basic(optional = false)
    @Column(name = "payment_discount_person_resource", nullable = false, length = 256)
    private String paymentDiscountPersonResource;
    @Basic(optional = false)
    @Column(name = "payment_discount_person_state", nullable = false)
    private Character paymentDiscountPersonState;
    @JoinColumn(name = "payment_discount_id", referencedColumnName = "payment_discount_id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private PaymentDiscount paymentDiscount;
    @JoinColumn(name = "person_id", referencedColumnName = "person_id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Person person;
    @JoinColumn(name = "person_registering_id", referencedColumnName = "person_registering_id")
    @ManyToOne
    private PersonRegistering personRegisteringId;

    public PaymentDiscountPerson() {
    }

    public PaymentDiscountPerson(PaymentDiscountPersonPK paymentDiscountPersonPK) {
        this.paymentDiscountPersonPK = paymentDiscountPersonPK;
    }

    public PaymentDiscountPerson(PaymentDiscountPersonPK paymentDiscountPersonPK, String paymentDiscountPersonResource, Character paymentDiscountPersonState) {
        this.paymentDiscountPersonPK = paymentDiscountPersonPK;
        this.paymentDiscountPersonResource = paymentDiscountPersonResource;
        this.paymentDiscountPersonState = paymentDiscountPersonState;
    }

    public PaymentDiscountPerson(long paymentDiscountId, long personId) {
        this.paymentDiscountPersonPK = new PaymentDiscountPersonPK(paymentDiscountId, personId);
    }

    public PaymentDiscountPersonPK getPaymentDiscountPersonPK() {
        return paymentDiscountPersonPK;
    }

    public void setPaymentDiscountPersonPK(PaymentDiscountPersonPK paymentDiscountPersonPK) {
        this.paymentDiscountPersonPK = paymentDiscountPersonPK;
    }

    public String getPaymentDiscountPersonResource() {
        return paymentDiscountPersonResource;
    }

    public void setPaymentDiscountPersonResource(String paymentDiscountPersonResource) {
        this.paymentDiscountPersonResource = paymentDiscountPersonResource;
    }

    public Character getPaymentDiscountPersonState() {
        return paymentDiscountPersonState;
    }

    public void setPaymentDiscountPersonState(Character paymentDiscountPersonState) {
        this.paymentDiscountPersonState = paymentDiscountPersonState;
    }

    public PaymentDiscount getPaymentDiscount() {
        return paymentDiscount;
    }

    public void setPaymentDiscount(PaymentDiscount paymentDiscount) {
        this.paymentDiscount = paymentDiscount;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public PersonRegistering getPersonRegisteringId() {
        return personRegisteringId;
    }

    public void setPersonRegisteringId(PersonRegistering personRegisteringId) {
        this.personRegisteringId = personRegisteringId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (paymentDiscountPersonPK != null ? paymentDiscountPersonPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PaymentDiscountPerson)) {
            return false;
        }
        PaymentDiscountPerson other = (PaymentDiscountPerson) object;
        if ((this.paymentDiscountPersonPK == null && other.paymentDiscountPersonPK != null) || (this.paymentDiscountPersonPK != null && !this.paymentDiscountPersonPK.equals(other.paymentDiscountPersonPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.system.demo.model.PaymentDiscountPerson[ paymentDiscountPersonPK=" + paymentDiscountPersonPK + " ]";
    }
    
}
