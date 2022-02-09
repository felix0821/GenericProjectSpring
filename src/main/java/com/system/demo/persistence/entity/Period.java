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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author Felix
 */
@Entity
@Table(name = "pedagogical_period", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"pedagogical_period_identifier"})})
@NamedQueries({
    @NamedQuery(name = "PedagogicalPeriod.findAll", query = "SELECT p FROM PedagogicalPeriod p"),
    @NamedQuery(name = "PedagogicalPeriod.findByPedagogicalPeriodId", query = "SELECT p FROM PedagogicalPeriod p WHERE p.pedagogicalPeriodId = :pedagogicalPeriodId"),
    @NamedQuery(name = "PedagogicalPeriod.findByPedagogicalPeriodIndex", query = "SELECT p FROM PedagogicalPeriod p WHERE p.pedagogicalPeriodIndex = :pedagogicalPeriodIndex"),
    @NamedQuery(name = "PedagogicalPeriod.findByPedagogicalPeriodIdentifier", query = "SELECT p FROM PedagogicalPeriod p WHERE p.pedagogicalPeriodIdentifier = :pedagogicalPeriodIdentifier"),
    @NamedQuery(name = "PedagogicalPeriod.findByPedagogicalPeriodName", query = "SELECT p FROM PedagogicalPeriod p WHERE p.pedagogicalPeriodName = :pedagogicalPeriodName"),
    @NamedQuery(name = "PedagogicalPeriod.findByPedagogicalPeriodYear", query = "SELECT p FROM PedagogicalPeriod p WHERE p.pedagogicalPeriodYear = :pedagogicalPeriodYear"),
    @NamedQuery(name = "PedagogicalPeriod.findByPedagogicalPeriodDescription", query = "SELECT p FROM PedagogicalPeriod p WHERE p.pedagogicalPeriodDescription = :pedagogicalPeriodDescription"),
    @NamedQuery(name = "PedagogicalPeriod.findByPedagogicalPeriodModality", query = "SELECT p FROM PedagogicalPeriod p WHERE p.pedagogicalPeriodModality = :pedagogicalPeriodModality"),
    @NamedQuery(name = "PedagogicalPeriod.findByPedagogicalPeriodState", query = "SELECT p FROM PedagogicalPeriod p WHERE p.pedagogicalPeriodState = :pedagogicalPeriodState")})
public class Period implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "pedagogical_period_id", nullable = false)
    private Long pedagogicalPeriodId;
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pedagogical_period_index", nullable = false)
    private int pedagogicalPeriodIndex;
    @Basic(optional = false)
    @Column(name = "pedagogical_period_identifier", nullable = false, length = 40)
    private String pedagogicalPeriodIdentifier;
    @Basic(optional = false)
    @Column(name = "pedagogical_period_name", nullable = false, length = 32)
    private String pedagogicalPeriodName;
    @Basic(optional = false)
    @Column(name = "pedagogical_period_year", nullable = false)
    private int pedagogicalPeriodYear;
    @Column(name = "pedagogical_period_description", length = 128)
    private String pedagogicalPeriodDescription;
    @Basic(optional = false)
    @Column(name = "pedagogical_period_modality", nullable = false)
    private Character pedagogicalPeriodModality;
    @Basic(optional = false)
    @Column(name = "pedagogical_period_state", nullable = false)
    private Character pedagogicalPeriodState;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pedagogicalPeriod")
    private Collection<ProgramPeriod> programPeriodCollection;

    public Period() {
    }

    public Period(Long pedagogicalPeriodId) {
        this.pedagogicalPeriodId = pedagogicalPeriodId;
    }

    public Period(Long pedagogicalPeriodId, int pedagogicalPeriodIndex, String pedagogicalPeriodIdentifier, String pedagogicalPeriodName, int pedagogicalPeriodYear, Character pedagogicalPeriodModality, Character pedagogicalPeriodState) {
        this.pedagogicalPeriodId = pedagogicalPeriodId;
        this.pedagogicalPeriodIndex = pedagogicalPeriodIndex;
        this.pedagogicalPeriodIdentifier = pedagogicalPeriodIdentifier;
        this.pedagogicalPeriodName = pedagogicalPeriodName;
        this.pedagogicalPeriodYear = pedagogicalPeriodYear;
        this.pedagogicalPeriodModality = pedagogicalPeriodModality;
        this.pedagogicalPeriodState = pedagogicalPeriodState;
    }

    public Long getPeriodId() {
        return pedagogicalPeriodId;
    }

    public void setPeriodId(Long pedagogicalPeriodId) {
        this.pedagogicalPeriodId = pedagogicalPeriodId;
    }

    public int getPeriodIndex() {
        return pedagogicalPeriodIndex;
    }

    public void setPeriodIndex(int pedagogicalPeriodIndex) {
        this.pedagogicalPeriodIndex = pedagogicalPeriodIndex;
    }

    public String getPeriodIdentifier() {
        return pedagogicalPeriodIdentifier;
    }

    public void setPeriodIdentifier(String pedagogicalPeriodIdentifier) {
        this.pedagogicalPeriodIdentifier = pedagogicalPeriodIdentifier;
    }

    public String getPeriodName() {
        return pedagogicalPeriodName;
    }

    public void setPeriodName(String pedagogicalPeriodName) {
        this.pedagogicalPeriodName = pedagogicalPeriodName;
    }

    public int getPeriodYear() {
        return pedagogicalPeriodYear;
    }

    public void setPeriodYear(int pedagogicalPeriodYear) {
        this.pedagogicalPeriodYear = pedagogicalPeriodYear;
    }

    public String getPeriodDescription() {
        return pedagogicalPeriodDescription;
    }

    public void setPeriodDescription(String pedagogicalPeriodDescription) {
        this.pedagogicalPeriodDescription = pedagogicalPeriodDescription;
    }

    public Character getPeriodModality() {
        return pedagogicalPeriodModality;
    }

    public void setPeriodModality(Character pedagogicalPeriodModality) {
        this.pedagogicalPeriodModality = pedagogicalPeriodModality;
    }

    public Character getPeriodState() {
        return pedagogicalPeriodState;
    }

    public void setPeriodState(Character pedagogicalPeriodState) {
        this.pedagogicalPeriodState = pedagogicalPeriodState;
    }

    public Collection<ProgramPeriod> getProgramPeriodCollection() {
        return programPeriodCollection;
    }

    public void setProgramPeriodCollection(Collection<ProgramPeriod> programPeriodCollection) {
        this.programPeriodCollection = programPeriodCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pedagogicalPeriodId != null ? pedagogicalPeriodId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Period)) {
            return false;
        }
        Period other = (Period) object;
        if ((this.pedagogicalPeriodId == null && other.pedagogicalPeriodId != null) || (this.pedagogicalPeriodId != null && !this.pedagogicalPeriodId.equals(other.pedagogicalPeriodId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.system.demo.persistence.entity.PedagogicalPeriod[ pedagogicalPeriodId=" + pedagogicalPeriodId + " ]";
    }
    
}
