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
@Table(name = "assistance_status", catalog = "ucps_system", schema = "public")
@NamedQueries({
    @NamedQuery(name = "AssistanceStatus.findAll", query = "SELECT a FROM AssistanceStatus a"),
    @NamedQuery(name = "AssistanceStatus.findByAssistanceStatusId", query = "SELECT a FROM AssistanceStatus a WHERE a.assistanceStatusId = :assistanceStatusId"),
    @NamedQuery(name = "AssistanceStatus.findByAssistanceStatusName", query = "SELECT a FROM AssistanceStatus a WHERE a.assistanceStatusName = :assistanceStatusName"),
    @NamedQuery(name = "AssistanceStatus.findByAssistanceStatusColor", query = "SELECT a FROM AssistanceStatus a WHERE a.assistanceStatusColor = :assistanceStatusColor"),
    @NamedQuery(name = "AssistanceStatus.findByAssistanceStatusScore", query = "SELECT a FROM AssistanceStatus a WHERE a.assistanceStatusScore = :assistanceStatusScore")})
public class AssistanceStatus implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "assistance_status_id")
    private Long assistanceStatusId;
    @Basic(optional = false)
    @Column(name = "assistance_status_name")
    private String assistanceStatusName;
    @Basic(optional = false)
    @Column(name = "assistance_status_color")
    private Character assistanceStatusColor;
    @Basic(optional = false)
    @Column(name = "assistance_status_score")
    private int assistanceStatusScore;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "assistanceStatusId")
    private Collection<Assistance> assistanceCollection;

    public AssistanceStatus() {
    }

    public AssistanceStatus(Long assistanceStatusId) {
        this.assistanceStatusId = assistanceStatusId;
    }

    public AssistanceStatus(Long assistanceStatusId, String assistanceStatusName, Character assistanceStatusColor, int assistanceStatusScore) {
        this.assistanceStatusId = assistanceStatusId;
        this.assistanceStatusName = assistanceStatusName;
        this.assistanceStatusColor = assistanceStatusColor;
        this.assistanceStatusScore = assistanceStatusScore;
    }

    public Long getAssistanceStatusId() {
        return assistanceStatusId;
    }

    public void setAssistanceStatusId(Long assistanceStatusId) {
        this.assistanceStatusId = assistanceStatusId;
    }

    public String getAssistanceStatusName() {
        return assistanceStatusName;
    }

    public void setAssistanceStatusName(String assistanceStatusName) {
        this.assistanceStatusName = assistanceStatusName;
    }

    public Character getAssistanceStatusColor() {
        return assistanceStatusColor;
    }

    public void setAssistanceStatusColor(Character assistanceStatusColor) {
        this.assistanceStatusColor = assistanceStatusColor;
    }

    public int getAssistanceStatusScore() {
        return assistanceStatusScore;
    }

    public void setAssistanceStatusScore(int assistanceStatusScore) {
        this.assistanceStatusScore = assistanceStatusScore;
    }

    public Collection<Assistance> getAssistanceCollection() {
        return assistanceCollection;
    }

    public void setAssistanceCollection(Collection<Assistance> assistanceCollection) {
        this.assistanceCollection = assistanceCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (assistanceStatusId != null ? assistanceStatusId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AssistanceStatus)) {
            return false;
        }
        AssistanceStatus other = (AssistanceStatus) object;
        if ((this.assistanceStatusId == null && other.assistanceStatusId != null) || (this.assistanceStatusId != null && !this.assistanceStatusId.equals(other.assistanceStatusId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.system.demo.persistence.entity.AssistanceStatus[ assistanceStatusId=" + assistanceStatusId + " ]";
    }
    
}
