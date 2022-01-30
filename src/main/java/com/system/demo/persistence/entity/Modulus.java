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
@Table(name = "modulus")
@NamedQueries({
    @NamedQuery(name = "Modulus.findAll", query = "SELECT m FROM Modulus m"),
    @NamedQuery(name = "Modulus.findByModulusId", query = "SELECT m FROM Modulus m WHERE m.modulusId = :modulusId"),
    @NamedQuery(name = "Modulus.findByModulusIndex", query = "SELECT m FROM Modulus m WHERE m.modulusIndex = :modulusIndex"),
    @NamedQuery(name = "Modulus.findByModulusName", query = "SELECT m FROM Modulus m WHERE m.modulusName = :modulusName"),
    @NamedQuery(name = "Modulus.findByModulusAcronym", query = "SELECT m FROM Modulus m WHERE m.modulusAcronym = :modulusAcronym"),
    @NamedQuery(name = "Modulus.findByModulusDescription", query = "SELECT m FROM Modulus m WHERE m.modulusDescription = :modulusDescription"),
    @NamedQuery(name = "Modulus.findByModulusState", query = "SELECT m FROM Modulus m WHERE m.modulusState = :modulusState")})
public class Modulus implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "modulus_id", nullable = false)
    private Long modulusId;
    @Basic(optional = false)
    @Column(name = "modulus_index", nullable = false)
    private int modulusIndex;
    @Basic(optional = false)
    @Column(name = "modulus_name", nullable = false, length = 64)
    private String modulusName;
    @Basic(optional = false)
    @Column(name = "modulus_acronym", nullable = false, length = 4)
    private String modulusAcronym;
    @Column(name = "modulus_description", length = 512)
    private String modulusDescription;
    @Basic(optional = false)
    @Column(name = "modulus_state", nullable = false)
    private Character modulusState;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "modulusId")
    private Collection<Course> courseCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "modulus")
    private Collection<ModulusSchedule> modulusScheduleCollection;
    @JoinColumn(name = "program_id", referencedColumnName = "program_id", nullable = false)
    @ManyToOne(optional = false)
    private Program programId;

    public Modulus() {
    }

    public Modulus(Long modulusId) {
        this.modulusId = modulusId;
    }

    public Modulus(Long modulusId, int modulusIndex, String modulusName, String modulusAcronym, Character modulusState) {
        this.modulusId = modulusId;
        this.modulusIndex = modulusIndex;
        this.modulusName = modulusName;
        this.modulusAcronym = modulusAcronym;
        this.modulusState = modulusState;
    }

    public Long getModulusId() {
        return modulusId;
    }

    public void setModulusId(Long modulusId) {
        this.modulusId = modulusId;
    }

    public int getModulusIndex() {
        return modulusIndex;
    }

    public void setModulusIndex(int modulusIndex) {
        this.modulusIndex = modulusIndex;
    }

    public String getModulusName() {
        return modulusName;
    }

    public void setModulusName(String modulusName) {
        this.modulusName = modulusName;
    }

    public String getModulusAcronym() {
        return modulusAcronym;
    }

    public void setModulusAcronym(String modulusAcronym) {
        this.modulusAcronym = modulusAcronym;
    }

    public String getModulusDescription() {
        return modulusDescription;
    }

    public void setModulusDescription(String modulusDescription) {
        this.modulusDescription = modulusDescription;
    }

    public Character getModulusState() {
        return modulusState;
    }

    public void setModulusState(Character modulusState) {
        this.modulusState = modulusState;
    }

    public Collection<Course> getCourseCollection() {
        return courseCollection;
    }

    public void setCourseCollection(Collection<Course> courseCollection) {
        this.courseCollection = courseCollection;
    }

    public Collection<ModulusSchedule> getModulusScheduleCollection() {
        return modulusScheduleCollection;
    }

    public void setModulusScheduleCollection(Collection<ModulusSchedule> modulusScheduleCollection) {
        this.modulusScheduleCollection = modulusScheduleCollection;
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
        hash += (modulusId != null ? modulusId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Modulus)) {
            return false;
        }
        Modulus other = (Modulus) object;
        if ((this.modulusId == null && other.modulusId != null) || (this.modulusId != null && !this.modulusId.equals(other.modulusId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.system.demo.model.Modulus[ modulusId=" + modulusId + " ]";
    }
    
}
