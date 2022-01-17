package com.system.demo.model;

import java.io.Serializable;
import java.util.Collection;

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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "requisition")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Requisition.findAll", query = "SELECT r FROM Requisition r"),
    @NamedQuery(name = "Requisition.findByIdRequisition", query = "SELECT r FROM Requisition r WHERE r.idRequisition = :idRequisition"),
    @NamedQuery(name = "Requisition.findByName", query = "SELECT r FROM Requisition r WHERE r.name = :name"),
    @NamedQuery(name = "Requisition.findByState", query = "SELECT r FROM Requisition r WHERE r.state = :state"),
    @NamedQuery(name = "Requisition.findByDescription", query = "SELECT r FROM Requisition r WHERE r.description = :description")})
public class Requisition implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
    @Basic(optional = false)
    @Column(name = "id_requisition")
    private Long idRequisition;
	
	@Basic(optional = false)
    @Column(name = "name")
    private String name;
	
	@Basic(optional = false)
    @Column(name = "state")
    private Character state;
	
	@Basic(optional = true)
    @Column(name = "description")
    private String description;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "requisition", fetch = FetchType.EAGER)
    private Collection<RequisitionDetail> requisitionDetailCollection;

	public Requisition() {};
	
	public Requisition(Long idRequisition, String name, Character state, String description) {
		super();
		this.idRequisition = idRequisition;
		this.name = name;
		this.state = state;
		this.description = description;
	}

	public Long getIdRequisition() {
		return idRequisition;
	}

	public void setIdRequisition(Long idRequisition) {
		this.idRequisition = idRequisition;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	@XmlTransient
	public Collection<RequisitionDetail> getRequisitionDetailCollection() {
		return requisitionDetailCollection;
	}

	public void setRequisitionDetailCollection(Collection<RequisitionDetail> requisitionDetailCollection) {
		this.requisitionDetailCollection = requisitionDetailCollection;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((idRequisition == null) ? 0 : idRequisition.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((requisitionDetailCollection == null) ? 0 : requisitionDetailCollection.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
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
		Requisition other = (Requisition) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (idRequisition == null) {
			if (other.idRequisition != null)
				return false;
		} else if (!idRequisition.equals(other.idRequisition))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (requisitionDetailCollection == null) {
			if (other.requisitionDetailCollection != null)
				return false;
		} else if (!requisitionDetailCollection.equals(other.requisitionDetailCollection))
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Requisition [idRequisition=" + idRequisition + ", name=" + name + ", state=" + state + ", description="
				+ description + ", requisitionDetailCollection=" + requisitionDetailCollection + "]";
	}

}
