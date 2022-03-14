/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.system.demo.persistence.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Felix
 */
@Entity
@Table(name = "horary_detail", catalog = "ucps_system", schema = "public")
@NamedQueries({
    @NamedQuery(name = "HoraryDetail.findAll", query = "SELECT h FROM HoraryDetail h"),
    @NamedQuery(name = "HoraryDetail.findByHoraryDetailId", query = "SELECT h FROM HoraryDetail h WHERE h.horaryDetailId = :horaryDetailId"),
    @NamedQuery(name = "HoraryDetail.findByHoraryDetailDate", query = "SELECT h FROM HoraryDetail h WHERE h.horaryDetailDate = :horaryDetailDate"),
    @NamedQuery(name = "HoraryDetail.findByHoraryDetailException", query = "SELECT h FROM HoraryDetail h WHERE h.horaryDetailException = :horaryDetailException")})
public class HoraryDetail implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "horary_detail_id")
    private Long horaryDetailId;
    @Basic(optional = false)
    @Column(name = "horary_detail_date")
    @Temporal(TemporalType.DATE)
    private Date horaryDetailDate;
    @Basic(optional = false)
    @Column(name = "horary_detail_exception")
    private boolean horaryDetailException;
    @JoinColumn(name = "horary_id", referencedColumnName = "horary_id")
    @ManyToOne(optional = false)
    private Horary horaryId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "horaryDetail")
    private Collection<Assistance> assistanceCollection;

    public HoraryDetail() {
    }

    public HoraryDetail(Long horaryDetailId) {
        this.horaryDetailId = horaryDetailId;
    }

    public HoraryDetail(Long horaryDetailId, Date horaryDetailDate, boolean horaryDetailException) {
        this.horaryDetailId = horaryDetailId;
        this.horaryDetailDate = horaryDetailDate;
        this.horaryDetailException = horaryDetailException;
    }

    public Long getHoraryDetailId() {
        return horaryDetailId;
    }

    public void setHoraryDetailId(Long horaryDetailId) {
        this.horaryDetailId = horaryDetailId;
    }

    public Date getHoraryDetailDate() {
        return horaryDetailDate;
    }

    public void setHoraryDetailDate(Date horaryDetailDate) {
        this.horaryDetailDate = horaryDetailDate;
    }

    public boolean getHoraryDetailException() {
        return horaryDetailException;
    }

    public void setHoraryDetailException(boolean horaryDetailException) {
        this.horaryDetailException = horaryDetailException;
    }

    public Horary getHoraryId() {
        return horaryId;
    }

    public void setHoraryId(Horary horaryId) {
        this.horaryId = horaryId;
    }

    public Collection<Assistance> getAssistanceCollection() {
        return assistanceCollection;
    }

    public void setAssistanceCollection(Collection<Assistance> assistanceCollection) {
        this.assistanceCollection = assistanceCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (horaryDetailId != null ? horaryDetailId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HoraryDetail)) {
            return false;
        }
        HoraryDetail other = (HoraryDetail) object;
        if ((this.horaryDetailId == null && other.horaryDetailId != null) || (this.horaryDetailId != null && !this.horaryDetailId.equals(other.horaryDetailId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.system.demo.persistence.entity.HoraryDetail[ horaryDetailId=" + horaryDetailId + " ]";
    }
    
}
