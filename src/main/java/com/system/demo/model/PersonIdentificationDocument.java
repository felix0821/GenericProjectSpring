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
@Table(name = "person_identification_document")
@NamedQueries({
    @NamedQuery(name = "PersonIdentificationDocument.findAll", query = "SELECT p FROM PersonIdentificationDocument p"),
    @NamedQuery(name = "PersonIdentificationDocument.findByIdentificationDocumentId", query = "SELECT p FROM PersonIdentificationDocument p WHERE p.personIdentificationDocumentPK.identificationDocumentId = :identificationDocumentId"),
    @NamedQuery(name = "PersonIdentificationDocument.findByPersonId", query = "SELECT p FROM PersonIdentificationDocument p WHERE p.personIdentificationDocumentPK.personId = :personId"),
    @NamedQuery(name = "PersonIdentificationDocument.findByPersonIdentificationDocumentValue", query = "SELECT p FROM PersonIdentificationDocument p WHERE p.personIdentificationDocumentValue = :personIdentificationDocumentValue")})
public class PersonIdentificationDocument implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PersonIdentificationDocumentPK personIdentificationDocumentPK;
    @Basic(optional = false)
    @Column(name = "person_identification_document_value", nullable = false, length = 128)
    private String personIdentificationDocumentValue;
    @JoinColumn(name = "identification_document_id", referencedColumnName = "identification_document_id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private IdentificationDocument identificationDocument;
    @JoinColumn(name = "person_id", referencedColumnName = "person_id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Person person;

    public PersonIdentificationDocument() {
    }

    public PersonIdentificationDocument(PersonIdentificationDocumentPK personIdentificationDocumentPK) {
        this.personIdentificationDocumentPK = personIdentificationDocumentPK;
    }

    public PersonIdentificationDocument(PersonIdentificationDocumentPK personIdentificationDocumentPK, String personIdentificationDocumentValue) {
        this.personIdentificationDocumentPK = personIdentificationDocumentPK;
        this.personIdentificationDocumentValue = personIdentificationDocumentValue;
    }

    public PersonIdentificationDocument(long identificationDocumentId, long personId) {
        this.personIdentificationDocumentPK = new PersonIdentificationDocumentPK(identificationDocumentId, personId);
    }

    public PersonIdentificationDocumentPK getPersonIdentificationDocumentPK() {
        return personIdentificationDocumentPK;
    }

    public void setPersonIdentificationDocumentPK(PersonIdentificationDocumentPK personIdentificationDocumentPK) {
        this.personIdentificationDocumentPK = personIdentificationDocumentPK;
    }

    public String getPersonIdentificationDocumentValue() {
        return personIdentificationDocumentValue;
    }

    public void setPersonIdentificationDocumentValue(String personIdentificationDocumentValue) {
        this.personIdentificationDocumentValue = personIdentificationDocumentValue;
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
        hash += (personIdentificationDocumentPK != null ? personIdentificationDocumentPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PersonIdentificationDocument)) {
            return false;
        }
        PersonIdentificationDocument other = (PersonIdentificationDocument) object;
        if ((this.personIdentificationDocumentPK == null && other.personIdentificationDocumentPK != null) || (this.personIdentificationDocumentPK != null && !this.personIdentificationDocumentPK.equals(other.personIdentificationDocumentPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.system.demo.model.PersonIdentificationDocument[ personIdentificationDocumentPK=" + personIdentificationDocumentPK + " ]";
    }
    
}
