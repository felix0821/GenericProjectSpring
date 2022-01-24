/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.system.demo.model;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Felix
 */
@Entity
@Table(name = "person_program_period")
@NamedQueries({
    @NamedQuery(name = "PersonProgramPeriod.findAll", query = "SELECT p FROM PersonProgramPeriod p"),
    @NamedQuery(name = "PersonProgramPeriod.findByPersonId", query = "SELECT p FROM PersonProgramPeriod p WHERE p.personProgramPeriodPK.personId = :personId"),
    @NamedQuery(name = "PersonProgramPeriod.findByProgramPeriodId", query = "SELECT p FROM PersonProgramPeriod p WHERE p.personProgramPeriodPK.programPeriodId = :programPeriodId")})
public class PersonProgramPeriod implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PersonProgramPeriodPK personProgramPeriodPK;
    @JoinColumn(name = "person_id", referencedColumnName = "person_id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Person person;
    @JoinColumn(name = "program_period_id", referencedColumnName = "program_period_id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private ProgramPeriod programPeriod;
    @JoinColumn(name = "requisition_detail_id", referencedColumnName = "requisition_detail_id")
    @ManyToOne
    private RequisitionDetail requisitionDetailId;

    public PersonProgramPeriod() {
    }

    public PersonProgramPeriod(PersonProgramPeriodPK personProgramPeriodPK) {
        this.personProgramPeriodPK = personProgramPeriodPK;
    }

    public PersonProgramPeriod(long personId, long programPeriodId) {
        this.personProgramPeriodPK = new PersonProgramPeriodPK(personId, programPeriodId);
    }

    public PersonProgramPeriodPK getPersonProgramPeriodPK() {
        return personProgramPeriodPK;
    }

    public void setPersonProgramPeriodPK(PersonProgramPeriodPK personProgramPeriodPK) {
        this.personProgramPeriodPK = personProgramPeriodPK;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public ProgramPeriod getProgramPeriod() {
        return programPeriod;
    }

    public void setProgramPeriod(ProgramPeriod programPeriod) {
        this.programPeriod = programPeriod;
    }

    public RequisitionDetail getRequisitionDetailId() {
        return requisitionDetailId;
    }

    public void setRequisitionDetailId(RequisitionDetail requisitionDetailId) {
        this.requisitionDetailId = requisitionDetailId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (personProgramPeriodPK != null ? personProgramPeriodPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PersonProgramPeriod)) {
            return false;
        }
        PersonProgramPeriod other = (PersonProgramPeriod) object;
        if ((this.personProgramPeriodPK == null && other.personProgramPeriodPK != null) || (this.personProgramPeriodPK != null && !this.personProgramPeriodPK.equals(other.personProgramPeriodPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.system.demo.model.PersonProgramPeriod[ personProgramPeriodPK=" + personProgramPeriodPK + " ]";
    }
    
}
