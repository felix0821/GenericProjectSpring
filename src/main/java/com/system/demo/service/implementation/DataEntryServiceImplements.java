package com.system.demo.service.implementation;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.system.demo.persistence.entity.DataEntry;
import com.system.demo.persistence.repository.DataEntryRepository;
import com.system.demo.service.DataEntryService;

@Service
@Transactional
public class DataEntryServiceImplements implements DataEntryService {
	
	@Autowired
	DataEntryRepository dataEntryRepository;

	@Override
	public DataEntry createDataEntry(DataEntry dataEntry) throws Exception {
		return dataEntryRepository.save(dataEntry);
	}

}
