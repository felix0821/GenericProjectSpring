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
@Table(name = "period", catalog = "ucps_system", schema = "public")
@NamedQueries({
    @NamedQuery(name = "Period.findAll", query = "SELECT p FROM Period p"),
    @NamedQuery(name = "Period.findByPeriodId", query = "SELECT p FROM Period p WHERE p.periodId = :periodId"),
    @NamedQuery(name = "Period.findByPeriodIndex", query = "SELECT p FROM Period p WHERE p.periodIndex = :periodIndex"),
    @NamedQuery(name = "Period.findByPeriodIdentifier", query = "SELECT p FROM Period p WHERE p.periodIdentifier = :periodIdentifier"),
    @NamedQuery(name = "Period.findByPeriodName", query = "SELECT p FROM Period p WHERE p.periodName = :periodName"),
    @NamedQuery(name = "Period.findByPeriodYear", query = "SELECT p FROM Period p WHERE p.periodYear = :periodYear"),
    @NamedQuery(name = "Period.findByPeriodDescription", query = "SELECT p FROM Period p WHERE p.periodDescription = :periodDescription"),
    @NamedQuery(name = "Period.findByPeriodState", query = "SELECT p FROM Period p WHERE p.periodState = :periodState")})
public class Period implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "period_id")
    private Long periodId;
    @Column(name = "period_index")
    private Integer periodIndex;
    @Basic(optional = false)
    @Column(name = "period_identifier")
    private String periodIdentifier;
    @Basic(optional = false)
    @Column(name = "period_name")
    private String periodName;
    @Basic(optional = false)
    @Column(name = "period_year")
    private int periodYear;
    @Column(name = "period_description")
    private String periodDescription;
    @Basic(optional = false)
    @Column(name = "period_state")
    private Character periodState;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "period")
    private Collection<DataDetailPeriod> dataDetailPeriodCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "period")
    private Collection<ProgramPeriod> programPeriodCollection;
    @JoinColumn(name = "modality_id", referencedColumnName = "modality_id")
    @ManyToOne(optional = false)
    private PeriodModality modalityId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "period")
    private Collection<PeriodData> periodDataCollection;

    public Period() {
    }

    public Period(Long periodId) {
        this.periodId = periodId;
    }

    public Period(Long periodId, String periodIdentifier, String periodName, int periodYear, Character periodState) {
        this.periodId = periodId;
        this.periodIdentifier = periodIdentifier;
        this.periodName = periodName;
        this.periodYear = periodYear;
        this.periodState = periodState;
    }

    public Long getPeriodId() {
        return periodId;
    }

    public void setPeriodId(Long periodId) {
        this.periodId = periodId;
    }

    public Integer getPeriodIndex() {
        return periodIndex;
    }

    public void setPeriodIndex(Integer periodIndex) {
        this.periodIndex = periodIndex;
    }

    public String getPeriodIdentifier() {
        return periodIdentifier;
    }

    public void setPeriodIdentifier(String periodIdentifier) {
        this.periodIdentifier = periodIdentifier;
    }

    public String getPeriodName() {
        return periodName;
    }

    public void setPeriodName(String periodName) {
        this.periodName = periodName;
    }

    public int getPeriodYear() {
        return periodYear;
    }

    public void setPeriodYear(int periodYear) {
        this.periodYear = periodYear;
    }

    public String getPeriodDescription() {
        return periodDescription;
    }

    public void setPeriodDescription(String periodDescription) {
        this.periodDescription = periodDescription;
    }

    public Character getPeriodState() {
        return periodState;
    }

    public void setPeriodState(Character periodState) {
        this.periodState = periodState;
    }

    public Collection<DataDetailPeriod> getDataDetailPeriodCollection() {
        return dataDetailPeriodCollection;
    }

    public void setDataDetailPeriodCollection(Collection<DataDetailPeriod> dataDetailPeriodCollection) {
        this.dataDetailPeriodCollection = dataDetailPeriodCollection;
    }

    public Collection<ProgramPeriod> getProgramPeriodCollection() {
        return programPeriodCollection;
    }

    public void setProgramPeriodCollection(Collection<ProgramPeriod> programPeriodCollection) {
        this.programPeriodCollection = programPeriodCollection;
    }

    public PeriodModality getModalityId() {
        return modalityId;
    }

    public void setModalityId(PeriodModality modalityId) {
        this.modalityId = modalityId;
    }

    public Collection<PeriodData> getPeriodDataCollection() {
        return periodDataCollection;
    }

    public void setPeriodDataCollection(Collection<PeriodData> periodDataCollection) {
        this.periodDataCollection = periodDataCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (periodId != null ? periodId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Period)) {
            return false;
        }
        Period other = (Period) object;
        if ((this.periodId == null && other.periodId != null) || (this.periodId != null && !this.periodId.equals(other.periodId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.system.demo.persistence.entity.Period[ periodId=" + periodId + " ]";
    }
    
}
