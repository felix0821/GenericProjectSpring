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
@Table(name = "program_group")
@NamedQueries({
    @NamedQuery(name = "ProgramGroup.findAll", query = "SELECT p FROM ProgramGroup p"),
    @NamedQuery(name = "ProgramGroup.findByProgramId", query = "SELECT p FROM ProgramGroup p WHERE p.programGroupPK.programId = :programId"),
    @NamedQuery(name = "ProgramGroup.findByGroupId", query = "SELECT p FROM ProgramGroup p WHERE p.programGroupPK.groupId = :groupId"),
    @NamedQuery(name = "ProgramGroup.findByProgramGroupState", query = "SELECT p FROM ProgramGroup p WHERE p.programGroupState = :programGroupState")})
public class ProgramGroup implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProgramGroupPK programGroupPK;
    @Basic(optional = false)
    @Column(name = "program_group_state", nullable = false)
    private Character programGroupState;
    @JoinColumn(name = "group_id", referencedColumnName = "group_id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private GroupTeaching groupTeaching;
    @JoinColumn(name = "program_id", referencedColumnName = "program_id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Program program;

    public ProgramGroup() {
    }

    public ProgramGroup(ProgramGroupPK programGroupPK) {
        this.programGroupPK = programGroupPK;
    }

    public ProgramGroup(ProgramGroupPK programGroupPK, Character programGroupState) {
        this.programGroupPK = programGroupPK;
        this.programGroupState = programGroupState;
    }

    public ProgramGroup(long programId, long groupId) {
        this.programGroupPK = new ProgramGroupPK(programId, groupId);
    }

    public ProgramGroupPK getProgramGroupPK() {
        return programGroupPK;
    }

    public void setProgramGroupPK(ProgramGroupPK programGroupPK) {
        this.programGroupPK = programGroupPK;
    }

    public Character getProgramGroupState() {
        return programGroupState;
    }

    public void setProgramGroupState(Character programGroupState) {
        this.programGroupState = programGroupState;
    }

    public GroupTeaching getGroupTeaching() {
        return groupTeaching;
    }

    public void setGroupTeaching(GroupTeaching groupTeaching) {
        this.groupTeaching = groupTeaching;
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
        hash += (programGroupPK != null ? programGroupPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProgramGroup)) {
            return false;
        }
        ProgramGroup other = (ProgramGroup) object;
        if ((this.programGroupPK == null && other.programGroupPK != null) || (this.programGroupPK != null && !this.programGroupPK.equals(other.programGroupPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.system.demo.persistence.entity.ProgramGroup[ programGroupPK=" + programGroupPK + " ]";
    }
    
}
