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
@Table(name = "schedule")
@NamedQueries({
    @NamedQuery(name = "Schedule.findAll", query = "SELECT s FROM Schedule s"),
    @NamedQuery(name = "Schedule.findByScheduleId", query = "SELECT s FROM Schedule s WHERE s.scheduleId = :scheduleId"),
    @NamedQuery(name = "Schedule.findByScheduleStartDate", query = "SELECT s FROM Schedule s WHERE s.scheduleStartDate = :scheduleStartDate"),
    @NamedQuery(name = "Schedule.findByScheduleClosingDate", query = "SELECT s FROM Schedule s WHERE s.scheduleClosingDate = :scheduleClosingDate"),
    @NamedQuery(name = "Schedule.findByScheduleFinalDate", query = "SELECT s FROM Schedule s WHERE s.scheduleFinalDate = :scheduleFinalDate"),
    @NamedQuery(name = "Schedule.findByScheduleState", query = "SELECT s FROM Schedule s WHERE s.scheduleState = :scheduleState")})
public class Schedule implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "schedule_id", nullable = false)
    private Long scheduleId;
    @Column(name = "schedule_start_date")
    @Temporal(TemporalType.DATE)
    private Date scheduleStartDate;
    @Column(name = "schedule_closing_date")
    @Temporal(TemporalType.DATE)
    private Date scheduleClosingDate;
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

    public Schedule() {
    }

    public Schedule(Long scheduleId) {
        this.scheduleId = scheduleId;
    }

    public Schedule(Long scheduleId, Character scheduleState) {
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

    public Date getScheduleClosingDate() {
        return scheduleClosingDate;
    }

    public void setScheduleClosingDate(Date scheduleClosingDate) {
        this.scheduleClosingDate = scheduleClosingDate;
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
        if (!(object instanceof Schedule)) {
            return false;
        }
        Schedule other = (Schedule) object;
        if ((this.scheduleId == null && other.scheduleId != null) || (this.scheduleId != null && !this.scheduleId.equals(other.scheduleId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.system.demo.persistence.entity.Schedule[ scheduleId=" + scheduleId + " ]";
    }
    
}
