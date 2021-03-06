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
public class PersonIdentificationPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "person_id")
    private long personId;
    @Basic(optional = false)
    @Column(name = "identification_document_id")
    private long identificationDocumentId;

    public PersonIdentificationPK() {
    }

    public PersonIdentificationPK(long personId, long identificationDocumentId) {
        this.personId = personId;
        this.identificationDocumentId = identificationDocumentId;
    }

    public long getPersonId() {
        return personId;
    }

    public void setPersonId(long personId) {
        this.personId = personId;
    }

    public long getIdentificationDocumentId() {
        return identificationDocumentId;
    }

    public void setIdentificationDocumentId(long identificationDocumentId) {
        this.identificationDocumentId = identificationDocumentId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) personId;
        hash += (int) identificationDocumentId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PersonIdentificationPK)) {
            return false;
        }
        PersonIdentificationPK other = (PersonIdentificationPK) object;
        if (this.personId != other.personId) {
            return false;
        }
        if (this.identificationDocumentId != other.identificationDocumentId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.system.demo.persistence.entity.PersonIdentificationPK[ personId=" + personId + ", identificationDocumentId=" + identificationDocumentId + " ]";
    }
    
}
