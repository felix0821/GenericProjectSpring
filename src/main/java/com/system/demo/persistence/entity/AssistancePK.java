/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.system.demo.persistence.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Felix
 */
@Embeddable
public class AssistancePK implements Serializable {

    @Basic(optional = false)
    @Column(name = "horary_id", nullable = false)
    private long horaryId;
    @Basic(optional = false)
    @Column(name = "person_id", nullable = false)
    private long personId;
    @Basic(optional = false)
    @Column(name = "course_detail_id", nullable = false)
    private long courseDetailId;

    public AssistancePK() {
    }

    public AssistancePK(long horaryId, long personId, long courseDetailId) {
        this.horaryId = horaryId;
        this.personId = personId;
        this.courseDetailId = courseDetailId;
    }

    public long getHoraryId() {
        return horaryId;
    }

    public void setHoraryId(long horaryId) {
        this.horaryId = horaryId;
    }

    public long getPersonId() {
        return personId;
    }

    public void setPersonId(long personId) {
        this.personId = personId;
    }

    public long getCourseDetailId() {
        return courseDetailId;
    }

    public void setCourseDetailId(long courseDetailId) {
        this.courseDetailId = courseDetailId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) horaryId;
        hash += (int) personId;
        hash += (int) courseDetailId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AssistancePK)) {
            return false;
        }
        AssistancePK other = (AssistancePK) object;
        if (this.horaryId != other.horaryId) {
            return false;
        }
        if (this.personId != other.personId) {
            return false;
        }
        if (this.courseDetailId != other.courseDetailId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.system.demo.model.AssistancePK[ horaryId=" + horaryId + ", personId=" + personId + ", courseDetailId=" + courseDetailId + " ]";
    }
    
}
