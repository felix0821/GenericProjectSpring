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
import javax.persistence.UniqueConstraint;

/**
 *
 * @author Felix
 */
@Entity
@Table(name = "modulus", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"modulus_identifier", "program_id"}),
    @UniqueConstraint(columnNames = {"modulus_order", "program_id"})})
@NamedQueries({
    @NamedQuery(name = "Modulus.findAll", query = "SELECT m FROM Modulus m"),
    @NamedQuery(name = "Modulus.findByModulusId", query = "SELECT m FROM Modulus m WHERE m.modulusId = :modulusId"),
    @NamedQuery(name = "Modulus.findByModulusIndex", query = "SELECT m FROM Modulus m WHERE m.modulusIndex = :modulusIndex"),
    @NamedQuery(name = "Modulus.findByModulusIdentifier", query = "SELECT m FROM Modulus m WHERE m.modulusIdentifier = :modulusIdentifier"),
    @NamedQuery(name = "Modulus.findByModulusName", query = "SELECT m FROM Modulus m WHERE m.modulusName = :modulusName"),
    @NamedQuery(name = "Modulus.findByModulusOrder", query = "SELECT m FROM Modulus m WHERE m.modulusOrder = :modulusOrder"),
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
    @Column(name = "modulus_identifier", nullable = false, length = 64)
    private String modulusIdentifier;
    @Basic(optional = false)
    @Column(name = "modulus_name", nullable = false, length = 64)
    private String modulusName;
    @Basic(optional = false)
    @Column(name = "modulus_order", nullable = false)
    private int modulusOrder;
    @Column(name = "modulus_description", length = 512)
    private String modulusDescription;
    @Basic(optional = false)
    @Column(name = "modulus_state", nullable = false)
    private Character modulusState;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "modulusId")
    private Collection<Course> courseCollection;
    @JoinColumn(name = "program_id", referencedColumnName = "program_id", nullable = false)
    @ManyToOne(optional = false)
    private Program programId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "modulus")
    private Collection<ModulusDetail> modulusDetailCollection;

    public Modulus() {
    }

    public Modulus(Long modulusId) {
        this.modulusId = modulusId;
    }

    public Modulus(Long modulusId, int modulusIndex, String modulusIdentifier, String modulusName, int modulusOrder, Character modulusState) {
        this.modulusId = modulusId;
        this.modulusIndex = modulusIndex;
        this.modulusIdentifier = modulusIdentifier;
        this.modulusName = modulusName;
        this.modulusOrder = modulusOrder;
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

    public String getModulusIdentifier() {
        return modulusIdentifier;
    }

    public void setModulusIdentifier(String modulusIdentifier) {
        this.modulusIdentifier = modulusIdentifier;
    }

    public String getModulusName() {
        return modulusName;
    }

    public void setModulusName(String modulusName) {
        this.modulusName = modulusName;
    }

    public int getModulusOrder() {
        return modulusOrder;
    }

    public void setModulusOrder(int modulusOrder) {
        this.modulusOrder = modulusOrder;
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

    public Program getProgramId() {
        return programId;
    }

    public void setProgramId(Program programId) {
        this.programId = programId;
    }

    public Collection<ModulusDetail> getModulusDetailCollection() {
        return modulusDetailCollection;
    }

    public void setModulusDetailCollection(Collection<ModulusDetail> modulusDetailCollection) {
        this.modulusDetailCollection = modulusDetailCollection;
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
        return "com.system.demo.persistence.entity.Modulus[ modulusId=" + modulusId + " ]";
    }
    
}
