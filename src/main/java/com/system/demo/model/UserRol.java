/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.system.demo.model;

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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Felix
 */
@Entity
@Table(name = "user_rol")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserRol.findAll", query = "SELECT u FROM UserRol u"),
    @NamedQuery(name = "UserRol.findByIdUser", query = "SELECT u FROM UserRol u WHERE u.userRolPK.idUser = :idUser"),
    @NamedQuery(name = "UserRol.findByIdRole", query = "SELECT u FROM UserRol u WHERE u.userRolPK.idRole = :idRole"),
    @NamedQuery(name = "UserRol.findByState", query = "SELECT u FROM UserRol u WHERE u.state = :state")})
public class UserRol implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected UserRolPK userRolPK;
    @Basic(optional = false)
    @Column(name = "state")
    private Character state;
    @JoinColumn(name = "id_role", referencedColumnName = "id_role", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Role role;
    @JoinColumn(name = "id_user", referencedColumnName = "id_user", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private User user;

    public UserRol() {
    }

    public UserRol(UserRolPK userRolPK) {
        this.userRolPK = userRolPK;
    }

    public UserRol(UserRolPK userRolPK, Character state) {
        this.userRolPK = userRolPK;
        this.state = state;
    }

    public UserRol(long idUser, long idRole) {
        this.userRolPK = new UserRolPK(idUser, idRole);
    }

    public UserRolPK getUserRolPK() {
        return userRolPK;
    }

    public void setUserRolPK(UserRolPK userRolPK) {
        this.userRolPK = userRolPK;
    }

    public Character getState() {
        return state;
    }

    public void setState(Character state) {
        this.state = state;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userRolPK != null ? userRolPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserRol)) {
            return false;
        }
        UserRol other = (UserRol) object;
        if ((this.userRolPK == null && other.userRolPK != null) || (this.userRolPK != null && !this.userRolPK.equals(other.userRolPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "vacancies_application_system.UserRol[ userRolPK=" + userRolPK + " ]";
    }
    
}
