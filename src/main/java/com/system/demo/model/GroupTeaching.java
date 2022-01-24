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
@Table(name = "group_teaching")
@NamedQueries({
    @NamedQuery(name = "GroupTeaching.findAll", query = "SELECT g FROM GroupTeaching g"),
    @NamedQuery(name = "GroupTeaching.findByGroupId", query = "SELECT g FROM GroupTeaching g WHERE g.groupId = :groupId"),
    @NamedQuery(name = "GroupTeaching.findByGroupName", query = "SELECT g FROM GroupTeaching g WHERE g.groupName = :groupName"),
    @NamedQuery(name = "GroupTeaching.findByGroupAcronym", query = "SELECT g FROM GroupTeaching g WHERE g.groupAcronym = :groupAcronym"),
    @NamedQuery(name = "GroupTeaching.findByGroupState", query = "SELECT g FROM GroupTeaching g WHERE g.groupState = :groupState")})
public class GroupTeaching implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "group_id", nullable = false)
    private Long groupId;
    @Basic(optional = false)
    @Column(name = "group_name", nullable = false, length = 64)
    private String groupName;
    @Basic(optional = false)
    @Column(name = "group_acronym", nullable = false)
    private Character groupAcronym;
    @Basic(optional = false)
    @Column(name = "group_state", nullable = false)
    private Character groupState;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "groupTeaching")
    private Collection<CourseGroupTeaching> courseGroupTeachingCollection;

    public GroupTeaching() {
    }

    public GroupTeaching(Long groupId) {
        this.groupId = groupId;
    }

    public GroupTeaching(Long groupId, String groupName, Character groupAcronym, Character groupState) {
        this.groupId = groupId;
        this.groupName = groupName;
        this.groupAcronym = groupAcronym;
        this.groupState = groupState;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Character getGroupAcronym() {
        return groupAcronym;
    }

    public void setGroupAcronym(Character groupAcronym) {
        this.groupAcronym = groupAcronym;
    }

    public Character getGroupState() {
        return groupState;
    }

    public void setGroupState(Character groupState) {
        this.groupState = groupState;
    }

    public Collection<CourseGroupTeaching> getCourseGroupTeachingCollection() {
        return courseGroupTeachingCollection;
    }

    public void setCourseGroupTeachingCollection(Collection<CourseGroupTeaching> courseGroupTeachingCollection) {
        this.courseGroupTeachingCollection = courseGroupTeachingCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (groupId != null ? groupId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GroupTeaching)) {
            return false;
        }
        GroupTeaching other = (GroupTeaching) object;
        if ((this.groupId == null && other.groupId != null) || (this.groupId != null && !this.groupId.equals(other.groupId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.system.demo.model.GroupTeaching[ groupId=" + groupId + " ]";
    }
    
}
