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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Felix
 */
@Entity
@Table(name = "period_modality")
@NamedQueries({
    @NamedQuery(name = "PeriodModality.findAll", query = "SELECT p FROM PeriodModality p"),
    @NamedQuery(name = "PeriodModality.findByModalityId", query = "SELECT p FROM PeriodModality p WHERE p.modalityId = :modalityId"),
    @NamedQuery(name = "PeriodModality.findByModalityName", query = "SELECT p FROM PeriodModality p WHERE p.modalityName = :modalityName"),
    @NamedQuery(name = "PeriodModality.findByModalityState", query = "SELECT p FROM PeriodModality p WHERE p.modalityState = :modalityState")})
public class PeriodModality implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "modality_id", nullable = false, length = 1)
    private String modalityId;
    @Basic(optional = false)
    @Column(name = "modality_name", nullable = false, length = 32)
    private String modalityName;
    @Basic(optional = false)
    @Column(name = "modality_state", nullable = false)
    private Character modalityState;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "modalityId")
    private Collection<Period> periodCollection;

    public PeriodModality() {
    }

    public PeriodModality(String modalityId) {
        this.modalityId = modalityId;
    }

    public PeriodModality(String modalityId, String modalityName, Character modalityState) {
        this.modalityId = modalityId;
        this.modalityName = modalityName;
        this.modalityState = modalityState;
    }

    public String getModalityId() {
        return modalityId;
    }

    public void setModalityId(String modalityId) {
        this.modalityId = modalityId;
    }

    public String getModalityName() {
        return modalityName;
    }

    public void setModalityName(String modalityName) {
        this.modalityName = modalityName;
    }

    public Character getModalityState() {
        return modalityState;
    }

    public void setModalityState(Character modalityState) {
        this.modalityState = modalityState;
    }

    public Collection<Period> getPeriodCollection() {
        return periodCollection;
    }

    public void setPeriodCollection(Collection<Period> periodCollection) {
        this.periodCollection = periodCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (modalityId != null ? modalityId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PeriodModality)) {
            return false;
        }
        PeriodModality other = (PeriodModality) object;
        if ((this.modalityId == null && other.modalityId != null) || (this.modalityId != null && !this.modalityId.equals(other.modalityId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.system.demo.persistence.entity.PeriodModality[ modalityId=" + modalityId + " ]";
    }
    
}
