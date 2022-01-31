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
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 *
 * @author Felix
 */
@Entity
@Table(name = "role", uniqueConstraints = {
	    @UniqueConstraint(columnNames = {"role_name"})})
@NamedQueries({
    @NamedQuery(name = "Role.findAll", query = "SELECT r FROM Role r"),
    @NamedQuery(name = "Role.findByRoleId", query = "SELECT r FROM Role r WHERE r.roleId = :roleId"),
    @NamedQuery(name = "Role.findByRoleName", query = "SELECT r FROM Role r WHERE r.roleName = :roleName"),
    @NamedQuery(name = "Role.findByRoleDescription", query = "SELECT r FROM Role r WHERE r.roleDescription = :roleDescription"),
    @NamedQuery(name = "Role.findByRoleState", query = "SELECT r FROM Role r WHERE r.roleState = :roleState"),
    @NamedQuery(name = "Role.findByRoleType", query = "SELECT r FROM Role r WHERE r.roleType = :roleType"),
    @NamedQuery(name = "Role.findByRoleNotPersonId", query = "SELECT r FROM Role r WHERE r.roleId NOT IN (SELECT p.personRolePK.roleId FROM PersonRole p WHERE p.personRolePK.personId = :personId)")})
public class Role implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "role_id", nullable = false)
    private Long roleId;
    @Basic(optional = false)
    @Column(name = "role_name", nullable = false, length = 64)
    private String roleName;
    @Column(name = "role_description", length = 128)
    private String roleDescription;
    @Basic(optional = false)
    @Column(name = "role_state", nullable = false)
    private Character roleState;
    @Basic(optional = false)
    @Column(name = "role_type", nullable = false)
    private Character roleType;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "role")
    @JsonIgnore
    private Collection<PersonRole> personRoleCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "role")
    @JsonIgnore
    private Collection<RequisitionAccessRole> requisitionAccessRoleCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "role")
    @JsonIgnore
    private Collection<Access> accessCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "role")
    @JsonIgnore
    private Collection<RoleView> roleViewCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "role")
    @JsonIgnore
    private Collection<PersonData> personDataCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "role")
    @JsonIgnore
    private Collection<RequisitionNotificationRole> requisitionNotificationRoleCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "role")
    @JsonIgnore
    private Collection<RoleContext> roleContextCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "role")
    @JsonIgnore
    private Collection<ReportRole> reportRoleCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "roleId")
    @JsonIgnore
    private Collection<EnrollmentCourse> enrollmentCourseCollection;

    public Role() {
    }

    public Role(Long roleId) {
        this.roleId = roleId;
    }

    public Role(Long roleId, String roleName, Character roleState, Character roleType) {
        this.roleId = roleId;
        this.roleName = roleName;
        this.roleState = roleState;
        this.roleType = roleType;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDescription() {
        return roleDescription;
    }

    public void setRoleDescription(String roleDescription) {
        this.roleDescription = roleDescription;
    }

    public Character getRoleState() {
        return roleState;
    }

    public void setRoleState(Character roleState) {
        this.roleState = roleState;
    }

    public Character getRoleType() {
        return roleType;
    }

    public void setRoleType(Character roleType) {
        this.roleType = roleType;
    }

    public Collection<PersonRole> getPersonRoleCollection() {
        return personRoleCollection;
    }

    public void setPersonRoleCollection(Collection<PersonRole> personRoleCollection) {
        this.personRoleCollection = personRoleCollection;
    }

    public Collection<RequisitionAccessRole> getRequisitionAccessRoleCollection() {
        return requisitionAccessRoleCollection;
    }

    public void setRequisitionAccessRoleCollection(Collection<RequisitionAccessRole> requisitionAccessRoleCollection) {
        this.requisitionAccessRoleCollection = requisitionAccessRoleCollection;
    }

    public Collection<Access> getAccessCollection() {
        return accessCollection;
    }

    public void setAccessCollection(Collection<Access> accessCollection) {
        this.accessCollection = accessCollection;
    }

    public Collection<RoleView> getRoleViewCollection() {
        return roleViewCollection;
    }

    public void setRoleViewCollection(Collection<RoleView> roleViewCollection) {
        this.roleViewCollection = roleViewCollection;
    }

    public Collection<PersonData> getPersonDataCollection() {
        return personDataCollection;
    }

    public void setPersonDataCollection(Collection<PersonData> personDataCollection) {
        this.personDataCollection = personDataCollection;
    }

    public Collection<RequisitionNotificationRole> getRequisitionNotificationRoleCollection() {
        return requisitionNotificationRoleCollection;
    }

    public void setRequisitionNotificationRoleCollection(Collection<RequisitionNotificationRole> requisitionNotificationRoleCollection) {
        this.requisitionNotificationRoleCollection = requisitionNotificationRoleCollection;
    }

    public Collection<RoleContext> getRoleContextCollection() {
        return roleContextCollection;
    }

    public void setRoleContextCollection(Collection<RoleContext> roleContextCollection) {
        this.roleContextCollection = roleContextCollection;
    }

    public Collection<ReportRole> getReportRoleCollection() {
        return reportRoleCollection;
    }

    public void setReportRoleCollection(Collection<ReportRole> reportRoleCollection) {
        this.reportRoleCollection = reportRoleCollection;
    }

    public Collection<EnrollmentCourse> getEnrollmentCourseCollection() {
        return enrollmentCourseCollection;
    }

    public void setEnrollmentCourseCollection(Collection<EnrollmentCourse> enrollmentCourseCollection) {
        this.enrollmentCourseCollection = enrollmentCourseCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (roleId != null ? roleId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Role)) {
            return false;
        }
        Role other = (Role) object;
        if ((this.roleId == null && other.roleId != null) || (this.roleId != null && !this.roleId.equals(other.roleId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.system.demo.model.Role[ roleId=" + roleId + " ]";
    }
    
}
