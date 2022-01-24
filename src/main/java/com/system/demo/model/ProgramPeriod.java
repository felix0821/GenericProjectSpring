/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.system.demo.model;

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
@Table(name = "program_period")
@NamedQueries({
    @NamedQuery(name = "ProgramPeriod.findAll", query = "SELECT p FROM ProgramPeriod p"),
    @NamedQuery(name = "ProgramPeriod.findByProgramPeriodId", query = "SELECT p FROM ProgramPeriod p WHERE p.programPeriodId = :programPeriodId"),
    @NamedQuery(name = "ProgramPeriod.findByProgramPeriodNumber", query = "SELECT p FROM ProgramPeriod p WHERE p.programPeriodNumber = :programPeriodNumber"),
    @NamedQuery(name = "ProgramPeriod.findByProgramPeriodOpening", query = "SELECT p FROM ProgramPeriod p WHERE p.programPeriodOpening = :programPeriodOpening"),
    @NamedQuery(name = "ProgramPeriod.findByProgramPeriodClosing", query = "SELECT p FROM ProgramPeriod p WHERE p.programPeriodClosing = :programPeriodClosing")})
public class ProgramPeriod implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "program_period_id", nullable = false)
    private Long programPeriodId;
    @Basic(optional = false)
    @Column(name = "program_period_number", nullable = false)
    private int programPeriodNumber;
    @Column(name = "program_period_opening")
    @Temporal(TemporalType.DATE)
    private Date programPeriodOpening;
    @Column(name = "program_period_closing")
    @Temporal(TemporalType.DATE)
    private Date programPeriodClosing;
    @JoinColumn(name = "program_id", referencedColumnName = "program_id")
    @ManyToOne
    private Program programId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "programPeriod")
    private Collection<PersonProgramPeriod> personProgramPeriodCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "programPeriod")
    private Collection<Schedule> scheduleCollection;

    public ProgramPeriod() {
    }

    public ProgramPeriod(Long programPeriodId) {
        this.programPeriodId = programPeriodId;
    }

    public ProgramPeriod(Long programPeriodId, int programPeriodNumber) {
        this.programPeriodId = programPeriodId;
        this.programPeriodNumber = programPeriodNumber;
    }

    public Long getProgramPeriodId() {
        return programPeriodId;
    }

    public void setProgramPeriodId(Long programPeriodId) {
        this.programPeriodId = programPeriodId;
    }

    public int getProgramPeriodNumber() {
        return programPeriodNumber;
    }

    public void setProgramPeriodNumber(int programPeriodNumber) {
        this.programPeriodNumber = programPeriodNumber;
    }

    public Date getProgramPeriodOpening() {
        return programPeriodOpening;
    }

    public void setProgramPeriodOpening(Date programPeriodOpening) {
        this.programPeriodOpening = programPeriodOpening;
    }

    public Date getProgramPeriodClosing() {
        return programPeriodClosing;
    }

    public void setProgramPeriodClosing(Date programPeriodClosing) {
        this.programPeriodClosing = programPeriodClosing;
    }

    public Program getProgramId() {
        return programId;
    }

    public void setProgramId(Program programId) {
        this.programId = programId;
    }

    public Collection<PersonProgramPeriod> getPersonProgramPeriodCollection() {
        return personProgramPeriodCollection;
    }

    public void setPersonProgramPeriodCollection(Collection<PersonProgramPeriod> personProgramPeriodCollection) {
        this.personProgramPeriodCollection = personProgramPeriodCollection;
    }

    public Collection<Schedule> getScheduleCollection() {
        return scheduleCollection;
    }

    public void setScheduleCollection(Collection<Schedule> scheduleCollection) {
        this.scheduleCollection = scheduleCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (programPeriodId != null ? programPeriodId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProgramPeriod)) {
            return false;
        }
        ProgramPeriod other = (ProgramPeriod) object;
        if ((this.programPeriodId == null && other.programPeriodId != null) || (this.programPeriodId != null && !this.programPeriodId.equals(other.programPeriodId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.system.demo.model.ProgramPeriod[ programPeriodId=" + programPeriodId + " ]";
    }
    
}
