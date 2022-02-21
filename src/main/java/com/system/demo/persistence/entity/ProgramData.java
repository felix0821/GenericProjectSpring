/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.system.demo.persistence.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
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
@Table(name = "program_data")
@NamedQueries({
    @NamedQuery(name = "ProgramData.findAll", query = "SELECT p FROM ProgramData p"),
    @NamedQuery(name = "ProgramData.findByProgramId", query = "SELECT p FROM ProgramData p WHERE p.programDataPK.programId = :programId"),
    @NamedQuery(name = "ProgramData.findByDataId", query = "SELECT p FROM ProgramData p WHERE p.programDataPK.dataId = :dataId"),
    @NamedQuery(name = "ProgramData.findByProgramDataState", query = "SELECT p FROM ProgramData p WHERE p.programDataState = :programDataState")})
public class ProgramData implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProgramDataPK programDataPK;
    @Basic(optional = false)
    @Column(name = "program_data_state", nullable = false)
    private Character programDataState;
    @JoinColumn(name = "data_id", referencedColumnName = "data_id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Data data;
    @JoinColumn(name = "program_id", referencedColumnName = "program_id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Program program;

    public ProgramData() {
    }

    public ProgramData(ProgramDataPK programDataPK) {
        this.programDataPK = programDataPK;
    }

    public ProgramData(ProgramDataPK programDataPK, Character programDataState) {
        this.programDataPK = programDataPK;
        this.programDataState = programDataState;
    }

    public ProgramData(long programId, long dataId) {
        this.programDataPK = new ProgramDataPK(programId, dataId);
    }

    public ProgramDataPK getProgramDataPK() {
        return programDataPK;
    }

    public void setProgramDataPK(ProgramDataPK programDataPK) {
        this.programDataPK = programDataPK;
    }

    public Character getProgramDataState() {
        return programDataState;
    }

    public void setProgramDataState(Character programDataState) {
        this.programDataState = programDataState;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public Program getProgram() {
        return program;
    }

    public void setProgram(Program program) {
        this.program = program;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (programDataPK != null ? programDataPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProgramData)) {
            return false;
        }
        ProgramData other = (ProgramData) object;
        if ((this.programDataPK == null && other.programDataPK != null) || (this.programDataPK != null && !this.programDataPK.equals(other.programDataPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.system.demo.persistence.entity.ProgramData[ programDataPK=" + programDataPK + " ]";
    }
    
}
