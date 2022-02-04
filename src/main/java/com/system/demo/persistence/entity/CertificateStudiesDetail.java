/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.system.demo.persistence.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "certificate_studies_detail")
@NamedQueries({
    @NamedQuery(name = "CertificateStudiesDetail.findAll", query = "SELECT c FROM CertificateStudiesDetail c"),
    @NamedQuery(name = "CertificateStudiesDetail.findByCertificateStudiesDetailId", query = "SELECT c FROM CertificateStudiesDetail c WHERE c.certificateStudiesDetailId = :certificateStudiesDetailId"),
    @NamedQuery(name = "CertificateStudiesDetail.findByCertificateStudiesDetailQualification", query = "SELECT c FROM CertificateStudiesDetail c WHERE c.certificateStudiesDetailQualification = :certificateStudiesDetailQualification")})
public class CertificateStudiesDetail implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "certificate_studies_detail_id", nullable = false)
    private Long certificateStudiesDetailId;
    @Basic(optional = false)
    @Column(name = "certificate_studies_detail_qualification", nullable = false)
    private int certificateStudiesDetailQualification;
    @JoinColumn(name = "certificate_studies_id", referencedColumnName = "certificate_studies_id", nullable = false)
    @ManyToOne(optional = false)
    private CertificateStudies certificateStudiesId;
    @JoinColumn(name = "course_id", referencedColumnName = "course_id", nullable = false)
    @ManyToOne(optional = false)
    private Course courseId;

    public CertificateStudiesDetail() {
    }

    public CertificateStudiesDetail(Long certificateStudiesDetailId) {
        this.certificateStudiesDetailId = certificateStudiesDetailId;
    }

    public CertificateStudiesDetail(Long certificateStudiesDetailId, int certificateStudiesDetailQualification) {
        this.certificateStudiesDetailId = certificateStudiesDetailId;
        this.certificateStudiesDetailQualification = certificateStudiesDetailQualification;
    }

    public Long getCertificateStudiesDetailId() {
        return certificateStudiesDetailId;
    }

    public void setCertificateStudiesDetailId(Long certificateStudiesDetailId) {
        this.certificateStudiesDetailId = certificateStudiesDetailId;
    }

    public int getCertificateStudiesDetailQualification() {
        return certificateStudiesDetailQualification;
    }

    public void setCertificateStudiesDetailQualification(int certificateStudiesDetailQualification) {
        this.certificateStudiesDetailQualification = certificateStudiesDetailQualification;
    }

    public CertificateStudies getCertificateStudiesId() {
        return certificateStudiesId;
    }

    public void setCertificateStudiesId(CertificateStudies certificateStudiesId) {
        this.certificateStudiesId = certificateStudiesId;
    }

    public Course getCourseId() {
        return courseId;
    }

    public void setCourseId(Course courseId) {
        this.courseId = courseId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (certificateStudiesDetailId != null ? certificateStudiesDetailId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CertificateStudiesDetail)) {
            return false;
        }
        CertificateStudiesDetail other = (CertificateStudiesDetail) object;
        if ((this.certificateStudiesDetailId == null && other.certificateStudiesDetailId != null) || (this.certificateStudiesDetailId != null && !this.certificateStudiesDetailId.equals(other.certificateStudiesDetailId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.system.demo.persistence.entity.CertificateStudiesDetail[ certificateStudiesDetailId=" + certificateStudiesDetailId + " ]";
    }
    
}
