package com.system.demo.service;

import com.system.demo.model.OccupationalField;

public interface OccupationalFieldService {
	
	public OccupationalField createOccupationalField(OccupationalField occupationalField) throws Exception;
	public void deleteOccupationalField(Long occupationalFieldId) throws Exception;
	
	public OccupationalField getOccupationalFieldById(Long occupationalFieldId) throws Exception;

}
