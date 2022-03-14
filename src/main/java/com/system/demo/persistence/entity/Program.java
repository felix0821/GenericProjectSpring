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
@Table(name = "program", catalog = "ucps_system", schema = "public")
@NamedQueries({
    @NamedQuery(name = "Program.findAll", query = "SELECT p FROM Program p"),
    @NamedQuery(name = "Program.findByProgramId", query = "SELECT p FROM Program p WHERE p.programId = :programId"),
    @NamedQuery(name = "Program.findByProgramIndex", query = "SELECT p FROM Program p WHERE p.programIndex = :programIndex"),
    @NamedQuery(name = "Program.findByProgramIdentifier", query = "SELECT p FROM Program p WHERE p.programIdentifier = :programIdentifier"),
    @NamedQuery(name = "Program.findByProgramName", query = "SELECT p FROM Program p WHERE p.programName = :programName"),
    @NamedQuery(name = "Program.findByProgramAcronym", query = "SELECT p FROM Program p WHERE p.programAcronym = :programAcronym"),
    @NamedQuery(name = "Program.findByProgramDescription", query = "SELECT p FROM Program p WHERE p.programDescription = :programDescription"),
    @NamedQuery(name = "Program.findByProgramRequirement", query = "SELECT p FROM Program p WHERE p.programRequirement = :programRequirement"),
    @NamedQuery(name = "Program.findByProgramCurriculum", query = "SELECT p FROM Program p WHERE p.programCurriculum = :programCurriculum"),
    @NamedQuery(name = "Program.findByProgramImage", query = "SELECT p FROM Program p WHERE p.programImage = :programImage"),
    @NamedQuery(name = "Program.findByProgramArea", query = "SELECT p FROM Program p WHERE p.programArea = :programArea"),
    @NamedQuery(name = "Program.findByProgramState", query = "SELECT p FROM Program p WHERE p.programState = :programState")})
public class Program implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "program_id")
    private Long programId;
    @Column(name = "program_index")
    private Integer programIndex;
    @Basic(optional = false)
    @Column(name = "program_identifier")
    private String programIdentifier;
    @Basic(optional = false)
    @Column(name = "program_name")
    private String programName;
    @Basic(optional = false)
    @Column(name = "program_acronym")
    private String programAcronym;
    @Column(name = "program_description")
    private String programDescription;
    @Column(name = "program_requirement")
    private String programRequirement;
    @Column(name = "program_curriculum")
    private String programCurriculum;
    @Column(name = "program_image")
    private String programImage;
    @Basic(optional = false)
    @Column(name = "program_area")
    private Character programArea;
    @Basic(optional = false)
    @Column(name = "program_state")
    private Character programState;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "programId")
    private Collection<CertificateStudies> certificateStudiesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "programId")
    private Collection<OccupationalField> occupationalFieldCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "program")
    private Collection<ProgramPeriod> programPeriodCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "program")
    private Collection<ProgramData> programDataCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "program")
    private Collection<DataDetailProgram> dataDetailProgramCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "programId")
    private Collection<Modulus> modulusCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "program")
    private Collection<ProgramGroup> programGroupCollection;

    public Program() {
    }

    public Program(Long programId) {
        this.programId = programId;
    }

    public Program(Long programId, String programIdentifier, String programName, String programAcronym, Character programArea, Character programState) {
        this.programId = programId;
        this.programIdentifier = programIdentifier;
        this.programName = programName;
        this.programAcronym = programAcronym;
        this.programArea = programArea;
        this.programState = programState;
    }

    public Long getProgramId() {
        return programId;
    }

    public void setProgramId(Long programId) {
        this.programId = programId;
    }

    public Integer getProgramIndex() {
        return programIndex;
    }

    public void setProgramIndex(Integer programIndex) {
        this.programIndex = programIndex;
    }

    public String getProgramIdentifier() {
        return programIdentifier;
    }

    public void setProgramIdentifier(String programIdentifier) {
        this.programIdentifier = programIdentifier;
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

    public Character getProgramArea() {
        return programArea;
    }

    public void setProgramArea(Character programArea) {
        this.programArea = programArea;
    }

    public Character getProgramState() {
        return programState;
    }

    public void setProgramState(Character programState) {
        this.programState = programState;
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

    public Collection<ProgramData> getProgramDataCollection() {
        return programDataCollection;
    }

    public void setProgramDataCollection(Collection<ProgramData> programDataCollection) {
        this.programDataCollection = programDataCollection;
    }

    public Collection<DataDetailProgram> getDataDetailProgramCollection() {
        return dataDetailProgramCollection;
    }

    public void setDataDetailProgramCollection(Collection<DataDetailProgram> dataDetailProgramCollection) {
        this.dataDetailProgramCollection = dataDetailProgramCollection;
    }

    public Collection<Modulus> getModulusCollection() {
        return modulusCollection;
    }

    public void setModulusCollection(Collection<Modulus> modulusCollection) {
        this.modulusCollection = modulusCollection;
    }

    public Collection<ProgramGroup> getProgramGroupCollection() {
        return programGroupCollection;
    }

    public void setProgramGroupCollection(Collection<ProgramGroup> programGroupCollection) {
        this.programGroupCollection = programGroupCollection;
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
        return "com.system.demo.persistence.entity.Program[ programId=" + programId + " ]";
    }
    
}
