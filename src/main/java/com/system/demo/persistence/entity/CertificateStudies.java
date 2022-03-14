/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.system.demo.persistence.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Felix
 */
@Entity
@Table(name = "certificate_studies", catalog = "ucps_system", schema = "public")
@NamedQueries({
    @NamedQuery(name = "CertificateStudies.findAll", query = "SELECT c FROM CertificateStudies c"),
    @NamedQuery(name = "CertificateStudies.findByCertificateStudiesId", query = "SELECT c FROM CertificateStudies c WHERE c.certificateStudiesId = :certificateStudiesId"),
    @NamedQuery(name = "CertificateStudies.findByCertificateStudiesCode", query = "SELECT c FROM CertificateStudies c WHERE c.certificateStudiesCode = :certificateStudiesCode")})
public class CertificateStudies implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "certificate_studies_id")
    private Long certificateStudiesId;
    @Column(name = "certificate_studies_code")
    private String certificateStudiesCode;
    @JoinColumn(name = "person_id", referencedColumnName = "person_id")
    @ManyToOne(optional = false)
    private Person personId;
    @JoinColumn(name = "program_id", referencedColumnName = "program_id")
    @ManyToOne(optional = false)
    private Program programId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "certificateStudiesId")
    private Collection<CertificateStudiesDetail> certificateStudiesDetailCollection;

    public CertificateStudies() {
    }

    public CertificateStudies(Long certificateStudiesId) {
        this.certificateStudiesId = certificateStudiesId;
    }

    public Long getCertificateStudiesId() {
        return certificateStudiesId;
    }

    public void setCertificateStudiesId(Long certificateStudiesId) {
        this.certificateStudiesId = certificateStudiesId;
    }

    public String getCertificateStudiesCode() {
        return certificateStudiesCode;
    }

    public void setCertificateStudiesCode(String certificateStudiesCode) {
        this.certificateStudiesCode = certificateStudiesCode;
    }

    public Person getPersonId() {
        return personId;
    }

    public void setPersonId(Person personId) {
        this.personId = personId;
    }

    public Program getProgramId() {
        return programId;
    }

    public void setProgramId(Program programId) {
        this.programId = programId;
    }

    public Collection<CertificateStudiesDetail> getCertificateStudiesDetailCollection() {
        return certificateStudiesDetailCollection;
    }

    public void setCertificateStudiesDetailCollection(Collection<CertificateStudiesDetail> certificateStudiesDetailCollection) {
        this.certificateStudiesDetailCollection = certificateStudiesDetailCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (certificateStudiesId != null ? certificateStudiesId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CertificateStudies)) {
            return false;
        }
        CertificateStudies other = (CertificateStudies) object;
        if ((this.certificateStudiesId == null && other.certificateStudiesId != null) || (this.certificateStudiesId != null && !this.certificateStudiesId.equals(other.certificateStudiesId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.system.demo.persistence.entity.CertificateStudies[ certificateStudiesId=" + certificateStudiesId + " ]";
    }
    
}
