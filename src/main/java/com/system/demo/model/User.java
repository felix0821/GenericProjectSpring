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
import javax.persistence.Transient;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 *
 * @author Felix,Jose
 */
@Entity
@Table(name = "user")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u"),
    @NamedQuery(name = "User.findByIdUser", query = "SELECT u FROM User u WHERE u.idUser = :idUser"),
    @NamedQuery(name = "User.findByUsername", query = "SELECT u FROM User u WHERE u.username = :username"),
    @NamedQuery(name = "User.findByPassword", query = "SELECT u FROM User u WHERE u.password = :password"),
    @NamedQuery(name = "User.findByName", query = "SELECT u FROM User u WHERE u.name = :name"),
    @NamedQuery(name = "User.findByLastnameFather", query = "SELECT u FROM User u WHERE u.lastnameFather = :lastnameFather"),
    @NamedQuery(name = "User.findByLastnameMother", query = "SELECT u FROM User u WHERE u.lastnameMother = :lastnameMother"),
    @NamedQuery(name = "User.findByEmail", query = "SELECT u FROM User u WHERE u.email = :email"),
    @NamedQuery(name = "User.findByDni", query = "SELECT u FROM User u WHERE u.dni = :dni"),
    @NamedQuery(name = "User.findByDateBirth", query = "SELECT u FROM User u WHERE u.dateBirth = :dateBirth"),
    @NamedQuery(name = "User.findByRegistrationDate", query = "SELECT u FROM User u WHERE u.registrationDate = :registrationDate"),
    @NamedQuery(name = "User.findByState", query = "SELECT u FROM User u WHERE u.state = :state")})
public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
    @Basic(optional = false)
    @Column(name = "id_user")
    private Long idUser;
    @Basic(optional = false)
    @Column(name = "username")
    private String username;
    @Basic(optional = false)
    @Column(name = "password")
    private String password;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "lastname_father")
    private String lastnameFather;
    @Basic(optional = false)
    @Column(name = "lastname_mother")
    private String lastnameMother;
    @Basic(optional = false)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @Column(name = "dni")
    private String dni;
    @Basic(optional = false)
    @Column(name = "date_birth")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateBirth;
    @Basic(optional = false)
    @Column(name = "registration_date")
    @Temporal(TemporalType.DATE)
    private Date registrationDate;
    @Column(name = "url_profilepicture")
    private String urlProfilepicture;
    @Basic(optional = false)
    @Column(name = "state")
    private Character state;
    @Column(name = "modifyin_user")
    private Long modifyingUser;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user", fetch = FetchType.LAZY)
    private Collection<UserRol> userRolCollection;
    
    @Transient
    @JsonIgnore
	private String confirmPassword;

    public User() {}

    public User(Long idUser) {
        this.idUser = idUser;
    }

    public User(Long idUser, String username, String password, String name, String lastnameFather,
			String lastnameMother, String email, String dni, Date dateBirth, Date registrationDate,
			String urlProfilepicture, Character state, Long modifyingUser) {
		super();
		this.idUser = idUser;
		this.username = username;
		this.password = password;
		this.name = name;
		this.lastnameFather = lastnameFather;
		this.lastnameMother = lastnameMother;
		this.email = email;
		this.dni = dni;
		this.dateBirth = dateBirth;
		this.registrationDate = registrationDate;
		this.urlProfilepicture = urlProfilepicture;
		this.state = state;
		this.modifyingUser = modifyingUser;
	}
    
    public User(Long idUser, String username, String password, String name, String lastnameFather, String lastnameMother, 
    		String email, String dni, Date dateBirth, Date registrationDate, Character state) {
        this.idUser = idUser;
        this.username = username;
        this.password = password;
        this.name = name;
        this.lastnameFather = lastnameFather;
        this.lastnameMother = lastnameMother;
        this.email = email;
        this.dni = dni;
        this.dateBirth = dateBirth;
        this.registrationDate = registrationDate;
        this.state = state;
    }

	public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastnameFather() {
        return lastnameFather;
    }

    public void setLastnameFather(String lastnameFather) {
        this.lastnameFather = lastnameFather;
    }

    public String getLastnameMother() {
        return lastnameMother;
    }

    public void setLastnameMother(String lastnameMother) {
        this.lastnameMother = lastnameMother;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Date getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(Date dateBirth) {
        this.dateBirth = dateBirth;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getUrlProfilepicture() {
        return urlProfilepicture;
    }

    public void setUrlProfilepicture(String urlProfilepicture) {
        this.urlProfilepicture = urlProfilepicture;
    }

    public Character getState() {
        return state;
    }

    public void setState(Character state) {
        this.state = state;
    }

    public Long getModifyingUser() {
		return modifyingUser;
	}

	public void setModifyingUser(Long modifyingUser) {
		this.modifyingUser = modifyingUser;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
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
        hash += (idUser != null ? idUser.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.idUser == null && other.idUser != null) || (this.idUser != null && !this.idUser.equals(other.idUser))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "system.User[ idUser=" + idUser + " ]";
    }

}
