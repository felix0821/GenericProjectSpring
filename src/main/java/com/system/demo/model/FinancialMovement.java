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
@Table(name = "financial_movement")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FinancialMovement.findAll", query = "SELECT r FROM FinancialMovement r"),
    @NamedQuery(name = "FinancialMovement.findByIdFinancialMovement", query = "SELECT r FROM FinancialMovement r WHERE r.idFinancialMovement = :idFinancialMovement"),
    @NamedQuery(name = "FinancialMovement.findByName", query = "SELECT r FROM FinancialMovement r WHERE r.name = :name"),
    @NamedQuery(name = "FinancialMovement.findByState", query = "SELECT r FROM FinancialMovement r WHERE r.state = :state"),
    @NamedQuery(name = "FinancialMovement.findBySymbol", query = "SELECT r FROM FinancialMovement r WHERE r.symbol = :symbol"),
    @NamedQuery(name = "FinancialMovement.findByType", query = "SELECT r FROM FinancialMovement r WHERE r.type = :type")})
public class FinancialMovement implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
    @Basic(optional = false)
    @Column(name = "id_financial_movement")
    private Long idFinancialMovement;
	
	@Basic(optional = false)
    @Column(name = "name")
    private String name;
	
	@Basic(optional = false)
    @Column(name = "symbol")
    private String symbol;
	
	@Basic(optional = false)
    @Column(name = "type")
    private Character type;
	
	@Basic(optional = false)
    @Column(name = "state")
    private Character state;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "financialMovement", fetch = FetchType.EAGER)
    private Collection<FinancialMovementDetail> financialMovementDetailCollection;

	public FinancialMovement() {}

	public FinancialMovement(Long idFinancialMovement, String name, String symbol, Character type, Character state) {
		super();
		this.idFinancialMovement = idFinancialMovement;
		this.name = name;
		this.symbol = symbol;
		this.type = type;
		this.state = state;
	}

	public Long getIdFinancialMovement() {
		return idFinancialMovement;
	}

	public void setIdFinancialMovement(Long idFinancialMovement) {
		this.idFinancialMovement = idFinancialMovement;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public Character getType() {
		return type;
	}

	public void setType(Character type) {
		this.type = type;
	}

	public Character getState() {
		return state;
	}

	public void setState(Character state) {
		this.state = state;
	}

	@XmlTransient
	public Collection<FinancialMovementDetail> getFinancialMovementDetail() {
		return financialMovementDetailCollection;
	}

	public void setFinancialMovementDetail(Collection<FinancialMovementDetail> financialMovementDetailCollection) {
		this.financialMovementDetailCollection = financialMovementDetailCollection;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((financialMovementDetailCollection == null) ? 0 : financialMovementDetailCollection.hashCode());
		result = prime * result + ((idFinancialMovement == null) ? 0 : idFinancialMovement.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		result = prime * result + ((symbol == null) ? 0 : symbol.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		FinancialMovement other = (FinancialMovement) obj;
		if (financialMovementDetailCollection == null) {
			if (other.financialMovementDetailCollection != null)
				return false;
		} else if (!financialMovementDetailCollection.equals(other.financialMovementDetailCollection))
			return false;
		if (idFinancialMovement == null) {
			if (other.idFinancialMovement != null)
				return false;
		} else if (!idFinancialMovement.equals(other.idFinancialMovement))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		if (symbol == null) {
			if (other.symbol != null)
				return false;
		} else if (!symbol.equals(other.symbol))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "FinancialMovement [idFinancialMovement=" + idFinancialMovement + ", name=" + name + ", symbol=" + symbol
				+ ", type=" + type + ", state=" + state + ", financialMovementDetail=" + financialMovementDetailCollection + "]";
	};
	
}
