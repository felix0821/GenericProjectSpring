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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
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
@Table(name = "horary_course_group")
@NamedQueries({
    @NamedQuery(name = "HoraryCourseGroup.findAll", query = "SELECT h FROM HoraryCourseGroup h"),
    @NamedQuery(name = "HoraryCourseGroup.findByHoraryId", query = "SELECT h FROM HoraryCourseGroup h WHERE h.horaryCourseGroupPK.horaryId = :horaryId"),
    @NamedQuery(name = "HoraryCourseGroup.findByGroupId", query = "SELECT h FROM HoraryCourseGroup h WHERE h.horaryCourseGroupPK.groupId = :groupId"),
    @NamedQuery(name = "HoraryCourseGroup.findByModuleId", query = "SELECT h FROM HoraryCourseGroup h WHERE h.horaryCourseGroupPK.moduleId = :moduleId"),
    @NamedQuery(name = "HoraryCourseGroup.findByProgramPeriodId", query = "SELECT h FROM HoraryCourseGroup h WHERE h.horaryCourseGroupPK.programPeriodId = :programPeriodId"),
    @NamedQuery(name = "HoraryCourseGroup.findByCourseId", query = "SELECT h FROM HoraryCourseGroup h WHERE h.horaryCourseGroupPK.courseId = :courseId"),
    @NamedQuery(name = "HoraryCourseGroup.findByHoraryCourseGroupState", query = "SELECT h FROM HoraryCourseGroup h WHERE h.horaryCourseGroupState = :horaryCourseGroupState")})
public class HoraryCourseGroup implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected HoraryCourseGroupPK horaryCourseGroupPK;
    @Basic(optional = false)
    @Column(name = "horary_course_group_state", nullable = false)
    private Character horaryCourseGroupState;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "horaryCourseGroup")
    private Collection<Assistance> assistanceCollection;
    @JoinColumns({
        @JoinColumn(name = "group_id", referencedColumnName = "group_id", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "module_id", referencedColumnName = "module_id", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "program_period_id", referencedColumnName = "program_period_id", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "course_id", referencedColumnName = "course_id", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private CourseGroupTeaching courseGroupTeaching;
    @JoinColumn(name = "horary_id", referencedColumnName = "horary_id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Horary horary;

    public HoraryCourseGroup() {
    }

    public HoraryCourseGroup(HoraryCourseGroupPK horaryCourseGroupPK) {
        this.horaryCourseGroupPK = horaryCourseGroupPK;
    }

    public HoraryCourseGroup(HoraryCourseGroupPK horaryCourseGroupPK, Character horaryCourseGroupState) {
        this.horaryCourseGroupPK = horaryCourseGroupPK;
        this.horaryCourseGroupState = horaryCourseGroupState;
    }

    public HoraryCourseGroup(long horaryId, long groupId, long moduleId, long programPeriodId, long courseId) {
        this.horaryCourseGroupPK = new HoraryCourseGroupPK(horaryId, groupId, moduleId, programPeriodId, courseId);
    }

    public HoraryCourseGroupPK getHoraryCourseGroupPK() {
        return horaryCourseGroupPK;
    }

    public void setHoraryCourseGroupPK(HoraryCourseGroupPK horaryCourseGroupPK) {
        this.horaryCourseGroupPK = horaryCourseGroupPK;
    }

    public Character getHoraryCourseGroupState() {
        return horaryCourseGroupState;
    }

    public void setHoraryCourseGroupState(Character horaryCourseGroupState) {
        this.horaryCourseGroupState = horaryCourseGroupState;
    }

    public Collection<Assistance> getAssistanceCollection() {
        return assistanceCollection;
    }

    public void setAssistanceCollection(Collection<Assistance> assistanceCollection) {
        this.assistanceCollection = assistanceCollection;
    }

    public CourseGroupTeaching getCourseGroupTeaching() {
        return courseGroupTeaching;
    }

    public void setCourseGroupTeaching(CourseGroupTeaching courseGroupTeaching) {
        this.courseGroupTeaching = courseGroupTeaching;
    }

    public Horary getHorary() {
        return horary;
    }

    public void setHorary(Horary horary) {
        this.horary = horary;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (horaryCourseGroupPK != null ? horaryCourseGroupPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HoraryCourseGroup)) {
            return false;
        }
        HoraryCourseGroup other = (HoraryCourseGroup) object;
        if ((this.horaryCourseGroupPK == null && other.horaryCourseGroupPK != null) || (this.horaryCourseGroupPK != null && !this.horaryCourseGroupPK.equals(other.horaryCourseGroupPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.system.demo.model.HoraryCourseGroup[ horaryCourseGroupPK=" + horaryCourseGroupPK + " ]";
    }
    
}
