package com.system.demo.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "financial_movement_detail")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FinancialMovementDetail.findAll", query = "SELECT u FROM FinancialMovementDetail u"),
    @NamedQuery(name = "FinancialMovementDetail.findByIdFinancialMovement", query = "SELECT u FROM FinancialMovementDetail u WHERE u.financialMovementDetailPK.idFinancialMovement = :idFinancialMovement"),
    @NamedQuery(name = "FinancialMovementDetail.findByIdRequisitionDetail", query = "SELECT u FROM FinancialMovementDetail u WHERE u.financialMovementDetailPK.idRequisitionDetail = :idRequisitionDetail"),
    @NamedQuery(name = "FinancialMovementDetail.findByRegistrationDate", query = "SELECT u FROM FinancialMovementDetail u WHERE u.registrationDate = :registrationDate")})
public class FinancialMovementDetail implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
    protected FinancialMovementDetailPK financialMovementDetailPK;
	
	@Basic(optional = true)
    @Column(name = "amount")
    private Double amount;
	
	@Basic(optional = false) 
    @Column(name = "registration_date")
    @Temporal(TemporalType.DATE)
    private Date registrationDate;
	
	@JoinColumn(name = "id_financial_movement", referencedColumnName = "id_financial_movement", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private FinancialMovement financialMovement;
	
	@JoinColumn(name = "id_requisition_detail", referencedColumnName = "id_requisition_detail", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private RequisitionDetail requisitionDetail;

	public FinancialMovementDetail() {};
	
	public FinancialMovementDetail(FinancialMovementDetailPK financialMovementDetailPK) {
		this.financialMovementDetailPK = financialMovementDetailPK;
	}
	
	public FinancialMovementDetail(long idRequisitionDetail, long idFinancialMovement) {
		this.financialMovementDetailPK = new FinancialMovementDetailPK(idRequisitionDetail,idFinancialMovement);
	}

	public FinancialMovementDetailPK getFinancialMovementDetailPK() {
		return financialMovementDetailPK;
	}

	public void setFinancialMovementDetailPK(FinancialMovementDetailPK financialMovementDetailPK) {
		this.financialMovementDetailPK = financialMovementDetailPK;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}

	public FinancialMovement getFinancialMovement() {
		return financialMovement;
	}

	public void setFinancialMovement(FinancialMovement financialMovement) {
		this.financialMovement = financialMovement;
	}

	public RequisitionDetail getRequisitionDetail() {
		return requisitionDetail;
	}

	public void setRequisitionDetail(RequisitionDetail requisitionDetail) {
		this.requisitionDetail = requisitionDetail;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((amount == null) ? 0 : amount.hashCode());
		result = prime * result + ((financialMovement == null) ? 0 : financialMovement.hashCode());
		result = prime * result + ((financialMovementDetailPK == null) ? 0 : financialMovementDetailPK.hashCode());
		result = prime * result + ((registrationDate == null) ? 0 : registrationDate.hashCode());
		result = prime * result + ((requisitionDetail == null) ? 0 : requisitionDetail.hashCode());
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
		FinancialMovementDetail other = (FinancialMovementDetail) obj;
		if (amount == null) {
			if (other.amount != null)
				return false;
		} else if (!amount.equals(other.amount))
			return false;
		if (financialMovement == null) {
			if (other.financialMovement != null)
				return false;
		} else if (!financialMovement.equals(other.financialMovement))
			return false;
		if (financialMovementDetailPK == null) {
			if (other.financialMovementDetailPK != null)
				return false;
		} else if (!financialMovementDetailPK.equals(other.financialMovementDetailPK))
			return false;
		if (registrationDate == null) {
			if (other.registrationDate != null)
				return false;
		} else if (!registrationDate.equals(other.registrationDate))
			return false;
		if (requisitionDetail == null) {
			if (other.requisitionDetail != null)
				return false;
		} else if (!requisitionDetail.equals(other.requisitionDetail))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "FinancialMovementDetail [financialMovementDetailPK=" + financialMovementDetailPK + ", amount=" + amount
				+ ", registrationDate=" + registrationDate + ", financialMovement=" + financialMovement
				+ ", requisitionDetail=" + requisitionDetail + "]";
	}

}
