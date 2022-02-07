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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Felix
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Horary.findAll", query = "SELECT h FROM Horary h"),
    @NamedQuery(name = "Horary.findByHoraryId", query = "SELECT h FROM Horary h WHERE h.horaryId = :horaryId"),
    @NamedQuery(name = "Horary.findByHoraryDay", query = "SELECT h FROM Horary h WHERE h.horaryDay = :horaryDay"),
    @NamedQuery(name = "Horary.findByHoraryTimeStart", query = "SELECT h FROM Horary h WHERE h.horaryTimeStart = :horaryTimeStart"),
    @NamedQuery(name = "Horary.findByHoraryTimeFinal", query = "SELECT h FROM Horary h WHERE h.horaryTimeFinal = :horaryTimeFinal")})
public class Horary implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "horary_id", nullable = false)
    private Long horaryId;
    @Basic(optional = false)
    @Column(name = "horary_day", nullable = false)
    private Character horaryDay;
    @Basic(optional = false)
    @Column(name = "horary_time_start", nullable = false)
    @Temporal(TemporalType.TIME)
    private Date horaryTimeStart;
    @Basic(optional = false)
    @Column(name = "horary_time_final", nullable = false)
    @Temporal(TemporalType.TIME)
    private Date horaryTimeFinal;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "horary")
    private Collection<HoraryCourseGroup> horaryCourseGroupCollection;

    public Horary() {
    }

    public Horary(Long horaryId) {
        this.horaryId = horaryId;
    }

    public Horary(Long horaryId, Character horaryDay, Date horaryTimeStart, Date horaryTimeFinal) {
        this.horaryId = horaryId;
        this.horaryDay = horaryDay;
        this.horaryTimeStart = horaryTimeStart;
        this.horaryTimeFinal = horaryTimeFinal;
    }

    public Long getHoraryId() {
        return horaryId;
    }

    public void setHoraryId(Long horaryId) {
        this.horaryId = horaryId;
    }

    public Character getHoraryDay() {
        return horaryDay;
    }

    public void setHoraryDay(Character horaryDay) {
        this.horaryDay = horaryDay;
    }

    public Date getHoraryTimeStart() {
        return horaryTimeStart;
    }

    public void setHoraryTimeStart(Date horaryTimeStart) {
        this.horaryTimeStart = horaryTimeStart;
    }

    public Date getHoraryTimeFinal() {
        return horaryTimeFinal;
    }

    public void setHoraryTimeFinal(Date horaryTimeFinal) {
        this.horaryTimeFinal = horaryTimeFinal;
    }

    public Collection<HoraryCourseGroup> getHoraryCourseGroupCollection() {
        return horaryCourseGroupCollection;
    }

    public void setHoraryCourseGroupCollection(Collection<HoraryCourseGroup> horaryCourseGroupCollection) {
        this.horaryCourseGroupCollection = horaryCourseGroupCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (horaryId != null ? horaryId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Horary)) {
            return false;
        }
        Horary other = (Horary) object;
        if ((this.horaryId == null && other.horaryId != null) || (this.horaryId != null && !this.horaryId.equals(other.horaryId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.system.demo.persistence.entity.Horary[ horaryId=" + horaryId + " ]";
    }
    
}
