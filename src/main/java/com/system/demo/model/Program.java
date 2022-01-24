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
@Table(name = "program")
@NamedQueries({
    @NamedQuery(name = "Program.findAll", query = "SELECT p FROM Program p"),
    @NamedQuery(name = "Program.findByProgramId", query = "SELECT p FROM Program p WHERE p.programId = :programId"),
    @NamedQuery(name = "Program.findByProgramIndex", query = "SELECT p FROM Program p WHERE p.programIndex = :programIndex"),
    @NamedQuery(name = "Program.findByProgramName", query = "SELECT p FROM Program p WHERE p.programName = :programName"),
    @NamedQuery(name = "Program.findByProgramAcronym", query = "SELECT p FROM Program p WHERE p.programAcronym = :programAcronym"),
    @NamedQuery(name = "Program.findByProgramDescription", query = "SELECT p FROM Program p WHERE p.programDescription = :programDescription"),
    @NamedQuery(name = "Program.findByProgramRequirement", query = "SELECT p FROM Program p WHERE p.programRequirement = :programRequirement"),
    @NamedQuery(name = "Program.findByProgramCurriculum", query = "SELECT p FROM Program p WHERE p.programCurriculum = :programCurriculum"),
    @NamedQuery(name = "Program.findByProgramImage", query = "SELECT p FROM Program p WHERE p.programImage = :programImage"),
    @NamedQuery(name = "Program.findByProgramState", query = "SELECT p FROM Program p WHERE p.programState = :programState"),
    @NamedQuery(name = "Program.findByProgramArea", query = "SELECT p FROM Program p WHERE p.programArea = :programArea")})
public class Program implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "program_id", nullable = false)
    private Long programId;
    @Basic(optional = false)
    @Column(name = "program_index", nullable = false)
    private int programIndex;
    @Basic(optional = false)
    @Column(name = "program_name", nullable = false, length = 64)
    private String programName;
    @Basic(optional = false)
    @Column(name = "program_acronym", nullable = false, length = 4)
    private String programAcronym;
    @Basic(optional = false)
    @Column(name = "program_description", nullable = false, length = 512)
    private String programDescription;
    @Column(name = "program_requirement", length = 128)
    private String programRequirement;
    @Column(name = "program_curriculum", length = 256)
    private String programCurriculum;
    @Column(name = "program_image", length = 256)
    private String programImage;
    @Basic(optional = false)
    @Column(name = "program_state", nullable = false)
    private Character programState;
    @Basic(optional = false)
    @Column(name = "program_area", nullable = false)
    private Character programArea;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "programId")
    private Collection<CertificateStudies> certificateStudiesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "programId")
    private Collection<OccupationalField> occupationalFieldCollection;
    @OneToMany(mappedBy = "programId")
    private Collection<ProgramPeriod> programPeriodCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "programId")
    private Collection<Modulus> moduleCollection;

    public Program() {
    }

    public Program(Long programId) {
        this.programId = programId;
    }

    public Program(Long programId, int programIndex, String programName, String programAcronym, String programDescription, Character programState, Character programArea) {
        this.programId = programId;
        this.programIndex = programIndex;
        this.programName = programName;
        this.programAcronym = programAcronym;
        this.programDescription = programDescription;
        this.programState = programState;
        this.programArea = programArea;
    }

    public Long getProgramId() {
        return programId;
    }

    public void setProgramId(Long programId) {
        this.programId = programId;
    }

    public int getProgramIndex() {
        return programIndex;
    }

    public void setProgramIndex(int programIndex) {
        this.programIndex = programIndex;
    }

    public String getProgramName() {
        return programName;
    }

    public void setProgramName(String programName) {
        this.programName = programName;
    }

    public String getProgramAcronym() {
        return programAcronym;
    }

    public void setProgramAcronym(String programAcronym) {
        this.programAcronym = programAcronym;
    }

    public String getProgramDescription() {
        return programDescription;
    }

    public void setProgramDescription(String programDescription) {
        this.programDescription = programDescription;
    }

    public String getProgramRequirement() {
        return programRequirement;
    }

    public void setProgramRequirement(String programRequirement) {
        this.programRequirement = programRequirement;
    }

    public String getProgramCurriculum() {
        return programCurriculum;
    }

    public void setProgramCurriculum(String programCurriculum) {
        this.programCurriculum = programCurriculum;
    }

    public String getProgramImage() {
        return programImage;
    }

    public void setProgramImage(String programImage) {
        this.programImage = programImage;
    }

    public Character getProgramState() {
        return programState;
    }

    public void setProgramState(Character programState) {
        this.programState = programState;
    }

    public Character getProgramArea() {
        return programArea;
    }

    public void setProgramArea(Character programArea) {
        this.programArea = programArea;
    }

    public Collection<CertificateStudies> getCertificateStudiesCollection() {
        return certificateStudiesCollection;
    }

    public void setCertificateStudiesCollection(Collection<CertificateStudies> certificateStudiesCollection) {
        this.certificateStudiesCollection = certificateStudiesCollection;
    }

    public Collection<OccupationalField> getOccupationalFieldCollection() {
        return occupationalFieldCollection;
    }

    public void setOccupationalFieldCollection(Collection<OccupationalField> occupationalFieldCollection) {
        this.occupationalFieldCollection = occupationalFieldCollection;
    }

    public Collection<ProgramPeriod> getProgramPeriodCollection() {
        return programPeriodCollection;
    }

    public void setProgramPeriodCollection(Collection<ProgramPeriod> programPeriodCollection) {
        this.programPeriodCollection = programPeriodCollection;
    }

    public Collection<Modulus> getModuleCollection() {
        return moduleCollection;
    }

    public void setModuleCollection(Collection<Modulus> moduleCollection) {
        this.moduleCollection = moduleCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (programId != null ? programId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Program)) {
            return false;
        }
        Program other = (Program) object;
        if ((this.programId == null && other.programId != null) || (this.programId != null && !this.programId.equals(other.programId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.system.demo.model.Program[ programId=" + programId + " ]";
    }
    
}
