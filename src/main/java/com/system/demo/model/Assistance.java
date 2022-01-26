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
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Felix
 */
@Entity
@Table(name = "assistance")
@NamedQueries({
    @NamedQuery(name = "Assistance.findAll", query = "SELECT a FROM Assistance a"),
    @NamedQuery(name = "Assistance.findByHoraryId", query = "SELECT a FROM Assistance a WHERE a.assistancePK.horaryId = :horaryId"),
    @NamedQuery(name = "Assistance.findByPersonId", query = "SELECT a FROM Assistance a WHERE a.assistancePK.personId = :personId"),
    @NamedQuery(name = "Assistance.findByCourseDetailId", query = "SELECT a FROM Assistance a WHERE a.assistancePK.courseDetailId = :courseDetailId")})
public class Assistance implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AssistancePK assistancePK;
    @JoinColumn(name = "assistance_status_id", referencedColumnName = "assistance_status_id", nullable = false)
    @ManyToOne(optional = false)
    private AssistanceStatus assistanceStatusId;
    @JoinColumns({
        @JoinColumn(name = "horary_id", referencedColumnName = "horary_id", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "course_detail_id", referencedColumnName = "course_detail_id", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private HoraryCourseGroup horaryCourseGroup;
    @JoinColumn(name = "person_id", referencedColumnName = "person_id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Person person;
    @JoinColumn(name = "person_registering_id", referencedColumnName = "person_registering_id", nullable = false)
    @ManyToOne(optional = false)
    private PersonRegistering personRegisteringId;

    public Assistance() {
    }

    public Assistance(AssistancePK assistancePK) {
        this.assistancePK = assistancePK;
    }

    public Assistance(long horaryId, long personId, long courseDetailId) {
        this.assistancePK = new AssistancePK(horaryId, personId, courseDetailId);
    }

    public AssistancePK getAssistancePK() {
        return assistancePK;
    }

    public void setAssistancePK(AssistancePK assistancePK) {
        this.assistancePK = assistancePK;
    }

    public AssistanceStatus getAssistanceStatusId() {
        return assistanceStatusId;
    }

    public void setAssistanceStatusId(AssistanceStatus assistanceStatusId) {
        this.assistanceStatusId = assistanceStatusId;
    }

    public HoraryCourseGroup getHoraryCourseGroup() {
        return horaryCourseGroup;
    }

    public void setHoraryCourseGroup(HoraryCourseGroup horaryCourseGroup) {
        this.horaryCourseGroup = horaryCourseGroup;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public PersonRegistering getPersonRegisteringId() {
        return personRegisteringId;
    }

    public void setPersonRegisteringId(PersonRegistering personRegisteringId) {
        this.personRegisteringId = personRegisteringId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (assistancePK != null ? assistancePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Assistance)) {
            return false;
        }
        Assistance other = (Assistance) object;
        if ((this.assistancePK == null && other.assistancePK != null) || (this.assistancePK != null && !this.assistancePK.equals(other.assistancePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.system.demo.model.Assistance[ assistancePK=" + assistancePK + " ]";
    }
    
}
