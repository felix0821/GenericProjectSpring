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
@Table(name = "identification_document")
@NamedQueries({
    @NamedQuery(name = "IdentificationDocument.findAll", query = "SELECT i FROM IdentificationDocument i"),
    @NamedQuery(name = "IdentificationDocument.findByIdentificationDocumentId", query = "SELECT i FROM IdentificationDocument i WHERE i.identificationDocumentId = :identificationDocumentId"),
    @NamedQuery(name = "IdentificationDocument.findByIdentificationDocumentName", query = "SELECT i FROM IdentificationDocument i WHERE i.identificationDocumentName = :identificationDocumentName"),
    @NamedQuery(name = "IdentificationDocument.findByIdentificationDocumentState", query = "SELECT i FROM IdentificationDocument i WHERE i.identificationDocumentState = :identificationDocumentState"),
    @NamedQuery(name = "IdentificationDocument.findByIdentificationDocumentValidation", query = "SELECT i FROM IdentificationDocument i WHERE i.identificationDocumentValidation = :identificationDocumentValidation")})
public class IdentificationDocument implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "identification_document_id", nullable = false)
    private Long identificationDocumentId;
    @Basic(optional = false)
    @Column(name = "identification_document_name", nullable = false, length = 64)
    private String identificationDocumentName;
    @Basic(optional = false)
    @Column(name = "identification_document_state", nullable = false)
    private Character identificationDocumentState;
    @Basic(optional = false)
    @Column(name = "identification_document_validation", nullable = false)
    private Character identificationDocumentValidation;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "identificationDocument")
    private Collection<PersonIdentificationDocument> identificationDocumentPersonCollection;

    public IdentificationDocument() {
    }

    public IdentificationDocument(Long identificationDocumentId) {
        this.identificationDocumentId = identificationDocumentId;
    }

    public IdentificationDocument(Long identificationDocumentId, String identificationDocumentName, Character identificationDocumentState, Character identificationDocumentValidation) {
        this.identificationDocumentId = identificationDocumentId;
        this.identificationDocumentName = identificationDocumentName;
        this.identificationDocumentState = identificationDocumentState;
        this.identificationDocumentValidation = identificationDocumentValidation;
    }

    public Long getIdentificationDocumentId() {
        return identificationDocumentId;
    }

    public void setIdentificationDocumentId(Long identificationDocumentId) {
        this.identificationDocumentId = identificationDocumentId;
    }

    public String getIdentificationDocumentName() {
        return identificationDocumentName;
    }

    public void setIdentificationDocumentName(String identificationDocumentName) {
        this.identificationDocumentName = identificationDocumentName;
    }

    public Character getIdentificationDocumentState() {
        return identificationDocumentState;
    }

    public void setIdentificationDocumentState(Character identificationDocumentState) {
        this.identificationDocumentState = identificationDocumentState;
    }

    public Character getIdentificationDocumentValidation() {
        return identificationDocumentValidation;
    }

    public void setIdentificationDocumentValidation(Character identificationDocumentValidation) {
        this.identificationDocumentValidation = identificationDocumentValidation;
    }

    public Collection<PersonIdentificationDocument> getIdentificationDocumentPersonCollection() {
        return identificationDocumentPersonCollection;
    }

    public void setIdentificationDocumentPersonCollection(Collection<PersonIdentificationDocument> identificationDocumentPersonCollection) {
        this.identificationDocumentPersonCollection = identificationDocumentPersonCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (identificationDocumentId != null ? identificationDocumentId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof IdentificationDocument)) {
            return false;
        }
        IdentificationDocument other = (IdentificationDocument) object;
        if ((this.identificationDocumentId == null && other.identificationDocumentId != null) || (this.identificationDocumentId != null && !this.identificationDocumentId.equals(other.identificationDocumentId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.system.demo.model.IdentificationDocument[ identificationDocumentId=" + identificationDocumentId + " ]";
    }
    
}
