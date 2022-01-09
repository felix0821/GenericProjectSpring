/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.system.demo.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Felix
 */
@Entity
@Table(name = "role")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Role.findAll", query = "SELECT r FROM Role r"),
    @NamedQuery(name = "Role.findByIdRole", query = "SELECT r FROM Role r WHERE r.idRole = :idRole"),
    @NamedQuery(name = "Role.findByNameRole", query = "SELECT r FROM Role r WHERE r.nameRole = :nameRole"),
    @NamedQuery(name = "Role.findByState", query = "SELECT r FROM Role r WHERE r.state = :state"),
    @NamedQuery(name = "Role.findByDescription", query = "SELECT r FROM Role r WHERE r.description = :description")})
public class Role implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_role")
    private Long idRole;
    @Basic(optional = false)
    @Column(name = "name_role")
    private String nameRole;
    @Basic(optional = false)
    @Column(name = "registration_date")
    @Temporal(TemporalType.DATE)
    private Date registrationDate;
    @Basic(optional = false)
    private Character state;
    private String description;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "role", fetch = FetchType.LAZY)
    private Collection<UserRol> userRolCollection;

    public Role() {
    }

    public Role(Long idRole) {
        this.idRole = idRole;
    }
    
    

    public Role(Long idRole, String nameRole, Date registrationDate, Character state, String description,
			Collection<UserRol> userRolCollection) {
		super();
		this.idRole = idRole;
		this.nameRole = nameRole;
		this.registrationDate = registrationDate;
		this.state = state;
		this.description = description;
		this.userRolCollection = userRolCollection;
	}

	public Role(Long idRole, String nameRole, Character state, Date registrationDate) {
        this.idRole = idRole;
        this.nameRole = nameRole;
        this.state = state;
        this.registrationDate = registrationDate;
    }

    public Long getIdRole() {
        return idRole;
    }

    public void setIdRole(Long idRole) {
        this.idRole = idRole;
    }

    public String getNameRole() {
        return nameRole;
    }

    public void setNameRole(String nameRole) {
        this.nameRole = nameRole;
    }

    public Character getState() {
        return state;
    }

    public void setState(Character state) {
        this.state = state;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}

	@XmlTransient
    public Collection<UserRol> getUserRolCollection() {
        return userRolCollection;
    }

    public void setUserRolCollection(Collection<UserRol> userRolCollection) {
        this.userRolCollection = userRolCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRole != null ? idRole.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Role)) {
            return false;
        }
        Role other = (Role) object;
        if ((this.idRole == null && other.idRole != null) || (this.idRole != null && !this.idRole.equals(other.idRole))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "postulant_workplace.Role[ idRole=" + idRole + " ]";
    }
    
}
