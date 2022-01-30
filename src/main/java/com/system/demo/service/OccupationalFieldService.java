package com.system.demo.service;

import java.util.List;

import com.system.demo.persistence.entity.OccupationalField;

public interface OccupationalFieldService {
	
	public OccupationalField createOccupationalField(OccupationalField occupationalField) throws Exception;
	public void deleteOccupationalField(Long occupationalFieldId) throws Exception;
	
	public OccupationalField getOccupationalFieldById(Long occupationalFieldId) throws Exception;
	
	public List<OccupationalField> getOccupationalFieldByProgramId(Long programId);

}
