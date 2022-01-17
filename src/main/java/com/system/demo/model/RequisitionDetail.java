package com.system.demo.model;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "requisition_detail")
@XmlRootElement
@NamedQueries({
   @NamedQuery(name = "RequisitionDetail.findAll", query = "SELECT u FROM RequisitionDetail u"),
   @NamedQuery(name = "RequisitionDetail.findByIdRequisitionDetail", query = "SELECT u FROM RequisitionDetail u WHERE u.idRequisitionDetail = :idRequisitionDetail")})
public class RequisitionDetail implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
    @Basic(optional = false)
    @Column(name = "id_requisition_detail")
    private Long idRequisitionDetail;
	
	@Basic(optional = true)
    @Column(name = "bank")
    private String bank;
	
	@Basic(optional = true)
    @Column(name = "document")
    private String document;
	
	@Basic(optional = true)
    @Column(name = "observation")
    private String observation;
	
	@JoinColumn(name = "id_requisition", referencedColumnName = "id_requisition", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Requisition requisition;
	
	@JoinColumn(name = "id_person", referencedColumnName = "id_person", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Person person;
	
	@JoinColumn(name = "id_requisition_status", referencedColumnName = "id_requisition_status", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private RequisitionStatus requisitionStatus;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "requisitionDetail")
    private Collection<FinancialMovementDetail> financialMovementDetail;

	public RequisitionDetail(){};
	
	public RequisitionDetail(Long idRequisitionDetail, String bank, String document, String observation,
			Requisition requisition, Person person) {
		super();
		this.idRequisitionDetail = idRequisitionDetail;
		this.bank = bank;
		this.document = document;
		this.observation = observation;
		this.requisition = requisition;
		this.person = person;
	}

	public Long getIdRequisitionDetail() {
		return idRequisitionDetail;
	}

	public void setIdRequisitionDetail(Long idRequisitionDetail) {
		this.idRequisitionDetail = idRequisitionDetail;
	}

	public String getBank() {
		return bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	public String getDocument() {
		return document;
	}

	public void setDocument(String document) {
		this.document = document;
	}

	public String getObservation() {
		return observation;
	}

	public void setObservation(String observation) {
		this.observation = observation;
	}

	public Requisition getRequisition() {
		return requisition;
	}

	public void setRequisition(Requisition requisition) {
		this.requisition = requisition;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	@XmlTransient
	public Collection<FinancialMovementDetail> getFinancialMovementDetail() {
		return financialMovementDetail;
	}

	public void setFinancialMovementDetail(Collection<FinancialMovementDetail> financialMovementDetail) {
		this.financialMovementDetail = financialMovementDetail;
	}

	public RequisitionStatus getRequisitionStatus() {
		return requisitionStatus;
	}

	public void setRequisitionStatus(RequisitionStatus requisitionStatus) {
		this.requisitionStatus = requisitionStatus;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bank == null) ? 0 : bank.hashCode());
		result = prime * result + ((document == null) ? 0 : document.hashCode());
		result = prime * result + ((financialMovementDetail == null) ? 0 : financialMovementDetail.hashCode());
		result = prime * result + ((idRequisitionDetail == null) ? 0 : idRequisitionDetail.hashCode());
		result = prime * result + ((observation == null) ? 0 : observation.hashCode());
		result = prime * result + ((person == null) ? 0 : person.hashCode());
		result = prime * result + ((requisition == null) ? 0 : requisition.hashCode());
		result = prime * result + ((requisitionStatus == null) ? 0 : requisitionStatus.hashCode());
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
		RequisitionDetail other = (RequisitionDetail) obj;
		if (bank == null) {
			if (other.bank != null)
				return false;
		} else if (!bank.equals(other.bank))
			return false;
		if (document == null) {
			if (other.document != null)
				return false;
		} else if (!document.equals(other.document))
			return false;
		if (financialMovementDetail == null) {
			if (other.financialMovementDetail != null)
				return false;
		} else if (!financialMovementDetail.equals(other.financialMovementDetail))
			return false;
		if (idRequisitionDetail == null) {
			if (other.idRequisitionDetail != null)
				return false;
		} else if (!idRequisitionDetail.equals(other.idRequisitionDetail))
			return false;
		if (observation == null) {
			if (other.observation != null)
				return false;
		} else if (!observation.equals(other.observation))
			return false;
		if (person == null) {
			if (other.person != null)
				return false;
		} else if (!person.equals(other.person))
			return false;
		if (requisition == null) {
			if (other.requisition != null)
				return false;
		} else if (!requisition.equals(other.requisition))
			return false;
		if (requisitionStatus == null) {
			if (other.requisitionStatus != null)
				return false;
		} else if (!requisitionStatus.equals(other.requisitionStatus))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "RequisitionDetail [idRequisitionDetail=" + idRequisitionDetail + ", bank=" + bank + ", document="
				+ document + ", observation=" + observation + ", requisition=" + requisition + ", person=" + person
				+ ", financialMovementDetail=" + financialMovementDetail + "]";
	}

}
