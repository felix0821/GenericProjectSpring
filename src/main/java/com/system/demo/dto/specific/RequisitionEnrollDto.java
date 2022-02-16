package com.system.demo.dto.specific;

import java.util.List;

public class RequisitionEnrollDto {
	
	private Long requisitionId;
	
	private String requisitionName;
	
	private Long programId;
	
	private String programName;
	
	private Long periodId;
	
	private String periodName;
	
	private List<DataDto> list;

	public RequisitionEnrollDto(Long requisitionId, String requisitionName, Long programId, String programName,
			Long periodId, String periodName) {
		super();
		this.requisitionId = requisitionId;
		this.requisitionName = requisitionName;
		this.programId = programId;
		this.programName = programName;
		this.periodId = periodId;
		this.periodName = periodName;
	}

	public Long getRequisitionId() {
		return requisitionId;
	}

	public void setRequisitionId(Long requisitionId) {
		this.requisitionId = requisitionId;
	}

	public String getRequisitionName() {
		return requisitionName;
	}

	public void setRequisitionName(String requisitionName) {
		this.requisitionName = requisitionName;
	}

	public Long getProgramId() {
		return programId;
	}

	public void setProgramId(Long programId) {
		this.programId = programId;
	}

	public String getProgramName() {
		return programName;
	}

	public void setProgramName(String programName) {
		this.programName = programName;
	}

	public Long getPeriodId() {
		return periodId;
	}

	public void setPeriodId(Long periodId) {
		this.periodId = periodId;
	}

	public String getPeriodName() {
		return periodName;
	}

	public void setPeriodName(String periodName) {
		this.periodName = periodName;
	}

	public List<DataDto> getList() {
		return list;
	}

	public void setList(List<DataDto> list) {
		this.list = list;
	}

}
