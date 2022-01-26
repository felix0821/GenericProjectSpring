package com.system.demo.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.system.demo.model.OccupationalField;
import com.system.demo.repository.OccupationalFieldRepository;
import com.system.demo.service.OccupationalFieldService;

@Service
@Transactional
public class OccupationalFieldServiceImplements implements OccupationalFieldService {

	@Autowired
	OccupationalFieldRepository occupationalFieldRepository;
	
	@Override
	public OccupationalField createOccupationalField(OccupationalField occupationalField) throws Exception {
		return occupationalFieldRepository.save(occupationalField);
	}

	@Override
	public void deleteOccupationalField(Long occupationalFieldId) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public OccupationalField getOccupationalFieldById(Long occupationalFieldId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OccupationalField> getOccupationalFieldByProgramId(Long programId) {
		return occupationalFieldRepository.findByProgramId(programId);
	}

}
