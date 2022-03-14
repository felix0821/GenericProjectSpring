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
@Table(name = "person_identification", catalog = "ucps_system", schema = "public")
@NamedQueries({
    @NamedQuery(name = "PersonIdentification.findAll", query = "SELECT p FROM PersonIdentification p"),
    @NamedQuery(name = "PersonIdentification.findByPersonId", query = "SELECT p FROM PersonIdentification p WHERE p.personIdentificationPK.personId = :personId"),
    @NamedQuery(name = "PersonIdentification.findByIdentificationDocumentId", query = "SELECT p FROM PersonIdentification p WHERE p.personIdentificationPK.identificationDocumentId = :identificationDocumentId"),
    @NamedQuery(name = "PersonIdentification.findByPersonIdentificationValue", query = "SELECT p FROM PersonIdentification p WHERE p.personIdentificationValue = :personIdentificationValue")})
public class PersonIdentification implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PersonIdentificationPK personIdentificationPK;
    @Basic(optional = false)
    @Column(name = "person_identification_value")
    private String personIdentificationValue;
    @JoinColumn(name = "identification_document_id", referencedColumnName = "identification_document_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private IdentificationDocument identificationDocument;
    @JoinColumn(name = "person_id", referencedColumnName = "person_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Person person;

    public PersonIdentification() {
    }

    public PersonIdentification(PersonIdentificationPK personIdentificationPK) {
        this.personIdentificationPK = personIdentificationPK;
    }

    public PersonIdentification(PersonIdentificationPK personIdentificationPK, String personIdentificationValue) {
        this.personIdentificationPK = personIdentificationPK;
        this.personIdentificationValue = personIdentificationValue;
    }

    public PersonIdentification(long personId, long identificationDocumentId) {
        this.personIdentificationPK = new PersonIdentificationPK(personId, identificationDocumentId);
    }

    public PersonIdentificationPK getPersonIdentificationPK() {
        return personIdentificationPK;
    }

    public void setPersonIdentificationPK(PersonIdentificationPK personIdentificationPK) {
        this.personIdentificationPK = personIdentificationPK;
    }

    public String getPersonIdentificationValue() {
        return personIdentificationValue;
    }

    public void setPersonIdentificationValue(String personIdentificationValue) {
        this.personIdentificationValue = personIdentificationValue;
    }

    public IdentificationDocument getIdentificationDocument() {
        return identificationDocument;
    }

    public void setIdentificationDocument(IdentificationDocument identificationDocument) {
        this.identificationDocument = identificationDocument;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (personIdentificationPK != null ? personIdentificationPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PersonIdentification)) {
            return false;
        }
        PersonIdentification other = (PersonIdentification) object;
        if ((this.personIdentificationPK == null && other.personIdentificationPK != null) || (this.personIdentificationPK != null && !this.personIdentificationPK.equals(other.personIdentificationPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.system.demo.persistence.entity.PersonIdentification[ personIdentificationPK=" + personIdentificationPK + " ]";
    }
    
}
