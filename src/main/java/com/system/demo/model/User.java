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
		final int prime = 31;
		int result = 1;
		result = prime * result + ((confirmPassword == null) ? 0 : confirmPassword.hashCode());
		result = prime * result + ((dateBirth == null) ? 0 : dateBirth.hashCode());
		result = prime * result + ((dni == null) ? 0 : dni.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((idUser == null) ? 0 : idUser.hashCode());
		result = prime * result + ((lastnameFather == null) ? 0 : lastnameFather.hashCode());
		result = prime * result + ((lastnameMother == null) ? 0 : lastnameMother.hashCode());
		result = prime * result + ((modifyingUser == null) ? 0 : modifyingUser.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((registrationDate == null) ? 0 : registrationDate.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		result = prime * result + ((urlProfilepicture == null) ? 0 : urlProfilepicture.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (confirmPassword == null) {
			if (other.confirmPassword != null)
				return false;
		} else if (!confirmPassword.equals(other.confirmPassword))
			return false;
		if (dateBirth == null) {
			if (other.dateBirth != null)
				return false;
		} else if (!dateBirth.equals(other.dateBirth))
			return false;
		if (dni == null) {
			if (other.dni != null)
				return false;
		} else if (!dni.equals(other.dni))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (idUser == null) {
			if (other.idUser != null)
				return false;
		} else if (!idUser.equals(other.idUser))
			return false;
		if (lastnameFather == null) {
			if (other.lastnameFather != null)
				return false;
		} else if (!lastnameFather.equals(other.lastnameFather))
			return false;
		if (lastnameMother == null) {
			if (other.lastnameMother != null)
				return false;
		} else if (!lastnameMother.equals(other.lastnameMother))
			return false;
		if (modifyingUser == null) {
			if (other.modifyingUser != null)
				return false;
		} else if (!modifyingUser.equals(other.modifyingUser))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (registrationDate == null) {
			if (other.registrationDate != null)
				return false;
		} else if (!registrationDate.equals(other.registrationDate))
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		if (urlProfilepicture == null) {
			if (other.urlProfilepicture != null)
				return false;
		} else if (!urlProfilepicture.equals(other.urlProfilepicture))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [idUser=" + idUser + ", username=" + username + ", password=" + password + ", name=" + name
				+ ", lastnameFather=" + lastnameFather + ", lastnameMother=" + lastnameMother + ", email=" + email
				+ ", dni=" + dni + ", dateBirth=" + dateBirth + ", registrationDate=" + registrationDate
				+ ", urlProfilepicture=" + urlProfilepicture + ", state=" + state + ", modifyingUser=" + modifyingUser
				+ ", confirmPassword=" + confirmPassword + "]";
	}

}
