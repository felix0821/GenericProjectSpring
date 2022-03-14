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
@Table(name = "modulus_detail", catalog = "ucps_system", schema = "public")
@NamedQueries({
    @NamedQuery(name = "ModulusDetail.findAll", query = "SELECT m FROM ModulusDetail m"),
    @NamedQuery(name = "ModulusDetail.findByModulusId", query = "SELECT m FROM ModulusDetail m WHERE m.modulusDetailPK.modulusId = :modulusId"),
    @NamedQuery(name = "ModulusDetail.findByProgramId", query = "SELECT m FROM ModulusDetail m WHERE m.modulusDetailPK.programId = :programId"),
    @NamedQuery(name = "ModulusDetail.findByPeriodId", query = "SELECT m FROM ModulusDetail m WHERE m.modulusDetailPK.periodId = :periodId"),
    @NamedQuery(name = "ModulusDetail.findByModulusDetailState", query = "SELECT m FROM ModulusDetail m WHERE m.modulusDetailState = :modulusDetailState")})
public class ModulusDetail implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ModulusDetailPK modulusDetailPK;
    @Basic(optional = false)
    @Column(name = "modulus_detail_state")
    private Character modulusDetailState;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "modulusDetail")
    private Collection<CourseDetail> courseDetailCollection;
    @JoinColumn(name = "modulus_id", referencedColumnName = "modulus_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Modulus modulus;
    @JoinColumn(name = "schedule_id", referencedColumnName = "schedule_id")
    @ManyToOne(optional = false)
    private ModulusSchedule scheduleId;
    @JoinColumns({
        @JoinColumn(name = "program_id", referencedColumnName = "program_id", insertable = false, updatable = false),
        @JoinColumn(name = "period_id", referencedColumnName = "period_id", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private ProgramPeriod programPeriod;

    public ModulusDetail() {
    }

    public ModulusDetail(ModulusDetailPK modulusDetailPK) {
        this.modulusDetailPK = modulusDetailPK;
    }

    public ModulusDetail(ModulusDetailPK modulusDetailPK, Character modulusDetailState) {
        this.modulusDetailPK = modulusDetailPK;
        this.modulusDetailState = modulusDetailState;
    }

    public ModulusDetail(long modulusId, long programId, long periodId) {
        this.modulusDetailPK = new ModulusDetailPK(modulusId, programId, periodId);
    }

    public ModulusDetailPK getModulusDetailPK() {
        return modulusDetailPK;
    }

    public void setModulusDetailPK(ModulusDetailPK modulusDetailPK) {
        this.modulusDetailPK = modulusDetailPK;
    }

    public Character getModulusDetailState() {
        return modulusDetailState;
    }

    public void setModulusDetailState(Character modulusDetailState) {
        this.modulusDetailState = modulusDetailState;
    }

    public Collection<CourseDetail> getCourseDetailCollection() {
        return courseDetailCollection;
    }

    public void setCourseDetailCollection(Collection<CourseDetail> courseDetailCollection) {
        this.courseDetailCollection = courseDetailCollection;
    }

    public Modulus getModulus() {
        return modulus;
    }

    public void setModulus(Modulus modulus) {
        this.modulus = modulus;
    }

    public ModulusSchedule getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(ModulusSchedule scheduleId) {
        this.scheduleId = scheduleId;
    }

    public ProgramPeriod getProgramPeriod() {
        return programPeriod;
    }

    public void setProgramPeriod(ProgramPeriod programPeriod) {
        this.programPeriod = programPeriod;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (modulusDetailPK != null ? modulusDetailPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ModulusDetail)) {
            return false;
        }
        ModulusDetail other = (ModulusDetail) object;
        if ((this.modulusDetailPK == null && other.modulusDetailPK != null) || (this.modulusDetailPK != null && !this.modulusDetailPK.equals(other.modulusDetailPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.system.demo.persistence.entity.ModulusDetail[ modulusDetailPK=" + modulusDetailPK + " ]";
    }
    
}
