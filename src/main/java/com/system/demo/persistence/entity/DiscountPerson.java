/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.system.demo.persistence.entity;

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
@Table(name = "discount_person")
@NamedQueries({
    @NamedQuery(name = "DiscountPerson.findAll", query = "SELECT d FROM DiscountPerson d"),
    @NamedQuery(name = "DiscountPerson.findByPaymentDiscountId", query = "SELECT d FROM DiscountPerson d WHERE d.discountPersonPK.paymentDiscountId = :paymentDiscountId"),
    @NamedQuery(name = "DiscountPerson.findByPersonId", query = "SELECT d FROM DiscountPerson d WHERE d.discountPersonPK.personId = :personId"),
    @NamedQuery(name = "DiscountPerson.findByDiscountPersonResource", query = "SELECT d FROM DiscountPerson d WHERE d.discountPersonResource = :discountPersonResource"),
    @NamedQuery(name = "DiscountPerson.findByDiscountPersonState", query = "SELECT d FROM DiscountPerson d WHERE d.discountPersonState = :discountPersonState")})
public class DiscountPerson implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DiscountPersonPK discountPersonPK;
    @Basic(optional = false)
    @Column(name = "discount_person_resource", nullable = false, length = 256)
    private String discountPersonResource;
    @Basic(optional = false)
    @Column(name = "discount_person_state", nullable = false)
    private Character discountPersonState;
    @JoinColumn(name = "payment_discount_id", referencedColumnName = "payment_discount_id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private PaymentDiscount paymentDiscount;
    @JoinColumn(name = "person_id", referencedColumnName = "person_id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Person person;
    @JoinColumn(name = "person_registering_id", referencedColumnName = "person_registering_id")
    @ManyToOne
    private PersonRegistering personRegisteringId;

    public DiscountPerson() {
    }

    public DiscountPerson(DiscountPersonPK discountPersonPK) {
        this.discountPersonPK = discountPersonPK;
    }

    public DiscountPerson(DiscountPersonPK discountPersonPK, String discountPersonResource, Character discountPersonState) {
        this.discountPersonPK = discountPersonPK;
        this.discountPersonResource = discountPersonResource;
        this.discountPersonState = discountPersonState;
    }

    public DiscountPerson(long paymentDiscountId, long personId) {
        this.discountPersonPK = new DiscountPersonPK(paymentDiscountId, personId);
    }

    public DiscountPersonPK getDiscountPersonPK() {
        return discountPersonPK;
    }

    public void setDiscountPersonPK(DiscountPersonPK discountPersonPK) {
        this.discountPersonPK = discountPersonPK;
    }

    public String getDiscountPersonResource() {
        return discountPersonResource;
    }

    public void setDiscountPersonResource(String discountPersonResource) {
        this.discountPersonResource = discountPersonResource;
    }

    public Character getDiscountPersonState() {
        return discountPersonState;
    }

    public void setDiscountPersonState(Character discountPersonState) {
        this.discountPersonState = discountPersonState;
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
        hash += (discountPersonPK != null ? discountPersonPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DiscountPerson)) {
            return false;
        }
        DiscountPerson other = (DiscountPerson) object;
        if ((this.discountPersonPK == null && other.discountPersonPK != null) || (this.discountPersonPK != null && !this.discountPersonPK.equals(other.discountPersonPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.system.demo.persistence.entity.DiscountPerson[ discountPersonPK=" + discountPersonPK + " ]";
    }
    
}
