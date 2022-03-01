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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Felix
 */
@Entity
@Table(name = "modulus_schedule")
@NamedQueries({
    @NamedQuery(name = "ModulusSchedule.findAll", query = "SELECT m FROM ModulusSchedule m"),
    @NamedQuery(name = "ModulusSchedule.findByScheduleId", query = "SELECT m FROM ModulusSchedule m WHERE m.scheduleId = :scheduleId"),
    @NamedQuery(name = "ModulusSchedule.findByScheduleStartDate", query = "SELECT m FROM ModulusSchedule m WHERE m.scheduleStartDate = :scheduleStartDate"),
    @NamedQuery(name = "ModulusSchedule.findByScheduleFinalDate", query = "SELECT m FROM ModulusSchedule m WHERE m.scheduleFinalDate = :scheduleFinalDate"),
    @NamedQuery(name = "ModulusSchedule.findByScheduleState", query = "SELECT m FROM ModulusSchedule m WHERE m.scheduleState = :scheduleState")})
public class ModulusSchedule implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "schedule_id", nullable = false)
    private Long scheduleId;
    @Column(name = "schedule_start_date")
    @Temporal(TemporalType.DATE)
    private Date scheduleStartDate;
    @Column(name = "schedule_final_date")
    @Temporal(TemporalType.DATE)
    private Date scheduleFinalDate;
    @Basic(optional = false)
    @Column(name = "schedule_state", nullable = false)
    private Character scheduleState;
    @OneToMany(mappedBy = "scheduleId")
    private Collection<CourseRole> courseRoleCollection;
    @OneToMany(mappedBy = "scheduleId")
    private Collection<CourseDetail> courseDetailCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "scheduleId")
    private Collection<ModulusDetail> modulusDetailCollection;

    public ModulusSchedule() {
    }

    public ModulusSchedule(Long scheduleId) {
        this.scheduleId = scheduleId;
    }

    public ModulusSchedule(Long scheduleId, Character scheduleState) {
        this.scheduleId = scheduleId;
        this.scheduleState = scheduleState;
    }

    public Long getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(Long scheduleId) {
        this.scheduleId = scheduleId;
    }

    public Date getScheduleStartDate() {
        return scheduleStartDate;
    }

    public void setScheduleStartDate(Date scheduleStartDate) {
        this.scheduleStartDate = scheduleStartDate;
    }

    public Date getScheduleFinalDate() {
        return scheduleFinalDate;
    }

    public void setScheduleFinalDate(Date scheduleFinalDate) {
        this.scheduleFinalDate = scheduleFinalDate;
    }

    public Character getScheduleState() {
        return scheduleState;
    }

    public void setScheduleState(Character scheduleState) {
        this.scheduleState = scheduleState;
    }

    public Collection<CourseRole> getCourseRoleCollection() {
        return courseRoleCollection;
    }

    public void setCourseRoleCollection(Collection<CourseRole> courseRoleCollection) {
        this.courseRoleCollection = courseRoleCollection;
    }

    public Collection<CourseDetail> getCourseDetailCollection() {
        return courseDetailCollection;
    }

    public void setCourseDetailCollection(Collection<CourseDetail> courseDetailCollection) {
        this.courseDetailCollection = courseDetailCollection;
    }

    public Collection<ModulusDetail> getModulusDetailCollection() {
        return modulusDetailCollection;
    }

    public void setModulusDetailCollection(Collection<ModulusDetail> modulusDetailCollection) {
        this.modulusDetailCollection = modulusDetailCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (scheduleId != null ? scheduleId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ModulusSchedule)) {
            return false;
        }
        ModulusSchedule other = (ModulusSchedule) object;
        if ((this.scheduleId == null && other.scheduleId != null) || (this.scheduleId != null && !this.scheduleId.equals(other.scheduleId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.system.demo.persistence.entity.ModulusSchedule[ scheduleId=" + scheduleId + " ]";
    }
    
}
