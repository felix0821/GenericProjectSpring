/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.system.demo.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "occupational_field")
@NamedQueries({
    @NamedQuery(name = "OccupationalField.findAll", query = "SELECT o FROM OccupationalField o"),
    @NamedQuery(name = "OccupationalField.findByOccupationalFieldId", query = "SELECT o FROM OccupationalField o WHERE o.occupationalFieldId = :occupationalFieldId"),
    @NamedQuery(name = "OccupationalField.findByOccupationalFieldIndex", query = "SELECT o FROM OccupationalField o WHERE o.occupationalFieldIndex = :occupationalFieldIndex"),
    @NamedQuery(name = "OccupationalField.findByOccupationalFieldName", query = "SELECT o FROM OccupationalField o WHERE o.occupationalFieldName = :occupationalFieldName"),
    @NamedQuery(name = "OccupationalField.findByOccupationalFieldState", query = "SELECT o FROM OccupationalField o WHERE o.occupationalFieldState = :occupationalFieldState"),
    @NamedQuery(name = "OccupationalField.findByProgramId", query = "SELECT o FROM OccupationalField o WHERE o.programId.programId = :programId")})
public class OccupationalField implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "occupational_field_id", nullable = false)
    private Long occupationalFieldId;
    @Basic(optional = false)
    @Column(name = "occupational_field_index", nullable = false)
    private int occupationalFieldIndex;
    @Basic(optional = false)
    @Column(name = "occupational_field_name", nullable = false, length = 64)
    private String occupationalFieldName;
    @Basic(optional = false)
    @Column(name = "occupational_field_state", nullable = false)
    private Character occupationalFieldState;
    @JoinColumn(name = "program_id", referencedColumnName = "program_id", nullable = false)
    @ManyToOne(optional = false)
    private Program programId;

    public OccupationalField() {
    }

    public OccupationalField(Long occupationalFieldId) {
        this.occupationalFieldId = occupationalFieldId;
    }

    public OccupationalField(Long occupationalFieldId, int occupationalFieldIndex, String occupationalFieldName, Character occupationalFieldState) {
        this.occupationalFieldId = occupationalFieldId;
        this.occupationalFieldIndex = occupationalFieldIndex;
        this.occupationalFieldName = occupationalFieldName;
        this.occupationalFieldState = occupationalFieldState;
    }

    public Long getOccupationalFieldId() {
        return occupationalFieldId;
    }

    public void setOccupationalFieldId(Long occupationalFieldId) {
        this.occupationalFieldId = occupationalFieldId;
    }

    public int getOccupationalFieldIndex() {
        return occupationalFieldIndex;
    }

    public void setOccupationalFieldIndex(int occupationalFieldIndex) {
        this.occupationalFieldIndex = occupationalFieldIndex;
    }

    public String getOccupationalFieldName() {
        return occupationalFieldName;
    }

    public void setOccupationalFieldName(String occupationalFieldName) {
        this.occupationalFieldName = occupationalFieldName;
    }

    public Character getOccupationalFieldState() {
        return occupationalFieldState;
    }

    public void setOccupationalFieldState(Character occupationalFieldState) {
        this.occupationalFieldState = occupationalFieldState;
    }

    public Program getProgramId() {
        return programId;
    }

    public void setProgramId(Program programId) {
        this.programId = programId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (occupationalFieldId != null ? occupationalFieldId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OccupationalField)) {
            return false;
        }
        OccupationalField other = (OccupationalField) object;
        if ((this.occupationalFieldId == null && other.occupationalFieldId != null) || (this.occupationalFieldId != null && !this.occupationalFieldId.equals(other.occupationalFieldId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.system.demo.model.OccupationalField[ occupationalFieldId=" + occupationalFieldId + " ]";
    }
    
}
