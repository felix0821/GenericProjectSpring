/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.system.demo.persistence.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Felix
 */
@Embeddable
public class PersonIdentificationDocumentPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "identification_document_id", nullable = false)
    private long identificationDocumentId;
    @Basic(optional = false)
    @Column(name = "person_id", nullable = false)
    private long personId;

    public PersonIdentificationDocumentPK() {
    }

    public PersonIdentificationDocumentPK(long identificationDocumentId, long personId) {
        this.identificationDocumentId = identificationDocumentId;
        this.personId = personId;
    }

    public long getIdentificationDocumentId() {
        return identificationDocumentId;
    }

    public void setIdentificationDocumentId(long identificationDocumentId) {
        this.identificationDocumentId = identificationDocumentId;
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
        hash += (int) identificationDocumentId;
        hash += (int) personId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PersonIdentificationDocumentPK)) {
            return false;
        }
        PersonIdentificationDocumentPK other = (PersonIdentificationDocumentPK) object;
        if (this.identificationDocumentId != other.identificationDocumentId) {
            return false;
        }
        if (this.personId != other.personId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.system.demo.model.PersonIdentificationDocumentPK[ identificationDocumentId=" + identificationDocumentId + ", personId=" + personId + " ]";
    }
    
}
