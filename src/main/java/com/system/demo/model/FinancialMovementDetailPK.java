package com.system.demo.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
*
* @author Felix
*/
@Embeddable
public class FinancialMovementDetailPK implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1076614909181039800L;
	
	@Basic(optional = false)
    @Column(name = "id_requisition_detail")
    private long idRequisitionDetail;
	
	@Basic(optional = false)
    @Column(name = "id_financial_movement")
    private long idFinancialMovement;
    
    public FinancialMovementDetailPK() {};
    
    public FinancialMovementDetailPK(long idRequisitionDetail, long idFinancialMovement) {
    	this.idRequisitionDetail = idRequisitionDetail;
    	this.idFinancialMovement = idFinancialMovement;
    }

	public long getIdRequisitionDetail() {
		return idRequisitionDetail;
	}

	public void setIdRequisitionDetail(long idRequisitionDetail) {
		this.idRequisitionDetail = idRequisitionDetail;
	}

	public long getIdFinancialMovement() {
		return idFinancialMovement;
	}

	public void setIdFinancialMovement(long idFinancialMovement) {
		this.idFinancialMovement = idFinancialMovement;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (idFinancialMovement ^ (idFinancialMovement >>> 32));
		result = prime * result + (int) (idRequisitionDetail ^ (idRequisitionDetail >>> 32));
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
		FinancialMovementDetailPK other = (FinancialMovementDetailPK) obj;
		if (idFinancialMovement != other.idFinancialMovement)
			return false;
		if (idRequisitionDetail != other.idRequisitionDetail)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "FinancialMovementDetailPK [idRequisitionDetail=" + idRequisitionDetail + ", idFinancialMovement="
				+ idFinancialMovement + "]";
	}

}
