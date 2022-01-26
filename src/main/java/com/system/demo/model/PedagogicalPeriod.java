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
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Felix
 */
@Entity
@Table(name = "pedagogical_period")
@NamedQueries({
    @NamedQuery(name = "PedagogicalPeriod.findAll", query = "SELECT p FROM PedagogicalPeriod p"),
    @NamedQuery(name = "PedagogicalPeriod.findByPedagogicalPeriodId", query = "SELECT p FROM PedagogicalPeriod p WHERE p.pedagogicalPeriodId = :pedagogicalPeriodId"),
    @NamedQuery(name = "PedagogicalPeriod.findByPedagogicalPeriodName", query = "SELECT p FROM PedagogicalPeriod p WHERE p.pedagogicalPeriodName = :pedagogicalPeriodName"),
    @NamedQuery(name = "PedagogicalPeriod.findByPedagogicalPeriodDescription", query = "SELECT p FROM PedagogicalPeriod p WHERE p.pedagogicalPeriodDescription = :pedagogicalPeriodDescription"),
    @NamedQuery(name = "PedagogicalPeriod.findByPedagogicalPeriodModality", query = "SELECT p FROM PedagogicalPeriod p WHERE p.pedagogicalPeriodModality = :pedagogicalPeriodModality"),
    @NamedQuery(name = "PedagogicalPeriod.findByPedagogicalPeriodYear", query = "SELECT p FROM PedagogicalPeriod p WHERE p.pedagogicalPeriodYear = :pedagogicalPeriodYear"),
    @NamedQuery(name = "PedagogicalPeriod.findByPedagogicalPeriodState", query = "SELECT p FROM PedagogicalPeriod p WHERE p.pedagogicalPeriodState = :pedagogicalPeriodState")})
public class PedagogicalPeriod implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "pedagogical_period_id", nullable = false)
    private Long pedagogicalPeriodId;
    @Basic(optional = false)
    @Column(name = "pedagogical_period_name", nullable = false, length = 32)
    private String pedagogicalPeriodName;
    @Column(name = "pedagogical_period_description", length = 128)
    private String pedagogicalPeriodDescription;
    @Basic(optional = false)
    @Column(name = "pedagogical_period_modality", nullable = false)
    private Character pedagogicalPeriodModality;
    @Basic(optional = false)
    @Column(name = "pedagogical_period_year", nullable = false)
    private int pedagogicalPeriodYear;
    @Basic(optional = false)
    @Column(name = "pedagogical_period_state", nullable = false)
    private Character pedagogicalPeriodState;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pedagogicalPeriodId")
    private Collection<ProgramPeriod> programPeriodCollection;

    public PedagogicalPeriod() {
    }

    public PedagogicalPeriod(Long pedagogicalPeriodId) {
        this.pedagogicalPeriodId = pedagogicalPeriodId;
    }

    public PedagogicalPeriod(Long pedagogicalPeriodId, String pedagogicalPeriodName, Character pedagogicalPeriodModality, int pedagogicalPeriodYear, Character pedagogicalPeriodState) {
        this.pedagogicalPeriodId = pedagogicalPeriodId;
        this.pedagogicalPeriodName = pedagogicalPeriodName;
        this.pedagogicalPeriodModality = pedagogicalPeriodModality;
        this.pedagogicalPeriodYear = pedagogicalPeriodYear;
        this.pedagogicalPeriodState = pedagogicalPeriodState;
    }

    public Long getPedagogicalPeriodId() {
        return pedagogicalPeriodId;
    }

    public void setPedagogicalPeriodId(Long pedagogicalPeriodId) {
        this.pedagogicalPeriodId = pedagogicalPeriodId;
    }

    public String getPedagogicalPeriodName() {
        return pedagogicalPeriodName;
    }

    public void setPedagogicalPeriodName(String pedagogicalPeriodName) {
        this.pedagogicalPeriodName = pedagogicalPeriodName;
    }

    public String getPedagogicalPeriodDescription() {
        return pedagogicalPeriodDescription;
    }

    public void setPedagogicalPeriodDescription(String pedagogicalPeriodDescription) {
        this.pedagogicalPeriodDescription = pedagogicalPeriodDescription;
    }

    public Character getPedagogicalPeriodModality() {
        return pedagogicalPeriodModality;
    }

    public void setPedagogicalPeriodModality(Character pedagogicalPeriodModality) {
        this.pedagogicalPeriodModality = pedagogicalPeriodModality;
    }

    public int getPedagogicalPeriodYear() {
        return pedagogicalPeriodYear;
    }

    public void setPedagogicalPeriodYear(int pedagogicalPeriodYear) {
        this.pedagogicalPeriodYear = pedagogicalPeriodYear;
    }

    public Character getPedagogicalPeriodState() {
        return pedagogicalPeriodState;
    }

    public void setPedagogicalPeriodState(Character pedagogicalPeriodState) {
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
        if (!(object instanceof PedagogicalPeriod)) {
            return false;
        }
        PedagogicalPeriod other = (PedagogicalPeriod) object;
        if ((this.pedagogicalPeriodId == null && other.pedagogicalPeriodId != null) || (this.pedagogicalPeriodId != null && !this.pedagogicalPeriodId.equals(other.pedagogicalPeriodId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.system.demo.model.PedagogicalPeriod[ pedagogicalPeriodId=" + pedagogicalPeriodId + " ]";
    }
    
}
