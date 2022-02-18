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
@Table(name = "data_detail_program")
@NamedQueries({
    @NamedQuery(name = "DataDetailProgram.findAll", query = "SELECT d FROM DataDetailProgram d"),
    @NamedQuery(name = "DataDetailProgram.findByDataDetailId", query = "SELECT d FROM DataDetailProgram d WHERE d.dataDetailProgramPK.dataDetailId = :dataDetailId"),
    @NamedQuery(name = "DataDetailProgram.findByProgramId", query = "SELECT d FROM DataDetailProgram d WHERE d.dataDetailProgramPK.programId = :programId"),
    @NamedQuery(name = "DataDetailProgram.findByDataDetailProgramState", query = "SELECT d FROM DataDetailProgram d WHERE d.dataDetailProgramState = :dataDetailProgramState")})
public class DataDetailProgram implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DataDetailProgramPK dataDetailProgramPK;
    @Basic(optional = false)
    @Column(name = "data_detail_program_state", nullable = false)
    private Character dataDetailProgramState;
    @JoinColumn(name = "data_detail_id", referencedColumnName = "data_detail_id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private DataDetail dataDetail;
    @JoinColumn(name = "program_id", referencedColumnName = "program_id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Program program;

    public DataDetailProgram() {
    }

    public DataDetailProgram(DataDetailProgramPK dataDetailProgramPK) {
        this.dataDetailProgramPK = dataDetailProgramPK;
    }

    public DataDetailProgram(DataDetailProgramPK dataDetailProgramPK, Character dataDetailProgramState) {
        this.dataDetailProgramPK = dataDetailProgramPK;
        this.dataDetailProgramState = dataDetailProgramState;
    }

    public DataDetailProgram(long dataDetailId, long programId) {
        this.dataDetailProgramPK = new DataDetailProgramPK(dataDetailId, programId);
    }

    public DataDetailProgramPK getDataDetailProgramPK() {
        return dataDetailProgramPK;
    }

    public void setDataDetailProgramPK(DataDetailProgramPK dataDetailProgramPK) {
        this.dataDetailProgramPK = dataDetailProgramPK;
    }

    public Character getDataDetailProgramState() {
        return dataDetailProgramState;
    }

    public void setDataDetailProgramState(Character dataDetailProgramState) {
        this.dataDetailProgramState = dataDetailProgramState;
    }

    public DataDetail getDataDetail() {
        return dataDetail;
    }

    public void setDataDetail(DataDetail dataDetail) {
        this.dataDetail = dataDetail;
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
        hash += (dataDetailProgramPK != null ? dataDetailProgramPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DataDetailProgram)) {
            return false;
        }
        DataDetailProgram other = (DataDetailProgram) object;
        if ((this.dataDetailProgramPK == null && other.dataDetailProgramPK != null) || (this.dataDetailProgramPK != null && !this.dataDetailProgramPK.equals(other.dataDetailProgramPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.system.demo.persistence.entity.DataDetailProgram[ dataDetailProgramPK=" + dataDetailProgramPK + " ]";
    }
    
}
