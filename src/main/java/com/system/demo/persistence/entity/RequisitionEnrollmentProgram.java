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
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Felix
 */
@Entity
@Table(name = "requisition_enrollment_program")
@NamedQueries({
    @NamedQuery(name = "RequisitionEnrollmentProgram.findAll", query = "SELECT r FROM RequisitionEnrollmentProgram r"),
    @NamedQuery(name = "RequisitionEnrollmentProgram.findByRequisitionDetailId", query = "SELECT r FROM RequisitionEnrollmentProgram r WHERE r.requisitionEnrollmentProgramPK.requisitionDetailId = :requisitionDetailId"),
    @NamedQuery(name = "RequisitionEnrollmentProgram.findByPersonId", query = "SELECT r FROM RequisitionEnrollmentProgram r WHERE r.requisitionEnrollmentProgramPK.personId = :personId"),
    @NamedQuery(name = "RequisitionEnrollmentProgram.findByProgramId", query = "SELECT r FROM RequisitionEnrollmentProgram r WHERE r.requisitionEnrollmentProgramPK.programId = :programId"),
    @NamedQuery(name = "RequisitionEnrollmentProgram.findByPeriodId", query = "SELECT r FROM RequisitionEnrollmentProgram r WHERE r.requisitionEnrollmentProgramPK.periodId = :periodId"),
    @NamedQuery(name = "RequisitionEnrollmentProgram.findByRequisitionEnrollmentProgramState", query = "SELECT r FROM RequisitionEnrollmentProgram r WHERE r.requisitionEnrollmentProgramState = :requisitionEnrollmentProgramState")})
public class RequisitionEnrollmentProgram implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected RequisitionEnrollmentProgramPK requisitionEnrollmentProgramPK;
    @Basic(optional = false)
    @Column(name = "requisition_enrollment_program_state", nullable = false)
    private Character requisitionEnrollmentProgramState;
    @JoinColumns({
        @JoinColumn(name = "person_id", referencedColumnName = "person_id", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "program_id", referencedColumnName = "program_id", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "period_id", referencedColumnName = "period_id", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private EnrollmentProgram enrollmentProgram;
    @JoinColumn(name = "requisition_detail_id", referencedColumnName = "requisition_detail_id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private RequisitionDetail requisitionDetail;

    public RequisitionEnrollmentProgram() {
    }

    public RequisitionEnrollmentProgram(RequisitionEnrollmentProgramPK requisitionEnrollmentProgramPK) {
        this.requisitionEnrollmentProgramPK = requisitionEnrollmentProgramPK;
    }

    public RequisitionEnrollmentProgram(RequisitionEnrollmentProgramPK requisitionEnrollmentProgramPK, Character requisitionEnrollmentProgramState) {
        this.requisitionEnrollmentProgramPK = requisitionEnrollmentProgramPK;
        this.requisitionEnrollmentProgramState = requisitionEnrollmentProgramState;
    }

    public RequisitionEnrollmentProgram(long requisitionDetailId, long personId, long programId, long periodId) {
        this.requisitionEnrollmentProgramPK = new RequisitionEnrollmentProgramPK(requisitionDetailId, personId, programId, periodId);
    }

    public RequisitionEnrollmentProgramPK getRequisitionEnrollmentProgramPK() {
        return requisitionEnrollmentProgramPK;
    }

    public void setRequisitionEnrollmentProgramPK(RequisitionEnrollmentProgramPK requisitionEnrollmentProgramPK) {
        this.requisitionEnrollmentProgramPK = requisitionEnrollmentProgramPK;
    }

    public Character getRequisitionEnrollmentProgramState() {
        return requisitionEnrollmentProgramState;
    }

    public void setRequisitionEnrollmentProgramState(Character requisitionEnrollmentProgramState) {
        this.requisitionEnrollmentProgramState = requisitionEnrollmentProgramState;
    }

    public EnrollmentProgram getEnrollmentProgram() {
        return enrollmentProgram;
    }

    public void setEnrollmentProgram(EnrollmentProgram enrollmentProgram) {
        this.enrollmentProgram = enrollmentProgram;
    }

    public RequisitionDetail getRequisitionDetail() {
        return requisitionDetail;
    }

    public void setRequisitionDetail(RequisitionDetail requisitionDetail) {
        this.requisitionDetail = requisitionDetail;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (requisitionEnrollmentProgramPK != null ? requisitionEnrollmentProgramPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RequisitionEnrollmentProgram)) {
            return false;
        }
        RequisitionEnrollmentProgram other = (RequisitionEnrollmentProgram) object;
        if ((this.requisitionEnrollmentProgramPK == null && other.requisitionEnrollmentProgramPK != null) || (this.requisitionEnrollmentProgramPK != null && !this.requisitionEnrollmentProgramPK.equals(other.requisitionEnrollmentProgramPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.system.demo.persistence.entity.RequisitionEnrollmentProgram[ requisitionEnrollmentProgramPK=" + requisitionEnrollmentProgramPK + " ]";
    }
    
}
