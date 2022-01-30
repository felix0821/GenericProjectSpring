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
public class HoraryCourseGroupPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "horary_id", nullable = false)
    private long horaryId;
    @Basic(optional = false)
    @Column(name = "course_detail_id", nullable = false)
    private long courseDetailId;

    public HoraryCourseGroupPK() {
    }

    public HoraryCourseGroupPK(long horaryId, long courseDetailId) {
        this.horaryId = horaryId;
        this.courseDetailId = courseDetailId;
    }

    public long getHoraryId() {
        return horaryId;
    }

    public void setHoraryId(long horaryId) {
        this.horaryId = horaryId;
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
        hash += (int) courseDetailId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HoraryCourseGroupPK)) {
            return false;
        }
        HoraryCourseGroupPK other = (HoraryCourseGroupPK) object;
        if (this.horaryId != other.horaryId) {
            return false;
        }
        if (this.courseDetailId != other.courseDetailId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.system.demo.model.HoraryCourseGroupPK[ horaryId=" + horaryId + ", courseDetailId=" + courseDetailId + " ]";
    }
    
}
