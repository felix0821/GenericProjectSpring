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
    @NamedQuery(name = "Modulus.findByModuleId", query = "SELECT m FROM Modulus m WHERE m.moduleId = :moduleId"),
    @NamedQuery(name = "Modulus.findByModuleIndex", query = "SELECT m FROM Modulus m WHERE m.moduleIndex = :moduleIndex"),
    @NamedQuery(name = "Modulus.findByModuleName", query = "SELECT m FROM Modulus m WHERE m.moduleName = :moduleName"),
    @NamedQuery(name = "Modulus.findByModuleAcronym", query = "SELECT m FROM Modulus m WHERE m.moduleAcronym = :moduleAcronym"),
    @NamedQuery(name = "Modulus.findByModuleDescription", query = "SELECT m FROM Modulus m WHERE m.moduleDescription = :moduleDescription"),
    @NamedQuery(name = "Modulus.findByModuleState", query = "SELECT m FROM Modulus m WHERE m.moduleState = :moduleState")})
public class Modulus implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "module_id", nullable = false)
    private Long moduleId;
    @Basic(optional = false)
    @Column(name = "module_index", nullable = false)
    private int moduleIndex;
    @Basic(optional = false)
    @Column(name = "module_name", nullable = false, length = 64)
    private String moduleName;
    @Basic(optional = false)
    @Column(name = "module_acronym", nullable = false, length = 4)
    private String moduleAcronym;
    @Column(name = "module_description", length = 512)
    private String moduleDescription;
    @Basic(optional = false)
    @Column(name = "module_state", nullable = false)
    private Character moduleState;
    @JoinColumn(name = "program_id", referencedColumnName = "program_id", nullable = false)
    @ManyToOne(optional = false)
    private Program programId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "moduleId")
    private Collection<Course> courseCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "modulus")
    private Collection<Schedule> scheduleCollection;

    public Modulus() {
    }

    public Modulus(Long moduleId) {
        this.moduleId = moduleId;
    }

    public Modulus(Long moduleId, int moduleIndex, String moduleName, String moduleAcronym, Character moduleState) {
        this.moduleId = moduleId;
        this.moduleIndex = moduleIndex;
        this.moduleName = moduleName;
        this.moduleAcronym = moduleAcronym;
        this.moduleState = moduleState;
    }

    public Long getModuleId() {
        return moduleId;
    }

    public void setModuleId(Long moduleId) {
        this.moduleId = moduleId;
    }

    public int getModuleIndex() {
        return moduleIndex;
    }

    public void setModuleIndex(int moduleIndex) {
        this.moduleIndex = moduleIndex;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public String getModuleAcronym() {
        return moduleAcronym;
    }

    public void setModuleAcronym(String moduleAcronym) {
        this.moduleAcronym = moduleAcronym;
    }

    public String getModuleDescription() {
        return moduleDescription;
    }

    public void setModuleDescription(String moduleDescription) {
        this.moduleDescription = moduleDescription;
    }

    public Character getModuleState() {
        return moduleState;
    }

    public void setModuleState(Character moduleState) {
        this.moduleState = moduleState;
    }

    public Program getProgramId() {
        return programId;
    }

    public void setProgramId(Program programId) {
        this.programId = programId;
    }

    public Collection<Course> getCourseCollection() {
        return courseCollection;
    }

    public void setCourseCollection(Collection<Course> courseCollection) {
        this.courseCollection = courseCollection;
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
        hash += (moduleId != null ? moduleId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Modulus)) {
            return false;
        }
        Modulus other = (Modulus) object;
        if ((this.moduleId == null && other.moduleId != null) || (this.moduleId != null && !this.moduleId.equals(other.moduleId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.system.demo.model.Modulus[ moduleId=" + moduleId + " ]";
    }
    
}
